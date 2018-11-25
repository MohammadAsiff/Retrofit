package com.example.sys.retrofit2;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("Status")
    private String status;

    public String getStatus() {
        return status;
    }

    public String getUserId() {
        return userId;
    }
    @SerializedName("UserId")
    private String userId;
}
