package com.hackathon.bhamashah.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.bhamashah.R;
import com.hackathon.bhamashah.adapters.HomeBankingServicesAdapter;
import com.hackathon.bhamashah.base.BaseFragment;
import com.hackathon.bhamashah.bean.AllServicesApiResponse;
import com.hackathon.bhamashah.bean.Login.HofDetailsBean;
import com.hackathon.bhamashah.data.local.AppData;
import com.hackathon.bhamashah.data.remote.RemoteClient;
import com.hackathon.bhamashah.data.remote.ResponseHandler;
import com.hackathon.bhamashah.data.remote.api.SuccessInferface;
import com.hackathon.bhamashah.utilities.AppUtils;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class BhamashahPassbookFragment extends BaseFragment {


    private RecyclerView recyclerView;
    public BhamashahPassbookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        HofDetailsBean hoFDetails = AppData.getInstance().getUser().getHoFDetails();
        if(hoFDetails!=null) {
            getService(hoFDetails.getBHAMASHAH_ID());
        }
        View view =  inflater.inflate(R.layout.fragment_bhamashah_passbook, container, false);
        recyclerView= (RecyclerView) view.findViewById(R.id.passbook_recycler_view);
        return view;
    }

    private void getService(String bhamashah_id){
        AppUtils.showLoader(getActivity());
        Call<AllServicesApiResponse> checkAmoutApiResponseCall = RemoteClient.getApiInterface().getAllServices("getAllServices",bhamashah_id);
        checkAmoutApiResponseCall.enqueue(new ResponseHandler<AllServicesApiResponse>(getActivity(), 1, new SuccessInferface<AllServicesApiResponse>() {
            @Override
            public void onResponse(int id, final AllServicesApiResponse allServicesApiResponse) {
                AppUtils.updateUI(getActivity(), new Runnable() {
                    @Override
                    public void run() {
                        AppUtils.hideLoader();
                        AppUtils.addAdatperToRecyclerView(new HomeBankingServicesAdapter(BhamashahPassbookFragment.this.getActivity(),allServicesApiResponse.getData().getHomeBankingServices()),recyclerView);
                    }
                });

            }

        },null));
    }

}
