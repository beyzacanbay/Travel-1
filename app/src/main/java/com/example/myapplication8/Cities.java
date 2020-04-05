package com.example.myapplication8;

import com.google.gson.annotations.SerializedName;

public class Cities {
    @SerializedName("Id")
    private int Id;

    @SerializedName("city_name")
    private String city_name;

    @SerializedName("description")
    private String text;

    @SerializedName("lat")
    private double lat;

    @SerializedName("lon")
    private double lon;

    public Cities(int Id,String city_name,String text,double lat,double lon){
        this.Id = Id;
        this.city_name=city_name;
        this.text = text;
        this.lat = lat;
        this.lon = lon;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
