package com.hackathon.bhamashah.data.remote;


import android.content.Context;
import android.util.Log;

import com.hackathon.bhamashah.data.remote.api.FailureInterface;
import com.hackathon.bhamashah.data.remote.api.SuccessInferface;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by himanshukumarsingh on 22/02/17.
 */

public class ResponseHandler<T> implements retrofit2.Callback<T> {

    private SuccessInferface successInferface = null;
    private FailureInterface failureInterface = null;
    private int requestId = 1;
    private Context context = null;

    public ResponseHandler(Context context) {
        this.context = context;
    }

    public ResponseHandler(Context context, int requestId) {
        this.context = context;
        this.requestId = requestId;
    }

    public ResponseHandler(Context context, int requestId, SuccessInferface successInferface, FailureInterface failureInterface) {
        this.context = context;
        this.requestId = requestId;
        this.failureInterface = failureInterface;
        this.successInferface = successInferface;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Log.d("ResponseHandler", "===============================");
        Log.d("ResponseHandler", "onResponse: " + response);
        if (successInferface != null) successInferface.onResponse(requestId, response.body());
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.d("ResponseHandler", "===============================");
        Log.d("ResponseHandler", "onFailure: " + t);
        if (failureInterface != null) failureInterface.onFailure(requestId, t.toString());
    }
}

//  http://stackoverflow.com/questions/32579754/retrying-the-request-using-retrofit-2