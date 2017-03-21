package com.hackathon.bhamashah.fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.hackathon.bhamashah.R;
import com.hackathon.bhamashah.adapters.BankOffersAdapter;
import com.hackathon.bhamashah.adapters.GeneralAwairnessAdapter;
import com.hackathon.bhamashah.base.BaseFragment;
import com.hackathon.bhamashah.bean.GeneralAwairnessApiResponse;
import com.hackathon.bhamashah.bean.Login.FamilyDetailsBean;
import com.hackathon.bhamashah.bean.Login.HofDetailsBean;
import com.hackathon.bhamashah.bean.RequestAmountApiResponse;
import com.hackathon.bhamashah.bean.currentOffers.PreApprovedLoansBean;
import com.hackathon.bhamashah.data.local.AppData;
import com.hackathon.bhamashah.data.remote.RemoteClient;
import com.hackathon.bhamashah.data.remote.ResponseHandler;
import com.hackathon.bhamashah.data.remote.api.SuccessInferface;
import com.hackathon.bhamashah.utilities.AppUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class AwairnessFragment extends BaseFragment {


    private RecyclerView recyclerView;
    private Spinner spinner;
    private RelativeLayout relativeLayout;

    public AwairnessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_awairness, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.general_awairness_recycler_view);
        relativeLayout= (RelativeLayout) view.findViewById(R.id.relative_no_records);

        spinner = (Spinner)view.findViewById(R.id.general_awairness_spinner);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addSpinner();
        getAwairnessData();

    }
    private void addSpinner(){
        ArrayList<String> list =new ArrayList<>();
        list.add("Rasan");
        list.add("Jobs");
        list.add("Scholership");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TEST", "onItemSelected: " + position);
                if (position==0){
                    getAwairnessData();
                    relativeLayout.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                }else{
                    relativeLayout.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getAwairnessData(){
        HofDetailsBean hofDetailsBean = AppData.getInstance().getUser().getHoFDetails();
        AppUtils.showLoader(getActivity());
        Call<GeneralAwairnessApiResponse> generalAwairnessApiResponseCall = RemoteClient.getApiInterface().getgeneralAwairnessAPIResponse("getRationDetails",hofDetailsBean.getRATION_CARD_NO());
        generalAwairnessApiResponseCall.enqueue(new ResponseHandler<GeneralAwairnessApiResponse>(getActivity(), 1, new SuccessInferface<GeneralAwairnessApiResponse>() {
            @Override
            public void onResponse(int id, GeneralAwairnessApiResponse generalAwairnessApiResponse) {
                AppUtils.hideLoader();
                if(generalAwairnessApiResponse==null)
                    return;
                List<GeneralAwairnessApiResponse.DataBean> list = generalAwairnessApiResponse.getData();
                AppUtils.addAdatperToRecyclerView(new GeneralAwairnessAdapter(getActivity(),list),recyclerView);


            }

        },null));

    }

}
