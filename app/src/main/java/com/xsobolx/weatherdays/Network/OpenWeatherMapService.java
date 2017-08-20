package com.xsobolx.weatherdays.Network;

import com.xsobolx.weatherdays.data.OpenWeatherResposne;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 18/08/17.
 * email: asobol@ccsteam.ru
 */

public interface OpenWeatherMapService {

    public static final String ID = "524901";
    public static final String APP_ID = "1768e2cb3a5a952ffec2b094080ebad9";

    @GET("/data/2.5/forecast/daily")
    Single<OpenWeatherResposne> getDailyForecast(@Query("id") String id,
                                                 @Query("appid") String appId);

}
