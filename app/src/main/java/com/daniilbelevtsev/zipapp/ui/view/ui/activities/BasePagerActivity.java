package com.daniilbelevtsev.zipapp.ui.view.ui.activities;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.daniilbelevtsev.zipapp.R;
import com.daniilbelevtsev.zipapp.ui.adapters.PagerFragmentAdapter;
import com.daniilbelevtsev.zipapp.ui.listeners.OnPagerActivityCallbackListener;
import com.daniilbelevtsev.zipapp.ui.utils.FragmentID;
import com.daniilbelevtsev.zipapp.ui.view.interfaces.IBaseView;
import com.daniilbelevtsev.zipapp.ui.view.ui.custom.LoadingView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:39.
 * Project: ZipApp; Skype: pandamoni1
 */

public class BasePagerActivity extends AppCompatActivity implements IBaseView, OnPagerActivityCallbackListener {

    @BindView(R.id.loadingView)
    LoadingView loadingView;

    @BindView(R.id.fragment_pager)
    ViewPager pager;

    @BindView(R.id.btnSwitchList)
    Button btnSwitchList;

    @BindView(R.id.btnSwitchMap)
    Button btnSwitchMap;

    private PagerFragmentAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();
    }

    public void initUI() {
        showLoading();
        if (adapter == null) {
            adapter = new PagerFragmentAdapter(getSupportFragmentManager(), this);
        }
        pager.setAdapter(adapter);
    }

    @OnClick(R.id.btnSwitchList)
    void onListSelected() {
        getPager().setCurrentItem(FragmentID.FRAGMENT_LIST);
    }

    @OnClick(R.id.btnSwitchMap)
    void onMapSelected() {
        getPager().setCurrentItem(FragmentID.FRAGMENT_MAP);
    }

    @Override
    public void showLoading(@StringRes int loadingMessage) {
        loadingView.setErrorText(loadingMessage);
        pager.setVisibility(View.GONE);
        loadingView.setVisibility(View.VISIBLE);

    }

    public void showLoading() {
        loadingView.setErrorText(R.string.loading_in_progress);
        pager.setVisibility(View.GONE);
        loadingView.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        pager.setVisibility(View.VISIBLE);
        loadingView.setVisibility(View.GONE);
    }

    @Override
    public void showError(String errorMessage) {

    }

    public ViewPager getPager() {
        return pager;
    }

    public PagerFragmentAdapter getAdapter() {
        return adapter;
    }
}