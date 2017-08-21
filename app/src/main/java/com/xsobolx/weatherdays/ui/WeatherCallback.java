package com.xsobolx.weatherdays.ui;

import android.support.v7.util.DiffUtil;

import com.xsobolx.weatherdays.data.WeatherVO;

import java.util.List;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 18/08/17.
 * email: asobol@ccsteam.ru
 */

public class WeatherCallback extends DiffUtil.Callback {

    List<WeatherVO> oldWeather;
    List<WeatherVO> newWather;

    public WeatherCallback(List<WeatherVO> oldWeather, List<WeatherVO> newWather) {
        this.oldWeather = oldWeather;
        this.newWather = newWather;
    }

    @Override
    public int getOldListSize() {
        return oldWeather.size();
    }

    @Override
    public int getNewListSize() {
        return newWather.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldWeather.get(oldItemPosition).equals(newWather.get(newItemPosition)); // need id
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldWeather.get(oldItemPosition).equals(newWather.get(newItemPosition));
    }
}
