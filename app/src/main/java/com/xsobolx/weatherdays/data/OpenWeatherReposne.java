package com.xsobolx.weatherdays.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 18/08/17.
 * email: asobol@ccsteam.ru
 */

public class OpenWeatherReposne {

    @SerializedName("list")
    private List<WeatherDay> weatherDayList;

    public OpenWeatherReposne() {

    }

    public List<WeatherDay> getWeatherDayList() {
        return weatherDayList;
    }

    public void setWeatherDayList(List<WeatherDay> weatherDayList) {
        this.weatherDayList = weatherDayList;
    }

    @Override
    public String toString() {
        return "OpenWeatherReposne{" +
                ", weatherDayList=" + weatherDayList + '}';
    }

    public static class WeatherDay {

        @SerializedName("dt")
        private int dt;

        @SerializedName("temp")
        private TempBean temp;

        @SerializedName("weather")
        private List<Description> descriptions;

        public int getDt() {
            return dt;
        }

        public void setDt(int dt) {
            this.dt = dt;
        }

        public TempBean getTemp() {
            return temp;
        }

        public void setTemp(TempBean temp) {
            this.temp = temp;
        }

        public List<Description> getDescriptions() {
            return descriptions;
        }

        public void setDescriptions(List<Description> descriptions) {
            this.descriptions = descriptions;
        }

        @Override
        public String toString() {
            return "WeatherDay{" +
                    "dt=" + dt +
                    ", temp=" + temp +
                    ", descriptions=" + descriptions +
                    '}';
        }

        public static class TempBean {

            @SerializedName("day")
            private double day;

            @SerializedName("min")
            private double min;

            @SerializedName("max")
            private double max;

            public double getDay() {
                return day;
            }

            public void setDay(double day) {
                this.day = day;
            }

            public double getMin() {
                return min;
            }

            public void setMin(double min) {
                this.min = min;
            }

            public double getMax() {
                return max;
            }

            public void setMax(double max) {
                this.max = max;
            }

            @Override
            public String toString() {
                return "TempBean{" +
                        "day=" + day +
                        ", min=" + min +
                        ", max=" + max +
                        '}';
            }
        }

        public static class Description {

            @SerializedName("description")
            private String description;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            @Override
            public String toString() {
                return "Description{" +
                        ", description='" + description + '\'' +
                        '}';
            }
        }
    }
}
