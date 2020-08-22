package com.example.covidcases;

import com.robinhood.spark.SparkAdapter;

import java.util.ArrayList;
import java.util.List;
/**
 * Author:    Swaraj Deshmukh
 * Created:   23.08.2020
 *
 **/

public class CovidSparkViewAdap extends SparkAdapter {
    private List<CovidData> Covid;
    GraphCovid Graph = GraphCovid.Positive;
    TimeSpace Time = TimeSpace.Max;

    public CovidSparkViewAdap(List<CovidData> covidData) {
        Covid = new ArrayList<>(covidData);
    }

    @Override
    public int getCount() {
        return Covid.size() ;
    }

    @Override
    public Object getItem(int index) {
        //Onscrubbing SparkView return
        return Covid.get(index);
    }

    @Override
    public float getY(int index) {
        CovidData PerDay = Covid.get(index);
        if (Graph==GraphCovid.Positive) return PerDay.getActiveCases();
        if (Graph==GraphCovid.Death) return PerDay.getDeaths();
        if (Graph==GraphCovid.Negative) return PerDay.getRecovered();
        return 0;
    }
}
