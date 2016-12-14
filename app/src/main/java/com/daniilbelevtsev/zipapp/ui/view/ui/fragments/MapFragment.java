package com.daniilbelevtsev.zipapp.ui.view.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daniilbelevtsev.zipapp.R;
import com.daniilbelevtsev.zipapp.ui.app.TheApp;
import com.daniilbelevtsev.zipapp.ui.model.data.dto.City;
import com.daniilbelevtsev.zipapp.ui.presenter.presenters.MapCityPresenter;
import com.daniilbelevtsev.zipapp.ui.view.interfaces.IMapView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev on 13.12.2016 20:38.
 * Project: ZipApp; Skype: pandamoni1
 */

public class MapFragment extends BaseFragment<MapCityPresenter> implements IMapView, OnMapReadyCallback {

    @Inject
    protected MapCityPresenter presenter;
    @BindView(R.id.mapView)
    MapView mapView;

    private GoogleMap map;
    private ClusterManager<City> clusterManager;

    public static MapFragment newInstance() {
        Bundle args = new Bundle();
        MapFragment fragment = new MapFragment();
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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this, view);
        mapView.onCreate(savedInstanceState);
        presenter.onCreateView();
        buildUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    public void buildUI() {
        MapsInitializer.initialize(getContext());
        mapView.getMapAsync(this);
    }

    public void buildData() {
        presenter.loadCities();
    }

    private void setUpClusterer() {
        clusterManager = new ClusterManager<City>(getContext(), map);
        clusterManager.setRenderer(new DefaultClusterRenderer<>(getContext(), map, clusterManager));
        map.setOnCameraIdleListener(clusterManager);
        map.setOnMarkerClickListener(clusterManager);

    }

    private void setDefaultCameraPosition() {
        if (map != null) {
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.742043, -104.991531), 2)); // denver
        }
    }

    public void showMarkers(ArrayList<City> cities) {
        if (map != null && clusterManager != null) {
            clusterManager.clearItems();
            for (int i = 0; i < cities.size(); i++) {
                clusterManager.addItem(cities.get(i));
            }
            clusterManager.cluster();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.map = googleMap;
        map.getUiSettings().setZoomControlsEnabled(true);
        map.getUiSettings().setZoomGesturesEnabled(true);
        setDefaultCameraPosition();
        setUpClusterer();
        buildData();
    }

    @Override
    protected MapCityPresenter getPresenter() {
        return presenter;
    }


}
