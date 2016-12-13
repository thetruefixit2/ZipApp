package com.daniilbelevtsev.zipapp.ui.presenter.presenters;

import com.daniilbelevtsev.zipapp.ui.app.TheApp;
import com.daniilbelevtsev.zipapp.ui.view.interfaces.IListView;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observer;
import rx.Subscription;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:47.
 * Project: ZipApp; Skype: pandamoni1
 */

public class ListPresenter extends BasePresenter<IListView> {

    private IListView view;


    public void init(IListView view) {
        TheApp.getAppComponent().inject(this);
        this.view = view;
    }

    @Override
    protected IListView getView() {
        return view;
    }

    public void loadCities() {
        Subscription sub = dataManager.downloadFile()
                .subscribe(new Observer<Response<ResponseBody>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showError(e.getMessage());
                    }

                    @Override
                    public void onNext(Response<ResponseBody> responseBodyResponse) {
                        System.out.println(responseBodyResponse);
                    }
                });
    }

    public void onCreateView() {

    }

    public void saveInstanceState() {

    }

}
