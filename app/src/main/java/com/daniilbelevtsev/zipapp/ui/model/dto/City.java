package com.daniilbelevtsev.zipapp.ui.model.dto;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Daniil Belevtsev on 13.12.2016 21:08.
 * Project: ZipApp; Skype: pandamoni1
 */

public class City {

    @SerializedName("id")
    private String id;

    private String name;

    private LatLng coord;

    private String country;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LatLng getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "City [coord = " + coord + ", id = " + id + ", name = " + name + ", country = " + country + "]";
    }
}
