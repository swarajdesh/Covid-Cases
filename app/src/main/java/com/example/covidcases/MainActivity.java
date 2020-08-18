package com.example.covidcases;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;


public class MainActivity extends AppCompatActivity {
    private static final String URL = "https://api.apify.com/v2/datasets/";
    private static final String TAG = "MainActivity";
    private List<CovidData> nationalDailyData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder().registerTypeAdapter(StatesData.class,new MyDeserializer()).setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Retrofit retrofit = new Retrofit.Builder()
                 .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

      //  nationalDailyData = new ArrayList<>();

        CovidService covidService = retrofit.create(CovidService.class);

        //fetch indian cases

        Call<List<CovidData>> covidDataCall = covidService.getIndianData();

        covidDataCall.enqueue(new Callback<List<CovidData>>() {
            @Override
            public void onResponse(Call<List<CovidData>> call, Response<List<CovidData>> response) {

                Log.i(TAG, "onResponse " );
                if (!response.isSuccessful()){
                    Log.w(TAG,"Did not recieve valid  response");
                }

                List<CovidData> nationalData = response.body();

               // Collections.reverse(nationalData);
               nationalDailyData = nationalData;
                Log.i(TAG,"Update graph");
            }

            @Override
            public void onFailure(Call<List<CovidData>> call, Throwable t) {

                Log.e(TAG,"onFailure" +t);

            }
        });











//        Call<Cases_time_series> call = covidService.getIndianData();
//        call.enqueue(new Callback<Cases_time_series>() {
//            @Override
//            public void onResponse(Call<Cases_time_series> call, Response<Cases_time_series> response) {
//                Log.i(TAG,"OnResponse $response");
//                if (!response.isSuccessful()){
//                    Log.w(TAG,"Did not recieve valid response");
//                }
//                List<CovidData> nationalData = response.body().getCases_time_series();
//                for (int i = 0; i<nationalData.size();i++){
//                    Date date = nationalData.get(i).getDate();
//
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<Cases_time_series> call, Throwable t) {
//            Log.i(TAG,"OnFailure $t");
//            }
//        });

        //fetch states cases

    }
}