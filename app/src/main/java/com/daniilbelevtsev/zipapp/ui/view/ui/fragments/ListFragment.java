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
import com.daniilbelevtsev.zipapp.ui.model.dto.City;
import com.daniilbelevtsev.zipapp.ui.utils.SimpleItemDecoration;
import com.daniilbelevtsev.zipapp.ui.view.interfaces.IListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:38.
 * Project: ZipApp; Skype: pandamoni1
 */

public class ListFragment extends BaseFragment implements IListView {

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
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void buildUI() {
        activityCallback.showLoading(R.string.loading_in_progress);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new SimpleItemDecoration(getContext()));
    }

    @Override
    public void buildData() {
        if (adapter == null) {
            adapter = new CityAdapter(new ArrayList<>());
        }
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void showCityList(ArrayList<City> cities) {
        adapter = new CityAdapter(cities);
        recyclerView.setAdapter(adapter);
    }

}
