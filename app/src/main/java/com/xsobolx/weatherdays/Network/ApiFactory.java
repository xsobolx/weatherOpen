package com.xsobolx.weatherdays.Network;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 18/08/17.
 * email: asobol@ccsteam.ru
 */

public class ApiFactory {

    private static final String API_ENDPOINT = "http://samples.openweathermap.org";

    private static OkHttpClient sClient;
    private static OpenWeatherMapService sOpenWeatherMapService;

    private ApiFactory() {
    }

    public static OpenWeatherMapService getOpenWeatherMapService() {
        OpenWeatherMapService service = sOpenWeatherMapService;

        if (service == null) {
            synchronized (ApiFactory.class) {
                service = sOpenWeatherMapService;
                if (service == null) {
                    service = sOpenWeatherMapService = buildRetrofit().create(OpenWeatherMapService.class);
                }
            }
        }
        return service;
    }

    @NonNull
    private static OkHttpClient getClient() {
        OkHttpClient client = sClient;
        if (client == null) {
            synchronized (ApiFactory.class) {
                client = sClient;
                if (client == null) {
                    client = sClient = buildClient();
                }
            }
        }
        return client;
    }

    @NonNull
    private static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    @NonNull
    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
