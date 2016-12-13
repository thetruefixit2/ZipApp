package com.daniilbelevtsev.zipapp.ui.di.modules;

import com.daniilbelevtsev.zipapp.ui.presenter.presenters.ListPresenter;
import com.daniilbelevtsev.zipapp.ui.presenter.presenters.MapPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniil Belevtsev on 13.12.2016 21:10.
 * Project: ZipApp; Skype: pandamoni1
 */
@Module
public class ViewModule {

    @Provides
    ListPresenter provideListPresenter() {
        return new ListPresenter();
    }

    @Provides
    MapPresenter provideMapPresenter() {
        return new MapPresenter();
    }

}
