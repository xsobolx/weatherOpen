package com.xsobolx.weatherdays.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xsobolx.weatherdays.R;
import com.xsobolx.weatherdays.data.WeatherVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 18/08/17.
 * email: asobol@ccsteam.ru
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.WeatherViewHolder> {

    private Context context;
    private CallBack<String> callBack;
    private List<WeatherVO> weatherDays = new ArrayList<>();

    public MainAdapter(Context context, CallBack<String> callBack) {
        this.context = context;
        this.callBack = callBack;
    }

    public void setWeatherDays(List<WeatherVO> weatherDays) {
        this.weatherDays = weatherDays;
        notifyDataSetChanged();
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_main, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        final WeatherVO weather = weatherDays.get(position);

        holder.date.setText(formatDate(weather.getDate()));
        holder.day.setText(String.valueOf(weather.getDay()));
        holder.min.setText(String.valueOf(weather.getMin()));
        holder.max.setText(String.valueOf(weather.getMax()));
        holder.description.setText(weather.getDescription());
    }

    @Override
    public int getItemCount() {
        return weatherDays.size();
    }

    private String formatDate(long date) {
        return DateUtils.formatDateTime(context, date,
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NUMERIC_DATE | DateUtils.FORMAT_SHOW_YEAR);
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView date;
        private TextView day;
        private TextView min;
        private TextView max;
        private TextView description;

        WeatherViewHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            day  = itemView.findViewById(R.id.day);
            min = itemView.findViewById(R.id.min);
            max = itemView.findViewById(R.id.max);
            description = itemView.findViewById(R.id.descriptions);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            callBack.call(formatDate(weatherDays.get(0).getDate()));
        }
    }
}
