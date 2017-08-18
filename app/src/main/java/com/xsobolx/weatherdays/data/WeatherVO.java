package com.xsobolx.weatherdays.data;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 18/08/17.
 * email: asobol@ccsteam.ru
 */

public class WeatherVO {

    private long date;
    private double day;
    private double min;
    private double max;
    private String description;

    public WeatherVO(long date, double day, double min, double max, String description) {
        this.date = date;
        this.day = day;
        this.min = min;
        this.max = max;
        this.description = description;
    }

    public long getDate() {
        return date;
    }

    public double getDay() {
        return day;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherVO weatherVO = (WeatherVO) o;

        if (date != weatherVO.date) return false;
        if (Double.compare(weatherVO.day, day) != 0) return false;
        if (Double.compare(weatherVO.min, min) != 0) return false;
        if (Double.compare(weatherVO.max, max) != 0) return false;
        return description != null ? description.equals(weatherVO.description) : weatherVO.description == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (date ^ (date >>> 32));
        temp = Double.doubleToLongBits(day);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(min);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(max);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WeatherVO{" +
                "date=" + date +
                ", day=" + day +
                ", max=" + max +
                ", min=" + min +
                ", description='" + description + '\'' +
                '}';
    }
}
