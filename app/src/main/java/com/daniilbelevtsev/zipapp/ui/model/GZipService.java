package com.daniilbelevtsev.zipapp.ui.model;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;

import com.daniilbelevtsev.zipapp.ui.app.AppConsts;
import com.daniilbelevtsev.zipapp.ui.events.Event;
import com.daniilbelevtsev.zipapp.ui.events.Operation;

import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

/**
 * Created by Daniil Belevtsev on 13.12.2016 21:53.
 * Project: ZipApp; Skype: pandamoni1
 */

public class GZipService extends IntentService {

    public static final String TAG = GZipService.class.getSimpleName();
    public static final int BUFFER_SIZE = 1024;
    public static final int GZPIP_LINE_LIMIT = 1000;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public GZipService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle bundle = intent.getExtras();
        String filename;
        if (bundle != null) {
            filename = bundle.getString(AppConsts.EXTRA_FILENAME);
            if (filename != null && filename.length() > 0) {
                decompressGZIP(filename);
            }
        }


    }

    public void decompressGZIP(String filename) {
        byte[] buffer = new byte[BUFFER_SIZE];
        try {
            GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(filename));
            InputStreamReader reader = new InputStreamReader(gzis);
            BufferedReader in = new BufferedReader(reader);

            int count = 0;
            String jsonElement;
            while ((jsonElement = in.readLine()) != null && count <= GZPIP_LINE_LIMIT) {
                onNextElementParsed(jsonElement);
                count++;
            }

            gzis.close();
            in.close();

        } catch (IOException ex) {
            onError(ex.getMessage());
        }

        onFileParsed();
    }

    public void stop() {
        stopSelf();
    }

    public void onNextElementParsed(String json) {
        EventBus.getDefault().post(new Event<String>(Operation.ZIP_ON_NEXT_ELEMENT_PARSED, json));
    }

    /**
     * Send event when parsing is ended.
     * I can post full list, but it's A BIG FILE. It is just a event-notification.
     */
    public void onFileParsed() {
        EventBus.getDefault().post(new Event<String>(Operation.ZIP_ON_FILE_PARSED, "NO_DATA"));
    }

    public void onError(String error) {
        EventBus.getDefault().post(new Event<String>(Operation.ZIP_ERROR, error));
    }
}
