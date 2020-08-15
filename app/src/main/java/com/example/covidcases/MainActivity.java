package com.example.covidcases;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;


public class MainActivity extends AppCompatActivity {
    private static final String URL = "api.covid19india.org";
    private static final String TAG = "MainActivity";
    private List<CovidData> nationalDailyData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                 .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CovidService covidService = retrofit.create(CovidService.class);

        //fetch indian cases
        Call<List<CovidData>> call = covidService.getIndianData();
        call.enqueue(new Callback<List<CovidData>>() {
            @Override
            public void onResponse(Call<List<CovidData>> call, Response<List<CovidData>> response) {

                Log.i(TAG , "onResponse $response");

              List<CovidData>  nationalData = response.body();
                if (!response.isSuccessful()){
                    Log.w(TAG, "Did not recieve valid response body");
                    return;
                }

              for (CovidData covidData : nationalData ){
                String 

              }

            }

            @Override
            public void onFailure(Call<List<CovidData>> call, Throwable t) {

                Log.e(TAG, "onFailure $t")
            }
        });


        //fetch states cases

    }
}