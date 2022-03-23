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
        app.connect("localhost:33061", 30000);

    }

    @Test
    void testGetCountryByRegion()
    {
        app.getCountryByRegion("Eastern Europe");

      //  assertEquals(emp.emp_no, 255530);
     //   assertEquals(emp.first_name, "Ronghao");
      //  assertEquals(emp.last_name, "Garigliano");
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
}
