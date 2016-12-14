package com.daniilbelevtsev.zipapp.ui.utils;

import com.daniilbelevtsev.zipapp.ui.app.AppConsts;
import com.daniilbelevtsev.zipapp.ui.model.data.dto.City;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;


/**
 * Created by Daniil Belevtsev on 14.12.2016 16:01.
 * Project: ZipApp; Skype: pandamoni1
 * This class priority is decompressing gzip city file to normal array
 */

public class RxGzipParser implements Func1<File, Observable<ArrayList<City>>> {

    public static final int BUFFER_SIZE = 1024;
    public static final int GZPIP_LINE_LIMIT = 1000;
    private Gson gsonDeserializer;

    @Inject
    public RxGzipParser(@Named(AppConsts.GSON_DESERIALIZER) Gson gsonDeserializer) {
        this.gsonDeserializer = gsonDeserializer;
    }

    @Override
    public Observable<ArrayList<City>> call(File file) {
        return decompressGZIP(file);
    }

    private Observable<ArrayList<City>> decompressGZIP(final File file) {
        return Observable.create(new Observable.OnSubscribe<ArrayList<City>>() {
            @Override
            public void call(Subscriber<? super ArrayList<City>> subscriber) {
                byte[] buffer = new byte[BUFFER_SIZE];
                ArrayList<City> cities = new ArrayList<>();
                try {
                    GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(file));
                    InputStreamReader reader = new InputStreamReader(gzis);
                    BufferedReader in = new BufferedReader(reader);

                    int count = 0;
                    String jsonElement;
                    while ((jsonElement = in.readLine()) != null && count <= GZPIP_LINE_LIMIT) {
                        cities.add(gsonDeserializer.fromJson(jsonElement, City.class));
                        count++;
                    }
                    gzis.close();
                    in.close();
                    subscriber.onNext(cities);
                    subscriber.onCompleted();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    subscriber.onError(ex);
                }
            }
        });
    }

}
