package com.hackathon.bhamashah.data.remote;

import com.hackathon.bhamashah.utilities.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by himanshukumarsingh on 19/02/17.
 */

public class RemoteClient {

    private static Retrofit jsonRetrofit=null;
    private static Retrofit xmlRetrofit=null;
    private RemoteClient() {
    }

    private static Retrofit getClient(boolean isXML,String baseUrl){
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY); // set your desired log level
            //NONE, BASIC, HEADERS, BODY

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);// add logging as last interceptor
            httpClient.connectTimeout(2, TimeUnit.MINUTES);
            httpClient.writeTimeout(2, TimeUnit.MINUTES);
            httpClient.readTimeout(2, TimeUnit.MINUTES);
            Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient.build());

            if(isXML){
                builder.addConverterFactory(SimpleXmlConverterFactory.create());
            }else{
                builder.addConverterFactory(GsonConverterFactory.create());
            }

        return builder.build();
    }

    public static Retrofit getJSONClient(){
        if(jsonRetrofit==null){
            jsonRetrofit= getClient(false, Constants.BASE_URL);
        }
        return jsonRetrofit;
    }

    public static ApiInterface getApiInterface(){
        return getJSONClient().create(ApiInterface.class);
    }

//    public static Retrofit getXMLClientInitialAPI(){
//        if(xmlRetrofit==null){
//         xmlRetrofit=getClient(true,"https://staging.jemtv.com/smarttv_app_v2/tvapp.php/xml/initialize_tvapp/");
//        }
//        return xmlRetrofit;
//    }
}
