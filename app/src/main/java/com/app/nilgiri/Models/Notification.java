package com.app.nilgiri.Models;

import java.util.List;

public class Notification {

    /**
     * data : ["dscvs dvds sd vcadscvacsd dfsbvzfsd v fgsb bdvgf","htester"]
     * message : Successfully
     * status : 1
     */

    private String message;
    private int status;
    private List<String> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
