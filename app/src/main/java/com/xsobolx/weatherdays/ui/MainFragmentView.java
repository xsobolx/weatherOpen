package com.xsobolx.weatherdays.ui;

import com.xsobolx.weatherdays.data.WeatherVO;

import java.util.List;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 18/08/17.
 * email: asobol@ccsteam.ru
 */

public interface MainFragmentView {

    void showLoading();

    void hideLoading();

    void showData(List<WeatherVO> weatherDays);

    void showToast(String date);

    void showError();

}
