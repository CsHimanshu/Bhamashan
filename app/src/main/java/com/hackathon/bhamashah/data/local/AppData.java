package com.hackathon.bhamashah.data.local;

/**
 * Created by himanshukumarsingh on 24/02/17.
 */

public class AppData {
    private AppData() {
    }
    private static AppData appData=null;
    private User user = new User();

    public static AppData getInstance(){
        if(appData==null){
            appData=new AppData();
        }
        return appData;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
