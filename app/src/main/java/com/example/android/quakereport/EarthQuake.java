package com.example.android.quakereport;

/**
 * Created by Mohammed Maaz S on 22-03-18.
 */

public class EarthQuake {
    private double magnitude;
    private String city , date;



    public EarthQuake(double magnitude, String city, String date) {
        this.city=city;
        this.date= date;
        this.magnitude=magnitude;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }
}
