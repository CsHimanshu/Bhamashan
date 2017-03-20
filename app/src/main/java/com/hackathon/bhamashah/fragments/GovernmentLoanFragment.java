package com.hackathon.bhamashah.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.bhamashah.R;
import com.hackathon.bhamashah.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class GovernmentLoanFragment extends BaseFragment {


    public GovernmentLoanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_government_loan, container, false);
    }

}
