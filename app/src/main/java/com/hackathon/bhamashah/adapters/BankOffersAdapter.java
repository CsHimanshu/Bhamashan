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

public class BankOffersAdapter extends RecyclerView.Adapter<BankOffersAdapter.MyViewHolder>  {
    private List<PreApprovedLoansBean> list;
    private Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView category,shortDesc,amount,description,enddate;
        public Button buttonApply;

        public MyViewHolder(View view) {
            super(view);
            category = (TextView) view.findViewById(R.id.bankitem_category);
            shortDesc = (TextView) view.findViewById(R.id.bankitem_shortdesc);
            amount = (TextView) view.findViewById(R.id.bankitem_amount);
            description = (TextView) view.findViewById(R.id.bankitem_description);
            enddate = (TextView) view.findViewById(R.id.bankitem_enddate);
            buttonApply = (Button) view.findViewById(R.id.bankitem_button_apply);
        }
    }

    public BankOffersAdapter(Activity activity,List<PreApprovedLoansBean> list) {
        this.list = list;
        this.activity=activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bank_offers_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final PreApprovedLoansBean bean = list.get(position);
        holder.category.setText(bean.getCategory());
        holder.amount.setText(bean.getLoanAmount());
        holder.enddate.setText(bean.getEndAt());
        holder.description.setText(bean.getSubCategory());
        holder.shortDesc.setText(getShortDescription(bean));

        holder.buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setTag(position);
                BankOffersAdapter.this.onClick(position,bean);
            }
        });

        if(bean.isAlreadyApplied()){
            holder.buttonApply.setText("Applied");
            holder.buttonApply.setEnabled(false);
        }else{
            holder.buttonApply.setText("Apply");
            holder.buttonApply.setEnabled(true);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private String getShortDescription(PreApprovedLoansBean bean){
        return bean.getStartAge()+"-"+bean.getEndAge()+", "+bean.getGender();

    }

    private void onClick(int position, final PreApprovedLoansBean bean){
        Call<ApplyBankServiceApiResponse> call = RemoteClient.getApiInterface().getApplyBankServiceApiResponse("applyBankService", AppData.getInstance().getUser().getBhamashahId(),bean.getLoanId());
        call.enqueue(new ResponseHandler<ApplyBankServiceApiResponse>(activity, 1, new SuccessInferface<ApplyBankServiceApiResponse>() {
            @Override
            public void onResponse(int id, final ApplyBankServiceApiResponse applyBankServiceApiResponse) {
                AppUtils.updateUI(activity, new Runnable() {
                    @Override
                    public void run() {
                        bean.setAlreadyApplied(true);
                        notifyDataSetChanged();
                        AppUtils.showDialogWithTwoButtons(activity,"Sucessful",applyBankServiceApiResponse.getStatusMessage() + ". Request id is : " + applyBankServiceApiResponse.getData().getLoanRequestId(),"OK",null,null,null);
                    }
                });

            }
        },null));


    }
}
