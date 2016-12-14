package com.daniilbelevtsev.zipapp.ui.presenter.interfaces;

import com.daniilbelevtsev.zipapp.ui.model.data.dto.City;

import java.util.ArrayList;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:41.
 * Project: ZipApp; Skype: pandamoni1
 */

public interface IBaseCityPresenter {
    void onStop();

    void onCitiesUpdated(ArrayList<City> cities);
}
