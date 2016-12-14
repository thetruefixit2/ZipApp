package com.daniilbelevtsev.zipapp.ui.model.data.dto;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by Daniil Belevtsev on 13.12.2016 21:08.
 * Project: ZipApp; Skype: pandamoni1
 */

public class City implements ClusterItem {

    @SerializedName("id")
    private String id;

    private String name;

    private LatLng coord;

    private String country;

    public City(String id, String name, LatLng coord, String country) {
        this.id = id;
        this.name = name;
        this.coord = coord;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public LatLng getPosition() {
        return coord;
    }

    @Override
    public String toString() {
        return "City [coord = " + coord + ", id = " + id + ", name = " + name + ", country = " + country + "]";
    }

}
