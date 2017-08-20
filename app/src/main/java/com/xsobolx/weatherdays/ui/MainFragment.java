package com.xsobolx.weatherdays.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xsobolx.weatherdays.Network.ApiFactory;
import com.xsobolx.weatherdays.Network.OpenWeatherMapService;
import com.xsobolx.weatherdays.R;
import com.xsobolx.weatherdays.data.WeatherDaysModel;
import com.xsobolx.weatherdays.data.WeatherVO;

import java.util.List;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 18/08/17.
 * email: asobol@ccsteam.ru
 */

public class MainFragment extends Fragment implements MainFragmentView, CallBack<String> {

    private RecyclerView rvMain;
    private SwipeRefreshLayout srlMain;
    private MainAdapter adapter;

    private MainPresenter mainPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        rvMain = view.findViewById(R.id.list_main);

        srlMain = view.findViewById(R.id.swipe_refresh_main);
        srlMain.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainPresenter.getWeather(OpenWeatherMapService.ID, OpenWeatherMapService.APP_ID);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvMain.setLayoutManager(llm);

        adapter = new MainAdapter(getContext(), this);
        rvMain.setAdapter(adapter);


        WeatherDaysModel model = new WeatherDaysModel(ApiFactory.getOpenWeatherMapService());
        mainPresenter = new MainPresenter(this, model);
        mainPresenter.onCreate();
    }

    @Override
    public void onPause() {
        super.onPause();
        mainPresenter.onDestroy();
    }

    @Override
    public void showLoading() {
        srlMain.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        srlMain.setRefreshing(false);
    }

    @Override
    public void showData(List<WeatherVO> weatherDays) {
        adapter.setWeatherDays(weatherDays);
    }

    @Override
    public void showToast(String date) {
        Toast.makeText(getContext(), date, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), "Error occurs, please try again later", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void call(String date) {
        mainPresenter.onClick(date);
    }
}
