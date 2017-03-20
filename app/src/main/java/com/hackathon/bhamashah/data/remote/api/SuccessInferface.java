package com.hackathon.bhamashah.data.remote.api;

/**
 * Created by himanshukumarsingh on 08/03/17.
 */

public interface SuccessInferface<T> {
    void onResponse(int id, T t);
}
