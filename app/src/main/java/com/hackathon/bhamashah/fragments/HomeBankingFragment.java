package com.hackathon.bhamashah.fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hackathon.bhamashah.R;
import com.hackathon.bhamashah.base.BaseFragment;
import com.hackathon.bhamashah.bean.CheckAmoutApiResponse;
import com.hackathon.bhamashah.bean.Login.HofDetailsBean;
import com.hackathon.bhamashah.bean.RequestAmountApiResponse;
import com.hackathon.bhamashah.data.local.AppData;
import com.hackathon.bhamashah.data.remote.RemoteClient;
import com.hackathon.bhamashah.data.remote.ResponseHandler;
import com.hackathon.bhamashah.data.remote.api.SuccessInferface;
import com.hackathon.bhamashah.utilities.AppUtils;

import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeBankingFragment extends BaseFragment {


    private View myView;
    private String isExpressDelivery="0";
    private TextView textView;
    private AutoCompleteTextView editTextAmount;
    private AutoCompleteTextView autoCompleteTextViewComments;

    public HomeBankingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myView = inflater.inflate(R.layout.fragment_home_banking, container, false);
        textView = (TextView) myView .findViewById(R.id.tv_choice);
        textView.setText(R.string.normal_delivery_text);
        editTextAmount = (AutoCompleteTextView) myView.findViewById(R.id.amt);
        autoCompleteTextViewComments = (AutoCompleteTextView) myView.findViewById(R.id.comments);

        Button button_request = (Button) myView.findViewById(R.id.button_request);
        button_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextAmount.setError(null);
                String amount = editTextAmount.getText().toString();
                if(!TextUtils.isEmpty(amount) ){
                    requestAmount(amount,autoCompleteTextViewComments.getText().toString());

                }else{
                    editTextAmount.setError(getString(R.string.request_amt_error));
                }
            }
        });
        RadioGroup radioGroup = (RadioGroup) myView .findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch(checkedId) {
                    case R.id.radio_nominal:
                        // switch to fragment 1
                        isExpressDelivery="0";
                        textView.setText(R.string.normal_delivery_text);

                        break;
                    case R.id.radio_exclusive:
                        // Fragment 2
                        isExpressDelivery="1";
                        textView.setText("It will be delivered within 24 working hours and charged 2% of request amount");
                        break;
                }
            }
        });
        return  myView;
    }

    private void requestAmount(final String amount, final String comments){
        Log.e("requestAmount",amount);

        final HofDetailsBean hofDetailsBean = AppData.getInstance().getUser().getHoFDetails();
        if(hofDetailsBean == null){
            Toast.makeText(getActivity(),"Details not available",Toast.LENGTH_SHORT);
            return;
        }
        final String bhamashahID = hofDetailsBean.getBHAMASHAH_ID();
        String udid =hofDetailsBean.getAADHAR_ID();
        String bankAccountNumber= hofDetailsBean.getACC_NO();
        AppUtils.showLoader(getActivity());
        Call<CheckAmoutApiResponse> checkAmoutApiResponseCall = RemoteClient.getApiInterface().getAmountCheckAPIResponse("checkBankBalance",bhamashahID,udid,bankAccountNumber,amount);
        checkAmoutApiResponseCall.enqueue(new ResponseHandler<CheckAmoutApiResponse>(getActivity(), 1, new SuccessInferface<CheckAmoutApiResponse>() {
            @Override
            public void onResponse(int id, CheckAmoutApiResponse checkAmoutApiResponse) {
                Log.e("req", String.valueOf(checkAmoutApiResponse.getStatusCode()));
                if (checkAmoutApiResponse.getStatusCode()==200) {
                    finalRequestforAmount(bhamashahID, amount, comments, hofDetailsBean);
                }
                else{
                    AppUtils.hideLoader();
                    AppUtils.showDialogWithTwoButtons(getActivity(),"Error",checkAmoutApiResponse.getStatusMessage(),"OK",null, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    },null);

                }
            }


        },null));
    }
    private void finalRequestforAmount(String bhamashahID, String amount, String comments, HofDetailsBean hofDetailsBean){
        String dob = hofDetailsBean.getDOB();
        Log.e("dob",dob);

        Date birthDate = new Date(dob);
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(birthDate.getTime());
        //create calendar object for current day
        long currentTime = System.currentTimeMillis();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(currentTime);
        //Get difference between years
        String years = String.valueOf(now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR));
        Log.e("years "," "+ years);

        Call<RequestAmountApiResponse> checkAmoutApiResponseCall = RemoteClient.getApiInterface().getRequestAmountAPIResponse("requestHomeWithdrawl",bhamashahID,amount,years,isExpressDelivery,comments);
        checkAmoutApiResponseCall.enqueue(new ResponseHandler<RequestAmountApiResponse>(getActivity(), 1, new SuccessInferface<RequestAmountApiResponse>() {
            @Override
            public void onResponse(int id, RequestAmountApiResponse RequestAmountApiResponse) {
               // Log.e("res", String.valueOf(RequestAmountApiResponse.getData().getExpectedResponseDate()));
                String message ="Your cash withdrawal request is initiated and expected date is "+RequestAmountApiResponse.getData().getExpectedResponseDate()+" for further details contact to "+RequestAmountApiResponse.getData().getAgentName()+" on "+ RequestAmountApiResponse.getData().getAgentNumber();
                AppUtils.hideLoader();
                AppUtils.showDialogWithTwoButtons(getActivity(),"Success",message,"OK",null, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editTextAmount.getText().clear();
                        autoCompleteTextViewComments.getText().clear();
                    }
                },null);
            }

        },null));

    };

}
