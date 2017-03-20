package com.hackathon.bhamashah.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.bhamashah.R;
import com.hackathon.bhamashah.base.BaseFragment;
import com.hackathon.bhamashah.bean.Test;
import com.hackathon.bhamashah.data.remote.ApiInterface;
import com.hackathon.bhamashah.data.remote.RemoteClient;
import com.hackathon.bhamashah.data.remote.ResponseHandler;
import com.hackathon.bhamashah.data.remote.api.SuccessInferface;
import com.hackathon.bhamashah.utilities.AppUtils;

import retrofit2.Call;

/**
 * Created by himanshukumarsingh on 20/03/17.
 */

public class HomeFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Call<Test> testCall =RemoteClient.getApiInterface().getTestResponse("WDYYYGG","ad7288a4-7764-436d-a727-783a977f1fe1");
        testCall.enqueue(new ResponseHandler<Test>(getActivity(), 1, new SuccessInferface<Test>() {
            @Override
            public void onResponse(int id, Test test) {
                Log.d("TEST", "onResponse: " + test);

            }
        },null));

    }
}
