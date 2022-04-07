package com.napier.sem;

import java.math.BigInteger;

public class Population {
    public String Name;
    public BigInteger Population;
    public BigInteger CityPopulation;
    public String CityPercentage;
    public BigInteger NotCityPopulation;
    public String NotCityPercentage;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public BigInteger getPopulation() {
        return Population;
    }

    public void setPopulation(BigInteger population) {
        Population = population;
    }

    public BigInteger getCityPopulation() {
        return CityPopulation;
    }

    public void setCityPopulation(BigInteger cityPopulation) {
        CityPopulation = cityPopulation;
    }

    public String getCityPercentage() {
        return CityPercentage;
    }

    public void setCityPercentage(String cityPercentage) {
        CityPercentage = cityPercentage;
    }

    public BigInteger getNotCityPopulation() {
        return NotCityPopulation;
    }

    public void setNotCityPopulation(BigInteger notCityPopulation) {
        NotCityPopulation = notCityPopulation;
    }

    public String getNotCityPercentage() {
        return NotCityPercentage;
    }

    public void setNotCityPercentage(String notCityPercentage) {
        NotCityPercentage = notCityPercentage;
    }
}
