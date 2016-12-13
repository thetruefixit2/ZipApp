package com.daniilbelevtsev.zipapp.ui.model.zipper;

import android.content.Context;
import android.content.Intent;

import com.daniilbelevtsev.zipapp.ui.app.AppConsts;
import com.daniilbelevtsev.zipapp.ui.model.GZipService;

import javax.inject.Inject;

/**
 * Created by Daniil Belevtsev on 13.12.2016 22:33.
 * Project: ZipApp; Skype: pandamoni1
 */

public class GZipClient implements IGZipClient {

    @Inject
    Context appContext;

    @Override
    public void start(String filename) {
        Intent intent = new Intent(appContext, GZipService.class);
        intent.putExtra(AppConsts.EXTRA_FILENAME, filename);
        appContext.startService(intent);
    }

    @Override
    public void stop() {
        //
    }
}
