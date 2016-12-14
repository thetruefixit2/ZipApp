package com.daniilbelevtsev.zipapp.ui.model.repo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.daniilbelevtsev.zipapp.ui.app.AppConsts;
import com.daniilbelevtsev.zipapp.ui.model.data.dto.City;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Daniil Belevtsev on 14.12.2016 19:52.
 * Project: ZipApp; Skype: pandamoni1
 */

public class CityRepository {

    protected Context context;
    protected Gson gsonSerializer;
    protected Gson gsonDeserializer;

    private SharedPreferences preferences;

    @Inject
    public CityRepository(Context appContext,
                          @Named(AppConsts.GSON_SERIALIZER) Gson gsonSerializer,
                          @Named(AppConsts.GSON_DESERIALIZER) Gson gsonDeserializer) {
        this.context = appContext;
        this.gsonSerializer = gsonSerializer;
        this.gsonDeserializer = gsonDeserializer;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void put(ArrayList<City> cities) {
        String json = gsonSerializer.toJson(cities);
        preferences.edit().putString(AppConsts.EXTRA_CITY_LIST, json).apply();
    }

    public ArrayList<City> get() {
        if (isExists()) {
            String json = preferences.getString(AppConsts.EXTRA_CITY_LIST, "");
            if (!json.equals("")) {
                Type listType = new TypeToken<ArrayList<City>>() {
                }.getType();
                return gsonDeserializer.fromJson(json, listType);
            }
        }
        return new ArrayList<>();
    }

    public boolean isExists() {
        return preferences.contains(AppConsts.EXTRA_CITY_LIST);
    }

}
