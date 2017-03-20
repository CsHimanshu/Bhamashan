package com.hackathon.bhamashah.bean;

/**
 * Created by Varun Mishra on 20/3/17
 * Email id : varun.mishra@tothenew.com
 */

public class RequestAmountApiResponse {


    /**
     * statusCode : 200
     * statusMessage : Requested initiated
     * data : {"requestId":"16","bhamashahId":"1234","requestedAmount":"10000","comments":"Null","expectedResponseDate":"2017-03-23","requestStatus":0,"cancellationCharges":1000,"serviceType":"0","serviceCharges":5,"agentId":1,"initiatedOn":null,"agentNumber":"9999988888","agentName":"RamKumar"}
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
         * requestId : 16
         * bhamashahId : 1234
         * requestedAmount : 10000
         * comments : Null
         * expectedResponseDate : 2017-03-23
         * requestStatus : 0
         * cancellationCharges : 1000
         * serviceType : 0
         * serviceCharges : 5
         * agentId : 1
         * initiatedOn : null
         * agentNumber : 9999988888
         * agentName : RamKumar
         */

        private String requestId;
        private String bhamashahId;
        private String requestedAmount;
        private String comments;
        private String expectedResponseDate;
        private int requestStatus;
        private int cancellationCharges;
        private String serviceType;
        private int serviceCharges;
        private int agentId;
        private Object initiatedOn;
        private String agentNumber;
        private String agentName;

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getBhamashahId() {
            return bhamashahId;
        }

        public void setBhamashahId(String bhamashahId) {
            this.bhamashahId = bhamashahId;
        }

        public String getRequestedAmount() {
            return requestedAmount;
        }

        public void setRequestedAmount(String requestedAmount) {
            this.requestedAmount = requestedAmount;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public String getExpectedResponseDate() {
            return expectedResponseDate;
        }

        public void setExpectedResponseDate(String expectedResponseDate) {
            this.expectedResponseDate = expectedResponseDate;
        }

        public int getRequestStatus() {
            return requestStatus;
        }

        public void setRequestStatus(int requestStatus) {
            this.requestStatus = requestStatus;
        }

        public int getCancellationCharges() {
            return cancellationCharges;
        }

        public void setCancellationCharges(int cancellationCharges) {
            this.cancellationCharges = cancellationCharges;
        }

        public String getServiceType() {
            return serviceType;
        }

        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }

        public int getServiceCharges() {
            return serviceCharges;
        }

        public void setServiceCharges(int serviceCharges) {
            this.serviceCharges = serviceCharges;
        }

        public int getAgentId() {
            return agentId;
        }

        public void setAgentId(int agentId) {
            this.agentId = agentId;
        }

        public Object getInitiatedOn() {
            return initiatedOn;
        }

        public void setInitiatedOn(Object initiatedOn) {
            this.initiatedOn = initiatedOn;
        }

        public String getAgentNumber() {
            return agentNumber;
        }

        public void setAgentNumber(String agentNumber) {
            this.agentNumber = agentNumber;
        }

        public String getAgentName() {
            return agentName;
        }

        public void setAgentName(String agentName) {
            this.agentName = agentName;
        }
    }
}
