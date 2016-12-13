package com.daniilbelevtsev.zipapp.ui.presenter.presenters;

import com.daniilbelevtsev.zipapp.ui.view.interfaces.IMapView;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:47.
 * Project: ZipApp; Skype: pandamoni1
 */

public class MapPresenter extends BasePresenter<IMapView> {

    private IMapView view;

    public void init(IMapView view) {
        this.view = view;
    }

    @Override
    protected IMapView getView() {
        return view;
    }


}
