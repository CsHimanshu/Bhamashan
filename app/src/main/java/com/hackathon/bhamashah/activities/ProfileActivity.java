package com.hackathon.bhamashah.activities;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hackathon.bhamashah.R;
import com.hackathon.bhamashah.bean.AllServicesApiResponse;
import com.hackathon.bhamashah.bean.Login.HofDetailsBean;
import com.hackathon.bhamashah.bean.RequestAmountApiResponse;
import com.hackathon.bhamashah.data.local.AppData;
import com.hackathon.bhamashah.data.remote.RemoteClient;
import com.hackathon.bhamashah.data.remote.ResponseHandler;
import com.hackathon.bhamashah.data.remote.api.SuccessInferface;
import com.hackathon.bhamashah.utilities.AppUtils;

import retrofit2.Call;

public class ProfileActivity extends AppCompatActivity {
    private TextView bhamashahID;
    private TextView aadharID;
    private TextView rasanCardNo;
    private TextView gender;
    private TextView accountNo;
    private TextView category;
    private TextView phoneNo;
    private TextView education;
    private TextView EconomicGroup;
    private TextView address;
    private Button button_info;
    private Button button_services;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        findViews();
    }




    private void findViews() {
        linearLayout = (LinearLayout) findViewById(R.id.linearInfo);
        button_info =(Button)findViewById( R.id.button_info );
        button_services =(Button)findViewById( R.id.button_services );
        bhamashahID = (TextView)findViewById( R.id.bhamashahID );
        aadharID = (TextView)findViewById( R.id.aadharID );
        rasanCardNo = (TextView)findViewById( R.id.rasanCardNo );
        gender = (TextView)findViewById( R.id.gender );
        accountNo = (TextView)findViewById( R.id.email );
        category = (TextView)findViewById( R.id.category );
        phoneNo = (TextView)findViewById( R.id.phoneNo );
        education = (TextView)findViewById( R.id.education );
        EconomicGroup = (TextView)findViewById( R.id.Economic_group );
        address = (TextView)findViewById( R.id.address );
        button_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.VISIBLE);
            }
        });
        button_services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.GONE);
            }
        });

        HofDetailsBean hoFDetails = AppData.getInstance().getUser().getHoFDetails();
        if(hoFDetails!=null) {
            setTitle(hoFDetails.getNAME_ENG());
            bhamashahID.setText(hoFDetails.getBHAMASHAH_ID());
            getService(hoFDetails.getBHAMASHAH_ID());
            aadharID.setText(hoFDetails.getAADHAR_ID());
            rasanCardNo.setText(hoFDetails.getRATION_CARD_NO());
            accountNo.setText(hoFDetails.getACC_NO());
            category.setText(hoFDetails.getCATEGORY_DESC_ENG());
            gender.setText(hoFDetails.getGENDER());
            phoneNo.setText(hoFDetails.getMOBILE_NO());
            education.setText(hoFDetails.getEDUCATION_DESC_ENG());
            EconomicGroup.setText(hoFDetails.getECONOMIC_GROUP());
            address.setText(hoFDetails.getADDRESS());
        }
    }

    private void getService(String bhamashah_id){
        AppUtils.showLoader(this);
        Call<AllServicesApiResponse> checkAmoutApiResponseCall = RemoteClient.getApiInterface().getAllServices("getAllService",bhamashah_id);
        checkAmoutApiResponseCall.enqueue(new ResponseHandler<AllServicesApiResponse>(this, 1, new SuccessInferface<AllServicesApiResponse>() {
            @Override
            public void onResponse(int id, AllServicesApiResponse allServicesApiResponse) {
                AppUtils.hideLoader();
            }

        },null));
    }

}
