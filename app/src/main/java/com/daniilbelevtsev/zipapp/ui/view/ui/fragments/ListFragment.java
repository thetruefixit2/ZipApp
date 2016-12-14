package com.daniilbelevtsev.zipapp.ui.view.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daniilbelevtsev.zipapp.R;
import com.daniilbelevtsev.zipapp.ui.adapters.CityAdapter;
import com.daniilbelevtsev.zipapp.ui.app.TheApp;
import com.daniilbelevtsev.zipapp.ui.model.data.dto.City;
import com.daniilbelevtsev.zipapp.ui.presenter.presenters.ListCityPresenter;
import com.daniilbelevtsev.zipapp.ui.utils.SimpleItemDecoration;
import com.daniilbelevtsev.zipapp.ui.view.interfaces.IListView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:38.
 * Project: ZipApp; Skype: pandamoni1
 */

public class ListFragment extends BaseFragment<ListCityPresenter> implements IListView {

    @Inject
    protected ListCityPresenter presenter;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private CityAdapter adapter;

    public static ListFragment newInstance() {
        Bundle args = new Bundle();
        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        TheApp.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        presenter.init(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);
        buildUI();
        presenter.onCreateView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buildData();
    }

    public void buildUI() {
        hideLoading();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new SimpleItemDecoration(getContext()));
    }

    public void buildData() {
        if (adapter == null) {
            ArrayList<City> cities = new ArrayList<>();
            adapter = new CityAdapter(cities);
            presenter.loadCities();
        }
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void showCityList(ArrayList<City> cities) {
        adapter = new CityAdapter(cities);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        System.out.println(adapter.getItemCount());

    }

    @Override
    protected ListCityPresenter getPresenter() {
        return presenter;
    }
}
