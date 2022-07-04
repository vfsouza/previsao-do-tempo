package com.tempo.model;

import java.util.Date;

public class LocalTemp {
    private String city;
    private double temperature;

    public LocalTemp() { }

    public LocalTemp(String city, double temperature) {
        this.city = city;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
