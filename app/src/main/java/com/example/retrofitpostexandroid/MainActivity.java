package com.example.retrofitpostexandroid;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button buttonSendPostRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSendPostRequest = findViewById(R.id.btnSendPostRequest);
        buttonSendPostRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSendPostRequestClicked();
            }
        });
    }

    private void btnSendPostRequestClicked() {
        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);

        Call<User> call = apiInterface.getUserInformation("Be Codey", "Android devleoper");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                Log.e(TAG, "ONrESPONSE : "+response.code());
                Log.e(TAG, "ONrESPONSE : "+response.body().getName());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
    Log.e(TAG, "onFailure: "+ t.getMessage());
            }
        });
    }
}