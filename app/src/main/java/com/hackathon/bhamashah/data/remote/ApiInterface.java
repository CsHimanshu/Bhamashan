package com.hackathon.bhamashah.data.remote;

import com.hackathon.bhamashah.bean.AllServicesApiResponse;
import com.hackathon.bhamashah.bean.CheckAmoutApiResponse;
import com.hackathon.bhamashah.bean.LoginAPIResponse;
import com.hackathon.bhamashah.bean.RequestAmountApiResponse;

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
    Call<CheckAmoutApiResponse> getAmountCheckAPIResponse(
            @Query("operation") String operation,
            @Query("bhamashahId") String BID,
            @Query("uidai") String uidai,
            @Query("bankAccountNumber") String bankAccountNumber,
            @Query("requestedAmount") String requestedAmount
    );

    @Headers("Cache-Control: no-cache")
    @GET("services.php")
    Call<RequestAmountApiResponse> getRequestAmountAPIResponse(
            @Query("operation") String operation,
            @Query("bhamashahId") String BID,
            @Query("requestedAmount") String requestedAmount,
            @Query("age") String age,
            @Query("isExpressDelivery") String isExpressDelivery,
            @Query("comments") String comments
    );
    @Headers("Cache-Control: no-cache")
    @GET("services.php")
    Call<AllServicesApiResponse> getAllServices(
            @Query("operation") String operation,
            @Query("bhamashahId") String BID
    );




}
