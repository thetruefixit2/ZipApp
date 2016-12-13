package com.daniilbelevtsev.zipapp.ui.view.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daniilbelevtsev.zipapp.ui.listeners.OnPagerActivityCallbackListener;
import com.daniilbelevtsev.zipapp.ui.view.interfaces.IBaseView;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:37.
 * Project: ZipApp; Skype: pandamoni1
 */

public abstract class BaseFragment extends Fragment implements IBaseView {

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        buildUI();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        buildData();
    }

    public void buildUI() {

    }

    public void buildData() {

    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void showLoading(@StringRes int loadingMessage) {

    }

    @Override
    public void hideLoading() {

    }

}
