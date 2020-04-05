package com.example.myapplication8;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Region {


    private int Id;
    private String region_name;

    public Region(int Id, String region_name){
        this.Id= Id;
        this.region_name=region_name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }
}
