package com.app.nilgiri.Utils;

import com.google.gson.annotations.SerializedName;

/**
 * Created by unoiaAndroid on 4/5/2017.
 */
public class ApiError {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("error")
    private String error;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getError() {
        return message;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", error='" + error + '\'' +
                '}';
    }

}