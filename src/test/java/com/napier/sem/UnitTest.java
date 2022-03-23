package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void printSalariesTestNull()
    {
        app.printCities(null);
    }

    @Test
    void printCountriesNull()
    {
        app.printCountries(null);
    }

    @Test
    void printCountriesEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountries(countries);
    }

    @Test
    void printCountriesContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.printCountries(countries);
    }

    @Test
    void printCountries()
    {
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

}