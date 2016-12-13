package com.daniilbelevtsev.zipapp.ui.utils;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by Daniil Belevtsev on 22.11.2016 0:36.
 * Project: ZipApp; Skype: pandamoni1
 */

public class JsonUtils {

    private static final String LATITUDE_ELEMENT = "lat";
    private static final String LONGITUDE_ELEMENT = "lon";

    public static JsonSerializer<LatLng> latLngSerializer = new JsonSerializer<LatLng>() {
        @Override
        public JsonElement serialize(LatLng src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject result = new JsonObject();
            result.addProperty(LATITUDE_ELEMENT, src.latitude);
            result.addProperty(LONGITUDE_ELEMENT, src.longitude);
            return result;
        }
    };

    public static JsonDeserializer<LatLng> latLngDeserializer = new JsonDeserializer<LatLng>() {
        @Override
        public LatLng deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            Double lat = jsonObject.get(LATITUDE_ELEMENT).getAsDouble();
            Double lon = jsonObject.get(LONGITUDE_ELEMENT).getAsDouble();
            return new LatLng(lat, lon);
        }
    };


}
