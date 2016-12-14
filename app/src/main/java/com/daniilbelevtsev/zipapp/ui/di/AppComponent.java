package com.daniilbelevtsev.zipapp.ui.di;

import com.daniilbelevtsev.zipapp.ui.di.modules.AppModule;
import com.daniilbelevtsev.zipapp.ui.di.modules.ModelModule;
import com.daniilbelevtsev.zipapp.ui.di.modules.PresenterModule;
import com.daniilbelevtsev.zipapp.ui.di.modules.ViewModule;
import com.daniilbelevtsev.zipapp.ui.model.DataManager;
import com.daniilbelevtsev.zipapp.ui.presenter.presenters.ListCityPresenter;
import com.daniilbelevtsev.zipapp.ui.presenter.presenters.MapCityPresenter;
import com.daniilbelevtsev.zipapp.ui.view.ui.fragments.ListFragment;
import com.daniilbelevtsev.zipapp.ui.view.ui.fragments.MapFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:43.
 * Project: ZipApp; Skype: pandamoni1
 */
@Singleton
@Component(modules = {AppModule.class, ModelModule.class, ViewModule.class, PresenterModule.class})
public interface AppComponent {
    ///////////////////////////////////////////////////////////////////////////
    // MODEL
    ///////////////////////////////////////////////////////////////////////////
    void inject(DataManager dataManager);

    ///////////////////////////////////////////////////////////////////////////
    // Views
    ///////////////////////////////////////////////////////////////////////////

    void inject(ListFragment fragment);

    void inject(MapFragment fragment);

    ///////////////////////////////////////////////////////////////////////////
    // PRESENTER
    ///////////////////////////////////////////////////////////////////////////


    void inject(ListCityPresenter presenter);

    void inject(MapCityPresenter presenter);


}
