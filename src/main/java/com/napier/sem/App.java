package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Main function that creates an app, connects to the db and calls various functions
     * @param args
     */
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

       // ArrayList<Country> country = a.getCountryByRegion();
      //  ArrayList<Country> countryByContinent = a.Top5CountriesInAContinent("5", "Europe");
      //  ArrayList<City> CitiesByPopulation = a.getCitiesOrderByPopulationDescending();
        //String N;
        //System.out.println("How many countries: ");
        //N = System.in.toString();
        //ArrayList<Country> country = a.getCountryTopNPop(N);
      //  System.out.println("Full list of countries (by population Largest to smallest):");
      //  a.printCountries(country);
      //  System.out.println("\n top 5 populated European Countries");
       // a.printCountries(countryByContinent);
      //  System.out.println("\n Full list of Cities (by population Largest to smallest):");
        // a.printCities(CitiesByPopulation);
        ArrayList<City> cities = a.getCitiesInRegionDesc();
        a.printCities(cities);

        // Disconnect from database
        a.disconnect();


    }

    /**
     * This function returns a list of cities in a certain region (example hardcoded is eastern europe)
     * Ordered by city population descending
     * @return arraylist of cities
     */
    public ArrayList<City> getCitiesInRegionDesc()
    {
        try{
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID,country.Region, city.Name,city.CountryCode, city.District,city.Population  "
                            +"FROM city JOIN country ON (city.CountryCode=country.Code) "
                            +"WHERE region = 'Eastern Europe' "
                            +"ORDER BY city.Population desc ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cityList = new ArrayList<City>();
            while (rset.next())
            {
                City c = new City();
                c.setId(rset.getInt("city.ID"));
                c.setName(rset.getString("city.Name"));
                c.setCountryCode(rset.getString("city.CountryCode"));
                c.setDistrict(rset.getString("city.District"));
                c.setPopulation(rset.getInt("city.Population"));
                cityList.add(c);
            }
            return cityList;

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    /**
     * This function returns all countries in the world sorted by population descending
     * @return arrayList of countries
     * @author Matthew
     */
    public ArrayList<Country> getCountriesInWorldByPopulationDescending()
    {
        try{
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                            +"FROM country "
                            +"ORDER BY country.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countryList = new ArrayList<Country>();
            while (rset.next())
            {
                Country c = new Country();
                c.setCode(rset.getString("country.code"));
                c.setName(rset.getString("country.name"));
                c.setContinent(rset.getString("country.continent"));
                c.setRegion(rset.getString("country.region"));
                c.setPopulation(rset.getInt("country.population"));
                c.setCapital(rset.getString("country.capital"));
                countryList.add(c);
            }
            return countryList;

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Function that returns an arraylist of country in a specific continent ordered by population descending
     * @return ArrayList of country
     * @author Matthew
     */
    public ArrayList<Country> getCountriesInContinentOrderByPopulationDescending()
    {
        try{
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                            +"FROM country "
                            +"WHERE country.Continent ='Europe'"
                            +"ORDER BY country.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countryList = new ArrayList<Country>();
            while (rset.next())
            {
                Country c = new Country();
                c.setCode(rset.getString("country.code"));
                c.setName(rset.getString("country.name"));
                c.setContinent(rset.getString("country.continent"));
                c.setRegion(rset.getString("country.region"));
                c.setPopulation(rset.getInt("country.population"));
                c.setCapital(rset.getString("country.capital"));
                countryList.add(c);
            }
            return countryList;

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * This function returns an arraylist of all cities in the world, ordered by population descending
     * @return An ArrayList of cities
     */
    public ArrayList<City> getCitiesOrderByPopulationDescending()
    {
        try{
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population "
                            +"FROM city "
                            +"ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cityList = new ArrayList<City>();
            while (rset.next())
            {
                City c = new City();
                c.setId(rset.getInt("city.ID"));
                c.setName(rset.getString("city.Name"));
                c.setCountryCode(rset.getString("city.CountryCode"));
                c.setDistrict(rset.getString("city.District"));
                c.setPopulation(rset.getInt("city.Population"));
                cityList.add(c);
            }
            return cityList;

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    /**
     * This is the method used to return an array list of Countries by specified region.
     * Dependant on the SQL used in the method.
     *
     * @return ArrayList<Country> List of Countries
     */
    public ArrayList<Country> getCountryByRegion(String n)
    {
        if (n == null){
            return null;
        }
        else {
            try {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                                + "FROM country "
                                + "WHERE country.Region ='" + n + "'"
                                + "ORDER BY country.population DESC";
                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                ArrayList<Country> country = new ArrayList<Country>();
                while (rset.next()) {
                    Country cntry = new Country();
                    cntry.setCode(rset.getString("country.code"));
                    cntry.setName(rset.getString("country.name"));
                    cntry.setContinent(rset.getString("country.continent"));
                    cntry.setRegion(rset.getString("country.region"));
                    cntry.setPopulation(rset.getInt("country.population"));
                    cntry.setCapital(rset.getString("country.capital"));
                    country.add(cntry);
                }
                return country;

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to get country details");
                return null;
            }
        }
    }

    /**
     * This is a method used to print out the List of Countries
     *
     */
    public void printCountries (ArrayList<Country> country) {
        // Check countries is not null
        if (country == null)
        {
            System.out.println("No countries found");
            return;
        }

        // Print first row
        System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s%n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country cnt : country)
        {
            if (cnt == null)
                continue;
            String cnt_string =
                    String.format("%-30s %-30s %-30s %-30s %-30s %-30s",
                            cnt.getCode(), cnt.getName(), cnt.getContinent(), cnt.getRegion(), cnt.getPopulation(), cnt.getCapital());
            System.out.println(cnt_string);
        }
    }

    /**
     * This is a method used to print out the List of Cities
     *
     */
    public void printCities (ArrayList<City> city) {
        // Check countries is not null
        if (city == null)
        {
            System.out.println("No cities found");
            return;
        }

        // Print first row
        System.out.printf("%-30s %-30s %-30s %-30s %-30s%n", "ID", "Name", "CountryCode", "District", "Population");
        // Loop over all countries in the list
        for (City c : city)
        {
            if (c == null)
                continue;
            String c_string =
                    String.format("%-30s %-30s %-30s %-30s %-30s",
                            c.getId(), c.getName(), c.getCountryCode(), c.getDistrict(), c.getPopulation());
            System.out.println(c_string);
        }
    }

    /**
     * This is the method used to return an array list of top N Countries order by highest to lowest population.
     * Dependant on the SQL used in the method.
     *
     * @return ArrayList<Country> List of Countries
     */
    public ArrayList<Country> getCountryTopNPop(String n)
    {
        try
        {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                                + "FROM country "
                                + "ORDER BY country.population DESC "
                                + "LIMIT " + n ;

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract employee information
                ArrayList<Country> country = new ArrayList<Country>();
                while (rset.next())
                {
                    Country cnt = new Country();
                    cnt.setCode(rset.getString("country.code"));
                    cnt.setName(rset.getString("country.name"));
                    cnt.setContinent(rset.getString("country.continent"));
                    cnt.setRegion(rset.getString("country.region"));
                    cnt.setPopulation(rset.getInt("country.population"));
                    cnt.setCapital(rset.getString("country.capital"));
                    country.add(cnt);
                }
                return country;

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * This function takes in a number N and a string C to list the top N countries in continent N
     * @param n
     * @param c
     * @return arraylist of countries
     */
    public ArrayList<Country> Top5CountriesInAContinent(String n, String c) {
        try {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                                +"FROM country "
                                +"WHERE country.Continent ='" + c + "'"
                                +"ORDER BY country.population DESC "
                                +"LIMIT " + n;

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract employee information
                ArrayList<Country> country = new ArrayList<Country>();
                while (rset.next()) {
                    Country cnt = new Country();
                    cnt.setCode(rset.getString("country.code"));
                    cnt.setName(rset.getString("country.name"));
                    cnt.setContinent(rset.getString("country.continent"));
                    cnt.setRegion(rset.getString("country.region"));
                    cnt.setPopulation(rset.getInt("country.population"));
                    cnt.setCapital(rset.getString("country.capital"));
                    country.add(cnt);
                }
                return country;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }
}

