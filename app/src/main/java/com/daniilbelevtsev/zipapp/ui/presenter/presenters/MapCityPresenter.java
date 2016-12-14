package com.daniilbelevtsev.zipapp.ui.presenter.presenters;

import com.daniilbelevtsev.zipapp.ui.app.TheApp;
import com.daniilbelevtsev.zipapp.ui.model.data.dto.City;
import com.daniilbelevtsev.zipapp.ui.view.interfaces.IMapView;

import java.util.ArrayList;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:47.
 * Project: ZipApp; Skype: pandamoni1
 */

public class MapCityPresenter extends BaseCityPresenter<IMapView> {

    private IMapView view;

    public void init(IMapView view) {
        TheApp.getAppComponent().inject(this);
        this.view = view;
    }

    public void onCreateView() {

    }

    @Override
    public void onCitiesUpdated(ArrayList<City> cities) {
        super.onCitiesUpdated(cities);
        getView().showMarkers(cities);
    }

    @Override
    protected IMapView getView() {
        return view;
    }


}
