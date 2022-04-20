package com.napier.sem;

public class Population {
    public String Name;
    public long Population;
    public long CityPopulation;
    public String CityPercentage;
    public long NotCityPopulation;
    public String NotCityPercentage;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getPopulation() {
        return Population;
    }

    public void setPopulation(long population) {
        Population = population;
    }

    public long getCityPopulation() {
        return CityPopulation;
    }

    public void setCityPopulation(long cityPopulation) {
        CityPopulation = cityPopulation;
    }

    public String getCityPercentage() {
        return CityPercentage;
    }

    public void setCityPercentage(String cityPercentage) {
        CityPercentage = cityPercentage;
    }

    public long getNotCityPopulation() {
        return NotCityPopulation;
    }

    public void setNotCityPopulation(long notCityPopulation) {
        NotCityPopulation = notCityPopulation;
    }

    public String getNotCityPercentage() {
        return NotCityPercentage;
    }

    public void setNotCityPercentage(String notCityPercentage) {
        NotCityPercentage = notCityPercentage;
    }
}
