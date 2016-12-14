package com.daniilbelevtsev.zipapp.ui.di.modules;

import com.daniilbelevtsev.zipapp.ui.presenter.presenters.ListCityPresenter;
import com.daniilbelevtsev.zipapp.ui.presenter.presenters.MapCityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniil Belevtsev on 13.12.2016 21:10.
 * Project: ZipApp; Skype: pandamoni1
 */
@Module
public class ViewModule {

    @Provides
    ListCityPresenter provideListPresenter() {
        return new ListCityPresenter();
    }

    @Provides
    MapCityPresenter provideMapPresenter() {
        return new MapCityPresenter();
    }

}
