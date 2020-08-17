package com.example.covidcases;

import java.util.Date;
import java.util.List;

public class CovidData {


    private Date lastUpdatedAtApify;
    private int activeCases;
    private int recovered;
    private int deaths;
    private int totalCases;
    private StatesData statesData;

    public Date getLastUpdatedAtApify() {
        return lastUpdatedAtApify;
    }

    public int getActiveCases() {
        return activeCases;
    }

    public int getRecovered() {
        return recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public StatesData getStatesData() {
        return statesData;
    }
}

