package com.xsobolx.weatherdays.data;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 18/08/17.
 * email: asobol@ccsteam.ru
 */

public class WaetherVOMapper {

    @NonNull
    public static List<WeatherVO> getWeatherList(OpenWeatherResposne weather) {
        List<WeatherVO> weatherVOList = new ArrayList<>();
        for (OpenWeatherResposne.WeatherDay weatherDayDay : weather.getWeatherDayList()) {
            weatherVOList.add(getWeather(weatherDayDay));
        }
        return weatherVOList;
    }

    @NonNull
    private static WeatherVO getWeather(OpenWeatherResposne.WeatherDay weatherDay) {
        final int date = weatherDay.getDt();
        final double day = weatherDay.getTemp().getDay();
        final double min = weatherDay.getTemp().getMin();
        final double max = weatherDay.getTemp().getMax();
        final String description = weatherDay.getDescriptions().get(0) != null ?
                weatherDay.getDescriptions().get(0).getDescription() : "";

        return new WeatherVO(date, day, min, max, description);
    }

}
