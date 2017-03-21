package com.hackathon.bhamashah.bean;

/**
 * Created by himanshukumarsingh on 21/03/17.
 */

public class HomeBankingServicesBean {

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
