package com.example.sys.retrofit2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    public static final String LOGIN_PREF = "LOGIN_PREF";
    public static final String USER_ID = "USER_ID";
    EditText userName, password;
    Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_btn=findViewById( R.id.login_btn );
        userName=findViewById( R.id.editText );
        password=findViewById( R.id.password );

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name = userName.getText().toString().trim();
                String pass = password.getText().toString().trim();
                ApiService apiService = RetrofitClass.getApiService();
                Call<LoginResponse> responseCall = apiService.loginResponse(user_name, pass);
                Log.e( "String response", responseCall.request().url().toString() );
                responseCall.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()) {
                            Log.i("Resp", response.body().toString());
                            String stat = response.body().getStatus();
                            if (stat.equals("true")){
                                String userID = response.body().getUserId();
                                SharedPreferences preferences = getSharedPreferences(LOGIN_PREF, Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString(USER_ID, userID);
                                editor.apply();
                                startActivity( new Intent( MainActivity.this, SecondScreen.class ) );
                            }
                        } else{

                            Toast.makeText(MainActivity.this, "Not valid", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.e("Error", t.getMessage());
                    }
                });


            }
        });

    }
}
