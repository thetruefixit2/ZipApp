package com.daniilbelevtsev.zipapp.ui.model;

import com.daniilbelevtsev.zipapp.ui.model.zipper.IGZipClient;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observable;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:41.
 * Project: ZipApp; Skype: pandamoni1
 */

public interface IDataManager {
    Observable<Response<ResponseBody>> downloadFile();

    IGZipClient getGzipClient();
}
