package com.hackathon.bhamashah.data.local;

import android.content.*;

import com.hackathon.bhamashah.base.MyApplication;
import com.hackathon.bhamashah.bean.Login.FamilyDetailsBean;
import com.hackathon.bhamashah.bean.Login.HofDetailsBean;
import com.hackathon.bhamashah.bean.LoginAPIResponse;

import java.util.List;

/**
 * Created by himanshukumarsingh on 15/03/17.
 */

public class User {
    private String mobileNumber;
    private String bhamashahId;
    private HofDetailsBean hof_Details;
    private List<FamilyDetailsBean> family_Details;

    public User() {
    }

    public User(String mobileNumber, String bhamashahId, HofDetailsBean hof_Details, List<FamilyDetailsBean> family_Details) {
        this.mobileNumber = mobileNumber;
        this.bhamashahId = bhamashahId;
        this.hof_Details = hof_Details;
        this.family_Details = family_Details;
        saveIntoPreference();
    }

    private void saveIntoPreference(){
        SharedPreferences.putString(SharedPreferences.KEY_BID,bhamashahId, MyApplication.getContext());
        SharedPreferences.putString(SharedPreferences.KEY_MOBILE_NUMBER,mobileNumber, MyApplication.getContext());
        SharedPreferences.putObject(SharedPreferences.KEY_HOD_DETAIL,hof_Details, MyApplication.getContext());
        SharedPreferences.putObject(SharedPreferences.KEY_MEMBERLIST,family_Details, MyApplication.getContext());
    }

    public String getMobileNumber() {
        if(mobileNumber==null){
            mobileNumber=SharedPreferences.getString(SharedPreferences.KEY_MOBILE_NUMBER,null,MyApplication.getContext());
        }
        return mobileNumber;
    }

    public String getBhamashahId() {
        if(bhamashahId==null){
            bhamashahId=SharedPreferences.getString(SharedPreferences.KEY_BID,null,MyApplication.getContext());
        }
        return bhamashahId;
    }

    public HofDetailsBean getHoFDetails() {
        if(hof_Details==null){
            hof_Details= (HofDetailsBean) SharedPreferences.getObject(SharedPreferences.KEY_HOD_DETAIL,null,MyApplication.getContext());
        }
        return hof_Details;
    }

    public List<FamilyDetailsBean>  getFamily_Details() {
        if(family_Details==null){
            family_Details= (List<FamilyDetailsBean>) SharedPreferences.getObject(SharedPreferences.KEY_MEMBERLIST,null,MyApplication.getContext());
        }
        return family_Details;
    }
}
