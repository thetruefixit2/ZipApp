package com.daniilbelevtsev.zipapp.ui.model.api;


import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:42.
 * Project: ZipApp; Skype: pandamoni1
 */

public interface OWApi {

    @GET("/sample/city.list.us.json.gz")
    Observable<Response<ResponseBody>> getUSCityFile();

}
