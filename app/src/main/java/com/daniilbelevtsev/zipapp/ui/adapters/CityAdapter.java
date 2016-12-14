package com.daniilbelevtsev.zipapp.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daniilbelevtsev.zipapp.R;
import com.daniilbelevtsev.zipapp.ui.model.data.dto.City;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev on 14.12.2016 1:24.
 * Project: ZipApp; Skype: pandamoni1
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {


    private ArrayList<City> cities;

    public CityAdapter(ArrayList<City> cities) {
        this.cities = cities;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        if (cities != null) {
            return cities.size();
        } else {
            return 0;
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        City city = cities.get(position);
        holder.cityName.setText(city.getName());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cityName)
        TextView cityName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
