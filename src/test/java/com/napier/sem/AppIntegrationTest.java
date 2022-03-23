package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void testGetCountryByRegion()
    {

       ArrayList<Country> countries =  app.getCountryByRegion("Eastern Europe");
        assertEquals(countries.size(),10);
        assertEquals(countries.get(0).getName(),"Russian Federation");
        app.printCountries(countries);
    }

    @Test
    void testGetCountriesInContinentOrderByPopulationDescending()
    {
        ArrayList<Country> countries = app.getCountriesInContinentOrderByPopulationDescending();
        assertEquals(countries.size(),46);
        assertEquals(countries.get(1).getName(),"Germany");
        app.printCountries(countries);
    }

    @Test
    void testGetCitiesInRegionDesc(){
        ArrayList<City> city = app.getCitiesInRegionDesc();
        for(City c : city){
        c.toString();
        }
    }
    @Test
    void testGetCountriesInWorldByPopulationDescending(){
        ArrayList<Country> country = app.getCountriesInWorldByPopulationDescending();
        for (Country m:country) {
            m.toString();
        }
        country.toString();
    }
    @Test
    void testTop5CountriesInAContinent(){
        ArrayList<Country> country = app.Top5CountriesInAContinent("5", "Europe");
        app.printCountries(country);
    }
    @Test
    void testTopNPop(){
        ArrayList<Country> country = app.getCountryTopNPop("10");
        app.printCountries(country);
    }
}
