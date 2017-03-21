package com.hackathon.bhamashah.bean;

/**
 * Created by himanshukumarsingh on 21/03/17.
 */

public class ApplyBankServiceApiResponse {

    /**
     * statusCode : 200
     * statusMessage : Loan Applied
     * data : {"LoanRequestId":"6"}
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
        /**
         * LoanRequestId : 6
         */

        private String LoanRequestId;

        public String getLoanRequestId() {
            return LoanRequestId;
        }

        public void setLoanRequestId(String LoanRequestId) {
            this.LoanRequestId = LoanRequestId;
        }
    }
}
