package com.hackathon.bhamashah.data.remote;

import com.hackathon.bhamashah.bean.ApplyBankServiceApiResponse;
import com.hackathon.bhamashah.bean.CurrentOffersApiResponse;
import com.hackathon.bhamashah.bean.LoginAPIResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


/**
 * Created by himanshukumarsingh on 12/03/17.
 */

public interface ApiInterface {

//    @Headers("Cache-Control: no-cache")
//    @GET("{Bid}")
//    Call<Test> getTestResponse(
//            @Path("Bid") String Bid,
//            @Query("client_id") String clientId
//    );

    @Headers("Cache-Control: no-cache")
    @GET("services.php")
    Call<LoginAPIResponse> getLoginAPIResponse(
            @Query("operation") String operation,
            @Query("bhamashah_id") String BID
    );

    @Headers("Cache-Control: no-cache")
    @GET("services.php")
    Call<CurrentOffersApiResponse> getCurrentOffersApiResponse(
            @Query("operation") String operation,
            @Query("bhamashahId") String bhamashahId
    );

    @Headers("Cache-Control: no-cache")
    @GET("services.php")
    Call<ApplyBankServiceApiResponse> getApplyBankServiceApiResponse(
            @Query("operation") String operation,
            @Query("bhamashahId") String bhamashahId,
            @Query("serviceId") String serviceId
    );
}
