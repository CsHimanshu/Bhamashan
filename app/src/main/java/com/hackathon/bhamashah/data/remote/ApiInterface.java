package com.hackathon.bhamashah.data.remote;

import com.hackathon.bhamashah.bean.Test;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by himanshukumarsingh on 12/03/17.
 */

public interface ApiInterface {

    @Headers("Cache-Control: no-cache")
    @GET("{Bid}")
    Call<Test> getTestResponse(
            @Path("Bid") String Bid,
            @Query("client_id") String clientId
    );
}
