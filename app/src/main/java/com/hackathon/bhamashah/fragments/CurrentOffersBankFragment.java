package com.hackathon.bhamashah.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.bhamashah.R;
import com.hackathon.bhamashah.adapters.BankOffersAdapter;
import com.hackathon.bhamashah.base.BaseFragment;
import com.hackathon.bhamashah.bean.CurrentOffersApiResponse;
import com.hackathon.bhamashah.bean.LoginAPIResponse;
import com.hackathon.bhamashah.bean.currentOffers.PreApprovedLoansBean;
import com.hackathon.bhamashah.data.local.AppData;
import com.hackathon.bhamashah.data.remote.RemoteClient;
import com.hackathon.bhamashah.data.remote.ResponseHandler;
import com.hackathon.bhamashah.data.remote.api.SuccessInferface;
import com.hackathon.bhamashah.utilities.AppUtils;

import java.util.List;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentOffersBankFragment extends BaseFragment {


    private RecyclerView recyclerView;
    public CurrentOffersBankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bank_current_offers, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.currentbankoffer_recycler_view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hitAPI();
    }

    private void hitAPI(){
        Call<CurrentOffersApiResponse> testCall = RemoteClient.getApiInterface().getCurrentOffersApiResponse("getAllLoans", AppData.getInstance().getUser().getBhamashahId());
        testCall.enqueue(new ResponseHandler<CurrentOffersApiResponse>(getActivity(), 1, new SuccessInferface<CurrentOffersApiResponse>() {
            @Override
            public void onResponse(int id, final CurrentOffersApiResponse currentOffersApiResponse) {
                AppUtils.updateUI(getActivity(), new Runnable() {
                    @Override
                    public void run() {
                        List<PreApprovedLoansBean> list = currentOffersApiResponse.getData().getPreApprovedLoans();
                        AppUtils.addAdatperToRecyclerView(new BankOffersAdapter(getActivity(),list),recyclerView);
                    }
                });
            }
        },null));
    }
}
