package com.hackathon.bhamashah.bean;

import java.util.List;

/**
 * Created by Varun Mishra on 21/3/17
 * Email id : varun.mishra@tothenew.com
 */

public class AllServicesApiResponse {
    /**
     * statusCode : 200
     * statusMessage : Services Fetched
     * data : {"BankingServices":[{"loanId":"1","startAge":"25","endAge":"40","gender":"Female","category":"Home Loan","subCategory":"","forRural":"0","incomeType":"BPL","loanAmount":"200000","startFrom":"2017-03-02","endAt":null,"isAlreadyApplied":null,"status":"applied"},{"loanId":"1","startAge":"25","endAge":"40","gender":"Female","category":"Home Loan","subCategory":"","forRural":"0","incomeType":"BPL","loanAmount":"200000","startFrom":"2017-03-02","endAt":null,"isAlreadyApplied":null,"status":"applied"},{"loanId":"1","startAge":"25","endAge":"40","gender":"Female","category":"Home Loan","subCategory":"","forRural":"0","incomeType":"BPL","loanAmount":"200000","startFrom":"2017-03-02","endAt":null,"isAlreadyApplied":null,"status":"applied"},{"loanId":"2","startAge":"20","endAge":"40","gender":"Female","category":"Education Loan","subCategory":"Post graduation","forRural":"1","incomeType":"APL","loanAmount":"150000","startFrom":"2017-03-10","endAt":null,"isAlreadyApplied":null,"status":"applied"},{"loanId":"2","startAge":"20","endAge":"40","gender":"Female","category":"Education Loan","subCategory":"Post graduation","forRural":"1","incomeType":"APL","loanAmount":"150000","startFrom":"2017-03-10","endAt":null,"isAlreadyApplied":null,"status":"applied"},{"loanId":"2","startAge":"20","endAge":"40","gender":"Female","category":"Education Loan","subCategory":"Post graduation","forRural":"1","incomeType":"APL","loanAmount":"150000","startFrom":"2017-03-10","endAt":null,"isAlreadyApplied":null,"status":"applied"},{"loanId":"3","startAge":"30","endAge":"50","gender":"Male","category":"Business Loan","subCategory":"Small Industry/ Small Business","forRural":"1","incomeType":"BPL","loanAmount":"300000","startFrom":"2017-03-20","endAt":null,"isAlreadyApplied":null,"status":"applied"},{"loanId":"4","startAge":"30","endAge":"50","gender":"Male","category":"Home Loan","subCategory":"","forRural":"1","incomeType":"APL","loanAmount":"200000","startFrom":"2017-03-03","endAt":null,"isAlreadyApplied":null,"status":"applied"}],"HomeBankingServices":[{"requestId":"1","bhamashahId":null,"requestedAmount":"10000","comments":"20","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"1","serviceCharges":"1000","agentId":null,"initiatedOn":"2017-03-20 15:58:28","agentNumber":null,"agentName":null},{"requestId":"2","bhamashahId":null,"requestedAmount":"10000","comments":"20","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 15:58:51","agentNumber":null,"agentName":null},{"requestId":"3","bhamashahId":null,"requestedAmount":"10000","comments":"20","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 15:59:54","agentNumber":null,"agentName":null},{"requestId":"4","bhamashahId":null,"requestedAmount":"10000","comments":"\"Null\"","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 16:01:55","agentNumber":null,"agentName":null},{"requestId":"5","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 16:59:27","agentNumber":null,"agentName":null},{"requestId":"6","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 17:15:52","agentNumber":null,"agentName":null},{"requestId":"7","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 18:04:05","agentNumber":null,"agentName":null},{"requestId":"8","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 18:06:27","agentNumber":null,"agentName":null},{"requestId":"9","bhamashahId":null,"requestedAmount":"105","comments":"","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 18:08:38","agentNumber":null,"agentName":null},{"requestId":"10","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 18:10:36","agentNumber":null,"agentName":null},{"requestId":"11","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:08:36","agentNumber":null,"agentName":null},{"requestId":"13","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:02","agentNumber":null,"agentName":null},{"requestId":"14","bhamashahId":null,"requestedAmount":"100","comments":"","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:15","agentNumber":null,"agentName":null},{"requestId":"15","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:28","agentNumber":null,"agentName":null},{"requestId":"17","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:38","agentNumber":null,"agentName":null},{"requestId":"18","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:38","agentNumber":null,"agentName":null},{"requestId":"19","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:40","agentNumber":null,"agentName":null},{"requestId":"20","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:41","agentNumber":null,"agentName":null},{"requestId":"21","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:41","agentNumber":null,"agentName":null},{"requestId":"22","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:42","agentNumber":null,"agentName":null},{"requestId":"23","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:42","agentNumber":null,"agentName":null},{"requestId":"24","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:42","agentNumber":null,"agentName":null},{"requestId":"25","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:42","agentNumber":null,"agentName":null},{"requestId":"26","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:43","agentNumber":null,"agentName":null},{"requestId":"27","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:43","agentNumber":null,"agentName":null},{"requestId":"28","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:43","agentNumber":null,"agentName":null},{"requestId":"29","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:43","agentNumber":null,"agentName":null},{"requestId":"30","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:43","agentNumber":null,"agentName":null},{"requestId":"31","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:43","agentNumber":null,"agentName":null},{"requestId":"32","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:12:44","agentNumber":null,"agentName":null},{"requestId":"33","bhamashahId":null,"requestedAmount":"10000","comments":"Null","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:13:32","agentNumber":null,"agentName":null},{"requestId":"34","bhamashahId":null,"requestedAmount":"1000","comments":"","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:16:29","agentNumber":null,"agentName":null},{"requestId":"35","bhamashahId":null,"requestedAmount":"194","comments":"","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:17:38","agentNumber":null,"agentName":null},{"requestId":"36","bhamashahId":null,"requestedAmount":"100","comments":"","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:19:16","agentNumber":null,"agentName":null},{"requestId":"37","bhamashahId":null,"requestedAmount":"1000","comments":"","expectedResponseDate":null,"requestStatus":"Inititated","cancellationCharges":null,"serviceType":"0","serviceCharges":"5","agentId":null,"initiatedOn":"2017-03-20 19:22:58","agentNumber":null,"agentName":null}]}
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
        private List<BankingServicesBean> BankingServices;
        private List<HomeBankingServicesBean> HomeBankingServices;

        public List<BankingServicesBean> getBankingServices() {
            return BankingServices;
        }

        public void setBankingServices(List<BankingServicesBean> BankingServices) {
            this.BankingServices = BankingServices;
        }

        public List<HomeBankingServicesBean> getHomeBankingServices() {
            return HomeBankingServices;
        }

        public void setHomeBankingServices(List<HomeBankingServicesBean> HomeBankingServices) {
            this.HomeBankingServices = HomeBankingServices;
        }

        public static class BankingServicesBean {
            /**
             * loanId : 1
             * startAge : 25
             * endAge : 40
             * gender : Female
             * category : Home Loan
             * subCategory :
             * forRural : 0
             * incomeType : BPL
             * loanAmount : 200000
             * startFrom : 2017-03-02
             * endAt : null
             * isAlreadyApplied : null
             * status : applied
             */

            private String loanId;
            private String startAge;
            private String endAge;
            private String gender;
            private String category;
            private String subCategory;
            private String forRural;
            private String incomeType;
            private String loanAmount;
            private String startFrom;
            private Object endAt;
            private Object isAlreadyApplied;
            private String status;

            public String getLoanId() {
                return loanId;
            }

            public void setLoanId(String loanId) {
                this.loanId = loanId;
            }

            public String getStartAge() {
                return startAge;
            }

            public void setStartAge(String startAge) {
                this.startAge = startAge;
            }

            public String getEndAge() {
                return endAge;
            }

            public void setEndAge(String endAge) {
                this.endAge = endAge;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getSubCategory() {
                return subCategory;
            }

            public void setSubCategory(String subCategory) {
                this.subCategory = subCategory;
            }

            public String getForRural() {
                return forRural;
            }

            public void setForRural(String forRural) {
                this.forRural = forRural;
            }

            public String getIncomeType() {
                return incomeType;
            }

            public void setIncomeType(String incomeType) {
                this.incomeType = incomeType;
            }

            public String getLoanAmount() {
                return loanAmount;
            }

            public void setLoanAmount(String loanAmount) {
                this.loanAmount = loanAmount;
            }

            public String getStartFrom() {
                return startFrom;
            }

            public void setStartFrom(String startFrom) {
                this.startFrom = startFrom;
            }

            public Object getEndAt() {
                return endAt;
            }

            public void setEndAt(Object endAt) {
                this.endAt = endAt;
            }

            public Object getIsAlreadyApplied() {
                return isAlreadyApplied;
            }

            public void setIsAlreadyApplied(Object isAlreadyApplied) {
                this.isAlreadyApplied = isAlreadyApplied;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }

        public static class HomeBankingServicesBean {
            /**
             * requestId : 1
             * bhamashahId : null
             * requestedAmount : 10000
             * comments : 20
             * expectedResponseDate : null
             * requestStatus : Inititated
             * cancellationCharges : null
             * serviceType : 1
             * serviceCharges : 1000
             * agentId : null
             * initiatedOn : 2017-03-20 15:58:28
             * agentNumber : null
             * agentName : null
             */

            private String requestId;
            private Object bhamashahId;
            private String requestedAmount;
            private String comments;
            private Object expectedResponseDate;
            private String requestStatus;
            private Object cancellationCharges;
            private String serviceType;
            private String serviceCharges;
            private Object agentId;
            private String initiatedOn;
            private Object agentNumber;
            private Object agentName;

            public String getRequestId() {
                return requestId;
            }

            public void setRequestId(String requestId) {
                this.requestId = requestId;
            }

            public Object getBhamashahId() {
                return bhamashahId;
            }

            public void setBhamashahId(Object bhamashahId) {
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

            public Object getExpectedResponseDate() {
                return expectedResponseDate;
            }

            public void setExpectedResponseDate(Object expectedResponseDate) {
                this.expectedResponseDate = expectedResponseDate;
            }

            public String getRequestStatus() {
                return requestStatus;
            }

            public void setRequestStatus(String requestStatus) {
                this.requestStatus = requestStatus;
            }

            public Object getCancellationCharges() {
                return cancellationCharges;
            }

            public void setCancellationCharges(Object cancellationCharges) {
                this.cancellationCharges = cancellationCharges;
            }

            public String getServiceType() {
                return serviceType;
            }

            public void setServiceType(String serviceType) {
                this.serviceType = serviceType;
            }

            public String getServiceCharges() {
                return serviceCharges;
            }

            public void setServiceCharges(String serviceCharges) {
                this.serviceCharges = serviceCharges;
            }

            public Object getAgentId() {
                return agentId;
            }

            public void setAgentId(Object agentId) {
                this.agentId = agentId;
            }

            public String getInitiatedOn() {
                return initiatedOn;
            }

            public void setInitiatedOn(String initiatedOn) {
                this.initiatedOn = initiatedOn;
            }

            public Object getAgentNumber() {
                return agentNumber;
            }

            public void setAgentNumber(Object agentNumber) {
                this.agentNumber = agentNumber;
            }

            public Object getAgentName() {
                return agentName;
            }

            public void setAgentName(Object agentName) {
                this.agentName = agentName;
            }
        }
    }
}
