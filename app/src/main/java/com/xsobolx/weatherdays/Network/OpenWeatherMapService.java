package com.xsobolx.weatherdays.Network;

import com.xsobolx.weatherdays.data.OpenWeatherReposne;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 18/08/17.
 * email: asobol@ccsteam.ru
 */

public interface OpenWeatherMapService {

    @GET("/data/2.5/forecast/daily")
    Single<OpenWeatherReposne> getDailyForecast(@Query("id") String id,
                                                @Query("appid") String appId);

}
