package com.xsobolx.weatherdays.data;

import android.support.annotation.NonNull;

import com.xsobolx.weatherdays.Network.OpenWeatherMapService;

import io.reactivex.Single;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 18/08/17.
 * email: asobol@ccsteam.ru
 */

public class WeatherDaysModel {

    private OpenWeatherMapService service;

    public WeatherDaysModel(OpenWeatherMapService service) {
        this.service = service;
    }

    public Single<OpenWeatherResposne> getWeather(@NonNull final String id, @NonNull final String appId) {
        return service.getDailyForecast(id, appId);
    }

}
