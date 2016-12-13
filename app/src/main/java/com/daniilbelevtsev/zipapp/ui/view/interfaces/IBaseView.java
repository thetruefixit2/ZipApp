package com.daniilbelevtsev.zipapp.ui.view.interfaces;

import android.support.annotation.StringRes;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:41.
 * Project: ZipApp; Skype: pandamoni1
 */

public interface IBaseView {
    void showError(String errorMessage);

    void showLoading(@StringRes int loadingMessage);

    void hideLoading();
}
