package com.example.sys.retrofit2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SecondScreen extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
    recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        ApiService service = RetrofitClass.getApiService();
        SharedPreferences pref = getSharedPreferences(MainActivity.LOGIN_PREF, Context.MODE_PRIVATE);
        String userID = pref.getString(MainActivity.USER_ID,"");

        Log.e( "user id", userID );
        final Call<DashboardResp> respCall = service.dashboardResp(userID);
        respCall.enqueue(new Callback<DashboardResp>() {
            @Override
            public void onResponse(Call<DashboardResp> call, Response<DashboardResp> response) {
                if (response.isSuccessful()){
                    Log.i("Response", response.body().toString());
                    ArrayList<DashboardResp.Details> details = response.body().getDetailsList();
                    /*String url = details.get(0).getImage();
                    Picasso.get().load(url).into(imageView);
                    */
               /*     String name=details.get( 0 ).getName();
                    String lat = details.get(0).getLat();
                    String lon = details.get(0).getLon();*/
                    ReclerAdapter adapter = new ReclerAdapter(SecondScreen.this, details);
                    recyclerView.setAdapter( adapter );


                } else {
                    Toast.makeText(SecondScreen.this, "Sth wasn't correct", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DashboardResp> call, Throwable t) {
                Log.e("error", t.getMessage());
            }
        });



    }
}
