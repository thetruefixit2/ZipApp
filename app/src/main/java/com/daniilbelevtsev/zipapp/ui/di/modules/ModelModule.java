package com.daniilbelevtsev.zipapp.ui.di.modules;

import com.daniilbelevtsev.zipapp.ui.app.AppConsts;
import com.daniilbelevtsev.zipapp.ui.model.api.OWApi;
import com.daniilbelevtsev.zipapp.ui.utils.JsonUtils;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Daniil Belevtsev on 19.11.2016 16:44.
 * Project: ZipApp; Skype: pandamoni1
 */

@Module
public class ModelModule {

    @Provides
    @Singleton
    OWApi provideOpenWeatherApi() {
        OkHttpClient client = new OkHttpClient();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(AppConsts.BULK_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        builder.client(client);
        return builder.build().create(OWApi.class);
    }

    @Provides
    @Singleton
    @Named(AppConsts.GSON_SERIALIZER)
    Gson provideSerializeGson() {
        return new GsonBuilder()
                .registerTypeAdapter(LatLng.class, JsonUtils.latLngSerializer)
                .create();
    }

    @Provides
    @Singleton
    @Named(AppConsts.GSON_DESERIALIZER)
    Gson provideDeserializeGson() {
        return new GsonBuilder()
                .registerTypeAdapter(LatLng.class, JsonUtils.latLngDeserializer)
                .create();
    }

    @Provides
    @Singleton
    @Named(AppConsts.UI_THREAD)
    Scheduler provideSchedulerUI() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @Named(AppConsts.IO_THREAD)
    Scheduler provideSchedulerIO() {
        return Schedulers.io();
    }

}
