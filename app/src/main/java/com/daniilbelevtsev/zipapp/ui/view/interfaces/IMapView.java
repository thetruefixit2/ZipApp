package com.daniilbelevtsev.zipapp.ui.view.interfaces;

import com.daniilbelevtsev.zipapp.ui.model.data.dto.City;

import java.util.ArrayList;

/**
 * Created by Daniil Belevtsev on 13.12.2016 23:48.
 * Project: ZipApp; Skype: pandamoni1
 */

public interface IMapView extends IBaseView {
    void showMarkers(ArrayList<City> cities);
}
