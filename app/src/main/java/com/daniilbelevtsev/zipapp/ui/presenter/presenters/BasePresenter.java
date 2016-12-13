package com.daniilbelevtsev.zipapp.ui.presenter.presenters;

import com.daniilbelevtsev.zipapp.ui.model.IDataManager;
import com.daniilbelevtsev.zipapp.ui.presenter.interfaces.IBasePresenter;
import com.daniilbelevtsev.zipapp.ui.view.interfaces.IBaseView;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:47.
 * Project: ZipApp; Skype: pandamoni1
 */

public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter {

    public T view;

    @Inject
    protected IDataManager dataManager;

    @Inject
    protected CompositeSubscription compositeSubscription;

    public BasePresenter() {
    }

    @Override
    public void onStop() {
        compositeSubscription.clear();
    }

    protected abstract T getView();
}
