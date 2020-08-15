package com.example.covidcases;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidService {

    @GET ("data.json")
    Call<List<CovidData>> getIndianData();

    @GET("states_daily.json")
    Call<List<CovidData>> getStatesData();
}
