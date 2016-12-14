package com.daniilbelevtsev.zipapp.ui.model;

import com.daniilbelevtsev.zipapp.ui.app.AppConsts;
import com.daniilbelevtsev.zipapp.ui.app.TheApp;
import com.daniilbelevtsev.zipapp.ui.model.api.OWApi;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observable;
import rx.Scheduler;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:41.
 * Project: ZipApp; Skype: pandamoni1
 */

public class DataManager implements IDataManager {

    private final Observable.Transformer schedulersTransformer;

    @Inject
    protected OWApi openWeatherApi;

    @Inject
    @Named(AppConsts.UI_THREAD)
    Scheduler uiThread;

    @Inject
    @Named(AppConsts.IO_THREAD)
    Scheduler ioThread;

    public DataManager() {
        TheApp.getAppComponent().inject(this);
        schedulersTransformer = o -> ((Observable) o).subscribeOn(ioThread)
                .observeOn(uiThread)
                .unsubscribeOn(ioThread);
    }


    public Observable<Response<ResponseBody>> downloadFile() {
        return openWeatherApi.getUSCityFile()
                .compose(applySchedulers());
    }

    @SuppressWarnings("unchecked")
    private <T> Observable.Transformer<T, T> applySchedulers() {
        return (Observable.Transformer<T, T>) schedulersTransformer;
    }
}
