package com.daniilbelevtsev.zipapp.ui.presenter.presenters;

import com.daniilbelevtsev.zipapp.ui.app.TheApp;
import com.daniilbelevtsev.zipapp.ui.model.data.dto.City;
import com.daniilbelevtsev.zipapp.ui.view.interfaces.IListView;

import java.util.ArrayList;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:47.
 * Project: ZipApp; Skype: pandamoni1
 */

public class ListCityPresenter extends BaseCityPresenter<IListView> {

    private IListView view;

    public void init(IListView view) {
        TheApp.getAppComponent().inject(this);
        this.view = view;
    }

    @Override
    protected IListView getView() {
        return view;
    }

    public void onCreateView() {

    }

    @Override
    public void onCitiesUpdated(ArrayList<City> cities) {
        super.onCitiesUpdated(cities);
        getView().showCityList(cities);
    }
}
