package com.daniilbelevtsev.zipapp.ui.view.ui.fragments;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import com.daniilbelevtsev.zipapp.ui.listeners.OnPagerActivityCallbackListener;
import com.daniilbelevtsev.zipapp.ui.presenter.interfaces.IBaseCityPresenter;
import com.daniilbelevtsev.zipapp.ui.view.interfaces.IBaseView;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:37.
 * Project: ZipApp; Skype: pandamoni1
 */

public abstract class BaseFragment<T extends IBaseCityPresenter> extends Fragment implements IBaseView {

    protected OnPagerActivityCallbackListener activityCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPagerActivityCallbackListener) {
            activityCallback = (OnPagerActivityCallbackListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnPagerActivityCallbackListener");
        }
    }

    @Override
    public void onStop() {
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
        super.onStop();

    }

    @Override
    public void showError(String errorMessage) {
        if (activityCallback != null) {
            activityCallback.showError(errorMessage);
        }
    }

    @Override
    public void showLoading(@StringRes int loadingMessage) {
        if (activityCallback != null) {
            activityCallback.showLoading(loadingMessage);
        }
    }

    @Override
    public void hideLoading() {
        if (activityCallback != null) {
            activityCallback.hideLoading();
        }
    }

    protected abstract T getPresenter();

}
