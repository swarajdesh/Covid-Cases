package com.example.covidcases;

import com.robinhood.spark.SparkAdapter;

import java.util.ArrayList;
import java.util.List;

public class CovidSparkViewAdap extends SparkAdapter {
    private List<CovidData> Covid;

    public CovidSparkViewAdap(List<CovidData> covidData) {
        Covid = new ArrayList<>(covidData);
    }

    @Override
    public int getCount() {
        return Covid.size() ;
    }

    @Override
    public Object getItem(int index) {
        return Covid.get(index);
    }

    @Override
    public float getY(int index) {
        CovidData PerDay = Covid.get(index);
        return PerDay.getActiveCases();
    }
}
