package com.example.android.quakereport;

/**
 * Created by Mohammed Maaz S on 22-03-18.
 */

public class EarthQuake {
    private double magnitude;
    private String city;

    public String getmUrl() {
        return mUrl;
    }

    private String mUrl;

    private long date;



    public EarthQuake(double magnitude, String city, long date,String url) {
        this.city=city;
        this.date= date;
        this.magnitude=magnitude;
        mUrl=url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getCity() {
        return city;
    }

    public long getDate() {
        return date;
    }
    }
