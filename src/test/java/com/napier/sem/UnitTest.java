package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
    }

    /**
     * Test printCountries when passing null as parameter
     */
    @Test
    void printCountriesNull() {
        app.printCountries(null);
    }

    /**
     * Test printCountries when passing an empty ArrayList as a parameter
     */
    @Test
    void printCountriesEmpty() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountries(countries);
    }

    /**
     * Test printCountries when passing an ArrayList that contains a null as a parameter
     */
    @Test
    void printCountriesContainsNull() {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.printCountries(countries);
    }

    /**
     * Test final printCountries to make sure it prints a normal ArrayList
     */
    @Test
    void printCountries() {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country cnt = new Country();
        cnt.setCode("CHN");
        cnt.setName("China");
        cnt.setContinent("Asia");
        cnt.setRegion("Eastern Asia");
        cnt.setPopulation(1277558000);
        cnt.setCapital("1819");
        countries.add(cnt);
        app.printCountries(countries);
    }

    /**
     * Test printCities when passing null as parameter
     */
    @Test
    void printCitiesTestNull() {
        app.printCities(null);
    }

    /**
     * test printCities when passing an empty ArrayList as a parameter
     */
    @Test
    void printCitiesTestEmpty() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCities(cities);
    }

    /**
     * test printCities when passing an ArrayList containing null as a parameter
     */
    @Test
    void printCitiesTestContainsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.printCities(cities);
    }

    /**
     * testing the final printCities with a normal ArrayList
     */
    @Test
    void printCities() {
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City();
        city.Name = "TestCity";
        city.CountryCode = "20D";
        city.District = "District 12";
        city.Population = 999;
        city.ID = 1;
        cities.add(city);
        app.printCities(cities);
    }

    /**
     * Testing printCapitalCities passing null as parameter
     */
    @Test
    void printCapitalCitiesNull() {
        app.printCapitalCities(null);
    }

    /**
     * Testing printCapitalCities with an empty ArrayList
     */
    @Test
    void printCapitalCitiesEmpty() {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCities(cities);
    }

    /**
     * Testing printCapitalCities with an ArrayList containing null
     */
    @Test
    void printCapitalCitiesContainsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.printCapitalCities(cities);
    }

    /**
     * Testing printCapitalCities final ver
     */
    @Test
    void printCapitalCities() {
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City();
        city.Name = "Test Capital";
        city.CountryCode = "TES";
        city.Population = 20;
        cities.add(city);
        app.printCapitalCities(cities);
    }

    /**
     * Testing printPopulationReport passing in a null
     */
    @Test
    void printPopulationReportNull() {
        app.printPopulationReport(null);
    }

    /**
     * Testing printPopulationReport if the list is empty
     */
    @Test
    void printPopulationReportEmpty() {
        ArrayList<Population> pop = new ArrayList<Population>();
        app.printPopulationReport(pop);
    }

    /**
     * Testing printPopulationReport if the list contains a null
     */
    @Test
    void printPopulationReportContainsNull() {
        ArrayList<Population> pop = new ArrayList<Population>();
        pop.add(null);
        app.printPopulationReport(pop);
    }

    /**
     * Testing printPopulationReport final version
     */
    @Test
    void printPopulationReport() {
        ArrayList<Population> pop = new ArrayList<Population>();
        Population p = new Population();
        p.Name = "Test Pop";
        p.Population = 10000000000L;
        p.CityPopulation = 50000L;
        p.CityPercentage="50%";
        p.NotCityPopulation=99999L;
        p.NotCityPercentage="50%";
        pop.add(p);
        app.printPopulationReport(pop);
    }

}