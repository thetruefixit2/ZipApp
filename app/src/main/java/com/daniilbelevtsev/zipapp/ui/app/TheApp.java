package com.daniilbelevtsev.zipapp.ui.app;

import android.app.Application;

import com.daniilbelevtsev.zipapp.ui.di.AppComponent;
import com.daniilbelevtsev.zipapp.ui.di.DaggerAppComponent;
import com.daniilbelevtsev.zipapp.ui.di.modules.AppModule;
import com.daniilbelevtsev.zipapp.ui.di.modules.ModelModule;
import com.daniilbelevtsev.zipapp.ui.di.modules.PresenterModule;
import com.daniilbelevtsev.zipapp.ui.di.modules.ViewModule;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:39.
 * Project: ZipApp; Skype: pandamoni1
 */

public class TheApp extends Application {
    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildComponent();
    }

    private AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .modelModule(new ModelModule())
                .viewModule(new ViewModule())
                .presenterModule(new PresenterModule())
                .build();
    }
}
