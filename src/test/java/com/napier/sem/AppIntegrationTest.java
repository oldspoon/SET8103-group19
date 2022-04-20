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

    @Test // Report 1
    void testGetCountriesInWorldByPopulationDescending(){
        ArrayList<Country> country = app.getCountriesInWorldByPopulationDescending();
        assertTrue(country.get(0).getPopulation()>country.get(1).getPopulation());
    }
    @Test // Report 2
    void testGetCountriesInContinentOrderByPopulationDescending()
    {
        ArrayList<Country> countries = app.getCountriesInContinentOrderByPopulationDescending("Europe");
        assertEquals(countries.size(),46);
        assertEquals(countries.get(1).getName(),"Germany");
        assertTrue(countries.get(0).getPopulation()>countries.get(1).getPopulation());
    }
    @Test // Report 3
    void testGetCountryByRegion()
    {

       ArrayList<Country> countries =  app.getCountryByRegion("Eastern Europe");
        assertEquals(countries.size(),10);
        assertEquals(countries.get(0).getName(),"Russian Federation");
        assertTrue(countries.get(0).getPopulation()>countries.get(1).getPopulation());
    }

    @Test // Report 4
    void testGetCountryTopNPop(){
        ArrayList<Country> country = app.getCountryTopNPop("10");
        assertTrue(country.get(0).getPopulation()>country.get(1).getPopulation());
    }
    @Test // Report 5
    void testTopNCountriesInAContinent(){
        ArrayList<Country> country = app.TopNCountriesInAContinent("5", "Europe");
        assertTrue(country.get(0).getPopulation()>country.get(1).getPopulation());
    }

    // Report 6
    // Here

    @Test // Report 7
    void getCitiesOrderByPopulationDescending(){
        ArrayList<City> city = app.getCitiesOrderByPopulationDescending();
        assertTrue(city.get(0).getPopulation()>city.get(1).getPopulation());
    }

    // Report 8
    // Here

    @Test // Report 9
    void testGetCitiesInRegionDesc(){
        ArrayList<City> city = app.getCitiesInRegionDesc("Eastern Europe");
        assertTrue(city.get(0).getPopulation()>city.get(1).getPopulation());
    }

    @Test // Report 10
    void testGetCitiesInCountryByPopDESC(){
        ArrayList<City> city = app.getCitiesInCountryByPopDESC("Sweden");
        assertTrue(city.get(0).getPopulation()>city.get(1).getPopulation());
    }

    @Test // Report 13
    void testTopNCitiesInContinent(){
        ArrayList<City> city = app.TopNCitiesInContinent("Asia",3);
        assertTrue(city.get(0).getPopulation()>city.get(1).getPopulation());
    }

    @Test // Report 14
    void testTopNCitiesInRegion(){
        ArrayList<City> city = app.TopNCitiesInRegion("Caribbean",15);
        assertTrue(city.get(0).getPopulation()>city.get(1).getPopulation());
    }

    @Test // Report 17
    void testallCapitalCitiesByPopDESC(){
        ArrayList<City> city = app.allCapitalCitiesByPopDESC();
        assertTrue(city.get(0).getPopulation()>city.get(1).getPopulation());
    }

    @Test // Report 18
    void testallCapitalCitiesInContinentByPopDESC(){
        ArrayList<City> city = app.allCapitalCitiesInContinentByPopDESC("Europe");
        assertTrue(city.get(0).getPopulation()>city.get(1).getPopulation());
    }

    @Test // Report 23
    void testgetTotalContinentData(){
        ArrayList<Population> pop = app.getTotalContinentData();
        assertEquals(pop.get(0).getCityPopulation() + pop.get(0).getNotCityPopulation(), pop.get(0).getPopulation());
    }
    @Test // Report 24
    void testgetTotalRegionData(){
        ArrayList<Population> pop = app.getTotalRegionData();
        assertEquals(pop.get(0).getCityPopulation() + pop.get(0).getNotCityPopulation(), pop.get(0).getPopulation());
    }
    @Test // Report 25
    void testgetTotalCountryData(){
        ArrayList<Population> pop = app.getTotalCountryData();
        assertEquals(pop.get(0).getCityPopulation() + pop.get(0).getNotCityPopulation(), pop.get(0).getPopulation());
    }
    @Test // Report 26
    void testgetWorldPopulation(){
        Population pop = app.getWorldPopulation();
        assertEquals(6078749450L,pop.getPopulation());
    }
    @Test // Report 27
    void testgetContinentPopulation(){
        Population pop = app.getContinentPopulation("Oceania");
        assertEquals(30401150L,pop.getPopulation());
    }
    @Test // Report 28
    void testgetRegionPopulation(){
        Population pop = app.getRegionPopulation("Polynesia");
        assertEquals(633050L,pop.getPopulation());
    }
    @Test // Report 29
    void testgetCountryPopulation(){
        Population pop = app.getCountryPopulation("Denmark");
        assertEquals(5330000L,pop.getPopulation());
    }
    @Test // Report 30
    void testgetDistrictPopulation(){
        Population pop = app.getDistrictPopulation("Gelderland");
        assertEquals(545548L,pop.getPopulation());
    }
    @Test // Report 31
    void testgetCityPopulation(){
        Population pop = app.getCityPopulation("Glasgow");
        assertEquals(619680L,pop.getPopulation());
    }

}
