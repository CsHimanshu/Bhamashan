package com.hackathon.bhamashah.bean;

import com.hackathon.bhamashah.bean.currentOffers.PreApprovedLoansBean;

import java.util.List;

/**
 * Created by himanshukumarsingh on 20/03/17.
 */

public class CurrentOffersApiResponse {

    /**
     * statusCode : 200
     * statusMessage : Done
     * data : {"preApprovedLoans":[{"loanId":"1","startAge":"25","endAge":"40","gender":"Female","category":"Home Loan","subCategory":"","forRural":"0","incomeType":"BPL","loanAmount":"200000","startFrom":"2017-03-02","endAt":"2017-03-31"},{"loanId":"2","startAge":"20","endAge":"40","gender":"Female","category":"Education Loan","subCategory":"Post graduation","forRural":"1","incomeType":"APL","loanAmount":"150000","startFrom":"2017-03-10","endAt":"2017-04-29"},{"loanId":"3","startAge":"30","endAge":"50","gender":"Male","category":"Business Loan","subCategory":"Small Industry/ Small Business","forRural":"1","incomeType":"BPL","loanAmount":"300000","startFrom":"2017-03-20","endAt":"2017-05-15"},{"loanId":"4","startAge":"30","endAge":"50","gender":"Male","category":"Home Loan","subCategory":"","forRural":"1","incomeType":"APL","loanAmount":"200000","startFrom":"2017-03-03","endAt":"2017-05-25"}]}
     */

    private int statusCode;
    private String statusMessage;
    private DataBean data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<PreApprovedLoansBean> preApprovedLoans;

        public List<PreApprovedLoansBean> getPreApprovedLoans() {
            return preApprovedLoans;
        }

        public void setPreApprovedLoans(List<PreApprovedLoansBean> preApprovedLoans) {
            this.preApprovedLoans = preApprovedLoans;
        }

    }
}
