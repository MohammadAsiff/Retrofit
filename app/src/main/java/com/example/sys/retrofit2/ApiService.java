package com.example.sys.retrofit2;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("Login/")
    Call<LoginResponse> loginResponse(@Field("Email") String email,
                                      @Field("Password") String password);
    @FormUrlEncoded
    @POST("Dashboard")
    Call<DashboardResp> dashboardResp(@Field("Id") String userID );

}
