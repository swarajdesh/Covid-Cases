package com.example.covidcases;

import java.time.Month;

public enum TimeSpace{

    Week(7),
    Month(31),
    Max(-1);


    TimeSpace(int Days) {
    }
}
