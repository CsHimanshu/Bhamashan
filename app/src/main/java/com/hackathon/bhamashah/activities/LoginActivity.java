package com.hackathon.bhamashah.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hackathon.bhamashah.MainActivity;
import com.hackathon.bhamashah.R;
import com.hackathon.bhamashah.bean.Login.FamilyDetailsBean;
import com.hackathon.bhamashah.bean.Login.HofDetailsBean;
import com.hackathon.bhamashah.bean.LoginAPIResponse;
import com.hackathon.bhamashah.data.local.AppData;
import com.hackathon.bhamashah.data.local.SharedPreferences;
import com.hackathon.bhamashah.data.local.User;
import com.hackathon.bhamashah.data.remote.RemoteClient;
import com.hackathon.bhamashah.data.remote.ResponseHandler;
import com.hackathon.bhamashah.data.remote.api.SuccessInferface;
import com.hackathon.bhamashah.utilities.AppUtils;
import com.hackathon.bhamashah.utilities.Constants;

import java.util.List;

import retrofit2.Call;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity{


    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private ViewGroup  layoutOtp;
    private Button mEmailSignInButton;
    private boolean hasOTP=false;
    private int OTP=-1;
    private String selectedEmail="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        layoutOtp = (ViewGroup)findViewById(R.id.login_otp_layout);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        mEmailView.setText(Constants.BFamilyID);
//        showLoginDetails();
    }

//    void showLoginDetails(){
//        Log.d("TEST", "showLoginDetails: -- Going to call this method");
//        HofDetailsBean hofDetailsBean = AppData.getInstance().getUser().getHoFDetails();
//        Log.d("TEST", "showLoginDetails: -- Home Detail : " +hofDetailsBean);
//
//        List<FamilyDetailsBean> familyDetailsBeans = AppData.getInstance().getUser().getFamily_Details();
//        Log.d("TEST", "showLoginDetails: -- Family Detail : " +familyDetailsBeans);
//        if(familyDetailsBeans==null)
//            return;
//        for (FamilyDetailsBean familyDetailsBean : familyDetailsBeans) {
//            Log.d("TEST", "showLoginDetails: -- " +familyDetailsBean);
//            Log.d("TEST", "showLoginDetails: -- " +familyDetailsBean.getNAME_ENG());
//        }
//    }



    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {


        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isOTPValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isBIDValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);

            if(hasOTP){
                hitLoginApi();
            }else{
                hitGenerateOTP();
            }
        }
    }

    private boolean isBIDValid(String bid) {
        //TODO: Replace this with your own logic
        return bid.length()==7;
    }

    private boolean isOTPValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() == 5;
    }

    private void showProgress(boolean isShow){
        if(isShow){
            mProgressView.setVisibility(View.VISIBLE);
        }else{
            mProgressView.setVisibility(View.GONE);
        }
    }

    private void hitLoginApi(){
        showProgress(false);
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        if(email.equalsIgnoreCase(selectedEmail) && password.equalsIgnoreCase(String.valueOf(OTP))){
            SharedPreferences.putBoolean(SharedPreferences.KEY_IsLOGIN,true,this);
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    private void hitGenerateOTP(){
        //Successful
        String BFamilyId = mEmailView.getText().toString();
        Call<LoginAPIResponse> testCall = RemoteClient.getApiInterface().getLoginAPIResponse("login",BFamilyId);
        testCall.enqueue(new ResponseHandler<LoginAPIResponse>(this, 1, new SuccessInferface<LoginAPIResponse>() {
            @Override
            public void onResponse(int id, LoginAPIResponse loginAPIResponse) {
                Log.d("TEST", "onResponse: " + loginAPIResponse);


                String mobileNumber= loginAPIResponse.getData().getDetails().getMobileNumber();
                String bid= loginAPIResponse.getData().getDetails().getBhamashahId();
                HofDetailsBean hofDetailsBean = loginAPIResponse.getData().getProfileData().getHof_Details();
                List<FamilyDetailsBean> family_details= loginAPIResponse.getData().getProfileData().getFamily_Details();

                User user = new User(mobileNumber,bid,hofDetailsBean,family_details);
                AppData.getInstance().setUser(user);
                selectedEmail=mEmailView.getText().toString();
                OTP= loginAPIResponse.getData().getDetails().getOtp();
                //save the remove
                AppUtils.updateUI(LoginActivity.this, new Runnable() {
                    @Override
                    public void run() {
                        showProgress(false);
                        hasOTP=true;
                        layoutOtp.setVisibility(View.VISIBLE);
                        mPasswordView.setHint("OTP (dummy value is : " + OTP+")");
                        mEmailSignInButton.setText("Signin");
                    }
                });

            }
        },null));
    }
}

