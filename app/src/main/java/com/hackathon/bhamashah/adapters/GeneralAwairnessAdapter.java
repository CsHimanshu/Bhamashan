package com.hackathon.bhamashah.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hackathon.bhamashah.R;
import com.hackathon.bhamashah.bean.ApplyBankServiceApiResponse;
import com.hackathon.bhamashah.bean.GeneralAwairnessApiResponse;
import com.hackathon.bhamashah.bean.currentOffers.PreApprovedLoansBean;
import com.hackathon.bhamashah.data.local.AppData;
import com.hackathon.bhamashah.data.remote.RemoteClient;
import com.hackathon.bhamashah.data.remote.ResponseHandler;
import com.hackathon.bhamashah.data.remote.api.SuccessInferface;
import com.hackathon.bhamashah.utilities.AppUtils;

import java.util.List;

import retrofit2.Call;

/**
 * Created by himanshukumarsingh on 20/03/17.
 */

public class GeneralAwairnessAdapter extends RecyclerView.Adapter<GeneralAwairnessAdapter.MyViewHolder>  {
    private List<GeneralAwairnessApiResponse.DataBean> list;
    private Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView category,amount;

        public MyViewHolder(View view) {
            super(view);
            category = (TextView) view.findViewById(R.id.bankitem_category);
            amount = (TextView) view.findViewById(R.id.bankitem_amount);
           }
    }

    public GeneralAwairnessAdapter(Activity activity, List<GeneralAwairnessApiResponse.DataBean> list) {
        this.list = list;
        this.activity=activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.general_awairness_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final GeneralAwairnessApiResponse.DataBean bean = list.get(position);
        holder.category.setText(bean.getRationName());
        holder.amount.setText(bean.getRationQuota());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
