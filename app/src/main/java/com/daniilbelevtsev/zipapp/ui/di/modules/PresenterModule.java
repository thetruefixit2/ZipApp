package com.daniilbelevtsev.zipapp.ui.di.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.daniilbelevtsev.zipapp.ui.model.DataManager;
import com.daniilbelevtsev.zipapp.ui.model.IDataManager;
import com.daniilbelevtsev.zipapp.ui.model.zipper.GZipClient;
import com.daniilbelevtsev.zipapp.ui.model.zipper.IGZipClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Daniil Belevtsev on 13.12.2016 21:10.
 * Project: ZipApp; Skype: pandamoni1
 */

@Module
public class PresenterModule {

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Context appContext) {
        return PreferenceManager.getDefaultSharedPreferences(appContext);
    }

    @Provides
    @Singleton
    IDataManager provideDataManager() {
        return new DataManager();
    }

    @Provides
    @Singleton
    IGZipClient provideGZipClient() {
        return new GZipClient();
    }

    @Provides
    CompositeSubscription provideCompositeSubscription() {
        return new CompositeSubscription();
    }
}
