package com.hackathon.bhamashah.data.local;

/**
 * Created by himanshukumarsingh on 15/03/17.
 */

public class User {
    private String userName="smarttv_login@gmail.com";
    private String password="12345678";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
