package com.daniilbelevtsev.zipapp.ui.presenter.presenters;

import com.daniilbelevtsev.zipapp.ui.model.IDataManager;
import com.daniilbelevtsev.zipapp.ui.model.data.dto.City;
import com.daniilbelevtsev.zipapp.ui.model.repo.CityRepository;
import com.daniilbelevtsev.zipapp.ui.presenter.interfaces.IBaseCityPresenter;
import com.daniilbelevtsev.zipapp.ui.utils.RxGzipParser;
import com.daniilbelevtsev.zipapp.ui.utils.RxSaver;
import com.daniilbelevtsev.zipapp.ui.view.interfaces.IBaseView;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:47.
 * Project: ZipApp; Skype: pandamoni1
 */

public abstract class BaseCityPresenter<T extends IBaseView> implements IBaseCityPresenter {

    protected T view;

    @Inject
    protected IDataManager dataManager;

    @Inject
    protected RxGzipParser gzipParser;

    @Inject
    protected CityRepository repository;

    @Inject
    protected RxSaver fileSaver;

    @Inject
    protected CompositeSubscription compositeSubscription;

    public BaseCityPresenter() {
    }

    public void loadCities() {
        if (repository.isExists()) {
            onCitiesUpdated(repository.get());
        } else {
            Subscription sub = dataManager.downloadFile()
                    .flatMap(fileSaver)
                    .flatMap(gzipParser)
                    .subscribe(new Observer<ArrayList<City>>() {
                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable e) {
                            getView().showError(e.getMessage());
                        }

                        @Override
                        public void onNext(ArrayList<City> cities) {
                            onCitiesUpdated(cities);
                        }
                    });
            addSubscription(sub);
        }
    }

    protected void addSubscription(Subscription sub) {
        compositeSubscription.add(sub);
    }

    @Override
    public void onCitiesUpdated(ArrayList<City> cities) {
        repository.put(cities);
    }

    @Override
    public void onStop() {
        if (compositeSubscription != null) {
            compositeSubscription.clear();
        }
    }

    protected abstract T getView();
}
