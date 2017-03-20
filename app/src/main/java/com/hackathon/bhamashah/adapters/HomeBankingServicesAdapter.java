package com.hackathon.bhamashah.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hackathon.bhamashah.R;
import com.hackathon.bhamashah.bean.AllServicesApiResponse;
import com.hackathon.bhamashah.bean.ApplyBankServiceApiResponse;
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

public class HomeBankingServicesAdapter extends RecyclerView.Adapter<HomeBankingServicesAdapter.MyViewHolder>  {
    private List<AllServicesApiResponse.DataBean.HomeBankingServicesBean> list;
    private Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView amount,status,initialted;


        public MyViewHolder(View view) {
            super(view);
            amount = (TextView) view.findViewById(R.id.homebankitem_amount);
            status = (TextView) view.findViewById(R.id.homebankitem_status);
            initialted = (TextView) view.findViewById(R.id.homebankitem_init);
        }
    }

    public HomeBankingServicesAdapter(Activity activity, List<AllServicesApiResponse.DataBean.HomeBankingServicesBean> list) {
        this.list = list;
        this.activity=activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homebank_offers_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final AllServicesApiResponse.DataBean.HomeBankingServicesBean bean = list.get(position);
        holder.amount.setText(bean.getRequestedAmount());
        holder.initialted.setText(bean.getInitiatedOn());
        holder.status.setText(bean.getRequestStatus());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private String getShortDescription(AllServicesApiResponse.DataBean.BankingServicesBean bean){
        return bean.getStartAge()+"-"+bean.getEndAge()+", "+bean.getGender();

    }

}
