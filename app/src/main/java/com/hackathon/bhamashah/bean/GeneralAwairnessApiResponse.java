package com.hackathon.bhamashah.bean;

import java.util.List;

/**
 * Created by Varun Mishra on 21/3/17
 * Email id : varun.mishra@tothenew.com
 */

public class GeneralAwairnessApiResponse {

    /**
     * statusCode : 200
     * statusMessage : Services Fetched
     * data : [{"rationName":"Rice","rationQuota":"5 Kg."},{"rationName":"Wheat","rationQuota":"15 Kg."},{"rationName":"Moong Dal","rationQuota":"2 Kg."}]
     */

    private int statusCode;
    private String statusMessage;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * rationName : Rice
         * rationQuota : 5 Kg.
         */

        private String rationName;
        private String rationQuota;

        public String getRationName() {
            return rationName;
        }

        public void setRationName(String rationName) {
            this.rationName = rationName;
        }

        public String getRationQuota() {
            return rationQuota;
        }

        public void setRationQuota(String rationQuota) {
            this.rationQuota = rationQuota;
        }
    }
}
