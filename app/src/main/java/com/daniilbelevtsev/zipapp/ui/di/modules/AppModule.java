package com.daniilbelevtsev.zipapp.ui.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniil Belevtsev on 21.11.2016 21:20.
 * Project: ZipApp; Skype: pandamoni1
 */

@Module
public class AppModule {

    Context appContext;

    public AppModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return appContext;
    }
}
