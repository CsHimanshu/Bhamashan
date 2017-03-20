package com.hackathon.bhamashah.bean;

/**
 * Created by Varun Mishra on 20/3/17
 * Email id : varun.mishra@tothenew.com
 */

public class CheckAmoutApiResponse {

    /**
     * statusCode : 200
     * statusMessage : Request Amount Available
     * data : null
     */

    private int statusCode;
    private String statusMessage;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
