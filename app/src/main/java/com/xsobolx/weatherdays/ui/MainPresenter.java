package com.xsobolx.weatherdays.ui;

import android.util.Log;

import com.xsobolx.weatherdays.data.OpenWeatherReposne;
import com.xsobolx.weatherdays.data.WaetherVOMapper;
import com.xsobolx.weatherdays.data.WeatherDaysModel;
import com.xsobolx.weatherdays.data.WeatherVO;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 18/08/17.
 * email: asobol@ccsteam.ru
 */

public class MainPresenter {

    private static final String ID = "524901";
    private static final String APP_ID = "1768e2cb3a5a952ffec2b094080ebad9";

    private MainFragmentView view;
    private WeatherDaysModel model;

    public MainPresenter(MainFragmentView view,
                         WeatherDaysModel model) {
        this.view = view;
        this.model = model;
    }

    public void onCreate() {
        getWeather(ID, APP_ID);
    }

    public void onDestroy() {
    }

    public void onClick(String date) {
        view.showToast(date);
    }

    public void getWeather(@NonNull final String id, @NonNull final String appId) {
        model.getWeather(id, appId)
                .map(new Function<OpenWeatherReposne, List<WeatherVO>>() {
                    @Override
                    public List<WeatherVO> apply(@NonNull OpenWeatherReposne openWeatherReposne) throws Exception {
                        return WaetherVOMapper.getWeatherList(openWeatherReposne);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        view.showLoading();
                    }
                })
                .doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        view.hideLoading();
                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableSingleObserver<List<WeatherVO>>() {
                    @Override
                    public void onSuccess(@NonNull List<WeatherVO> weatherVOs) {
                        view.showData(weatherVOs);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("PRESENTER", e.getLocalizedMessage(), e);
                        view.showError();
                    }
                });
    }

}
