package com.daniilbelevtsev.zipapp.ui.di.modules;

import com.daniilbelevtsev.zipapp.ui.model.DataManager;
import com.daniilbelevtsev.zipapp.ui.model.IDataManager;

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
    IDataManager provideDataManager() {
        return new DataManager();
    }

    @Provides
    CompositeSubscription provideCompositeSubscription() {
        return new CompositeSubscription();
    }
}
