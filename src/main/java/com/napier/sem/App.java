package com.napier.sem;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;

public class App {
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Main function that creates an app, connects to the db and calls various functions
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database

        if (args.length < 1) {
            a.connect("localhost:33060", 30000);
        } else {
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        // Report #1, All the countries in the world organised by largest population to smallest.
        System.out.println("Report 1:");
        ArrayList<Country> report1 = a.getCountriesInWorldByPopulationDescending();
        a.printCountries(report1);
        System.out.println();

        // Report #2, All the countries in a continent organised by largest population to smallest.
        // Using Europe as example continent
        System.out.println("Report 2:");
        ArrayList<Country> report2 = a.getCountriesInContinentOrderByPopulationDescending("Europe");
        a.printCountries(report2);
        System.out.println();

        // Report #3, All the countries in a region organised by largest population to smallest.
        // Using X as example region
        System.out.println("Report 3:");
        ArrayList<Country> report3 = a.getCountryByRegion("Middle East");
        a.printCountries(report3);
        System.out.println();

        // Report #4, The top N populated countries in the world where N is provided by the user.
        // Using 5 as example N
        System.out.println("Report 4:");
        ArrayList<Country> report4 = a.getCountryTopNPop("5");
        a.printCountries(report4);
        System.out.println();

        // Report #5, The top N populated countries in a continent where N is provided by the user.
        // Using 7 as example N
        System.out.println("Report 5:");
        ArrayList<Country> report5 = a.TopNCountriesInAContinent("7", "Europe");
        a.printCountries(report5);
        System.out.println();

        // Report #6, The top N populated countries in a region where N is provided by the user.
        // Using 4 as example N
        System.out.println("Report 6:");
        ArrayList<Country> report6; // Needs implemented
        //a.printCountries(report6);
        System.out.println();

        // Report #7, All the cities in the world organised by largest population to smallest.
        System.out.println("Report 7:");
        ArrayList<City> report7 = a.getCitiesOrderByPopulationDescending();
        a.printCities(report7);
        System.out.println();

        // Report #8, All the cities in a continent organised by largest population to smallest.
        // Using Oceania as example continent
        System.out.println("Report 8:");
        ArrayList<City> report8; // Needs implemented
        //a.printCities(report8);
        System.out.println();

        // Report #9, All the cities in a region organised by largest population to smallest.
        // Using X as example region
        System.out.println("Report 9:");
        ArrayList<City> report9 = a.getCitiesInRegionDesc("Caribbean");
        a.printCities(report9);
        System.out.println();

        // Report #10, All the cities in a country organised by largest population to smallest.
        // Using China as example country
        System.out.println("Report 10:");
        ArrayList<City> report10 = a.getCitiesInCountryByPopDESC("China");
        a.printCities(report10);
        System.out.println();

        // Report #11, All the cities in a district organised by largest population to smallest.
        // Using X as example district
        System.out.println("Report 11:");
        ArrayList<City> report11; //Needs implemented
        //a.printCities(report11);
        System.out.println();

        // Report #12, The top N populated cities in the world where N is provided by the user.
        // Using 15 as example N
        System.out.println("Report 12:");
        ArrayList<City> report12 = a.TopNCitiesByPop(15);
        a.printCities(report12);
        System.out.println();

        // Report #13, The top N populated cities in a continent where N is provided by the user.
        //
        System.out.println("Report 13:");
        ArrayList<City> report13 = a.TopNCitiesInContinent("Europe", 7);
        a.printCities(report13);
        System.out.println();

        // Report #14, The top N populated cities in a region where N is provided by the user.
        //
        System.out.println("Report 14:");
        ArrayList<City> report14 = a.TopNCitiesInRegion("Caribbean", 3);
        a.printCities(report14);
        System.out.println();

        // Report #15, The top N populated cities in a country where N is provided by the user.
        //
        System.out.println("Report 15:");
        ArrayList<City> report15; //Needs implemented
        //a.printCities(report15);
        System.out.println();

        // Report #16, The top N populated cities in a district where N is provided by the user.
        //
        System.out.println("Report 16:");
        ArrayList<City> report16; //Needs implemented
        //a.printCities(report16);
        System.out.println();

        // Report #17, All the capital cities in the world organised by largest population to smallest.
        //
        System.out.println("Report 17:");
        ArrayList<City> report17 = a.allCapitalCitiesByPopDESC();
        a.printCapitalCities(report17);
        System.out.println();

        // Report #18, All the capital cities in a continent organised by largest population to smallest.
        // Using Asia as example continent
        System.out.println("Report 18:");
        ArrayList<City> report18 = a.allCapitalCitiesInContinentByPopDESC("Asia");
        a.printCapitalCities(report18);
        System.out.println();

        // Report #19, All the capital cities in a region organised by largest to smallest.
        //
        System.out.println("Report 19:");
        ArrayList<City> report19; // Needs implemented
        //a.printCapitalCities(report19);
        System.out.println();

        // Report #20, The top N populated capital cities in the world where N is provided by the user.
        System.out.println("Report 20:");
        ArrayList<City> report20;
        //a.printCapitalCities(report20);
        System.out.println();

        // Report #21, The top N populated capital cities in a continent where N is provided by the user.
        System.out.println("Report 21:");
        ArrayList<City> report21;
        //a.printCapitalCities(report21);
        System.out.println();

        // Report #22, The top N populated capital cities in a region where N is provided by the user.
        System.out.println("Report 22:");
        ArrayList<City> report22;
        //a.printCapitalCities(report22);
        System.out.println();

        // Report #23, The population of people, people living in cities, and people not living in cities in each continent
        System.out.println("Report 23:");
        ArrayList<Population> report23 = a.getTotalContinentData();
        a.printPopulationReport(report23);
        System.out.println();

        // Report #24, The population of people, people living in cities, and people not living in cities in each region.
        System.out.println("Report 24:");
        ArrayList<Population> report24 = a.getTotalRegionData();
        a.printPopulationReport(report24);
        System.out.println();
        // Disconnect from database

        // Report #25, The population of people, people living in cities, and people not living in cities in each country.
        System.out.println("Report 25:");
        ArrayList<Population> report25 = a.getTotalCountryData();
        a.printPopulationReport(report25);
        System.out.println();

        // Report #26, The population of the world.
        System.out.println("Report 26:");
        Population report26 = a.getWorldPopulation();
        a.printSinglePopulationReport(report26);
        System.out.println();

        // Report #27, The population of a continent.
        System.out.println("Report 27:");
        Population report27 = a.getContinentPopulation("Asia");
        a.printSinglePopulationReport(report27);
        System.out.println();

        // Report #28, The population of a region.
        System.out.println("Report 28:");
        Population report28 = a.getRegionPopulation("Polynesia");
        a.printSinglePopulationReport(report28);
        System.out.println();

        // Report #29, The population of a country.
        System.out.println("Report 29:");
        Population report29 = a.getCountryPopulation("Sweden");
        a.printSinglePopulationReport(report29);
        System.out.println();

        // Report #30, The population of a district.
        System.out.println("Report 30:");
        Population report30 = a.getDistrictPopulation("Gelderland");
        a.printSinglePopulationReport(report30);
        System.out.println();

        // Report #31, The population of a city.
        System.out.println("Report 31:");
        Population report31 = a.getCityPopulation("Edinburgh");
        a.printSinglePopulationReport(report31);
        System.out.println();

        //Report #32, The number of people who speak the following the following languages from greatest number to smallest, including the percentage of the world population:
        //Chinese.
        //English.
        //Hindi.
        //Spanish.
        //Arabic.
        System.out.println("Report 32:");
        //
        //
        System.out.println();

        a.disconnect();


    }

    /**
     * This function returns a list of cities in a certain region
     * Ordered by city population descending
     *
     * @return arraylist of cities
     */
    public ArrayList<City> getCitiesInRegionDesc(String region) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Region, city.Name,city.CountryCode, city.District,city.Population  "
                            + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                            + "WHERE region = '" + region + "' "
                            + "ORDER BY city.Population desc ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cityList = new ArrayList<City>();
            while (rset.next()) {
                City c = new City();
                c.setName(rset.getString("city.Name"));
                c.setCountryCode(rset.getString("city.CountryCode"));
                c.setDistrict(rset.getString("city.District"));
                c.setPopulation(rset.getInt("city.Population"));
                cityList.add(c);
            }
            return cityList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public ArrayList<City> TopNCitiesInRegion(String region, int limit) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Region, city.Name,city.CountryCode, city.District,city.Population  "
                            + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                            + "WHERE region = '" + region + "' "
                            + "ORDER BY city.Population desc "
                            + "LIMIT " + limit;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cityList = new ArrayList<City>();
            while (rset.next()) {
                City c = new City();
                c.setName(rset.getString("city.Name"));
                c.setCountryCode(rset.getString("city.CountryCode"));
                c.setDistrict(rset.getString("city.District"));
                c.setPopulation(rset.getInt("city.Population"));
                cityList.add(c);
            }
            return cityList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public ArrayList<City> TopNCitiesInContinent(String continent, int limit) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Region, city.Name,city.CountryCode, city.District,city.Population  "
                            + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                            + "WHERE country.continent = '" + continent + "' "
                            + "ORDER BY city.Population desc "
                            + "LIMIT " + limit;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cityList = new ArrayList<City>();
            while (rset.next()) {
                City c = new City();
                c.setName(rset.getString("city.Name"));
                c.setCountryCode(rset.getString("city.CountryCode"));
                c.setDistrict(rset.getString("city.District"));
                c.setPopulation(rset.getInt("city.Population"));
                cityList.add(c);
            }
            return cityList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * This function returns all countries in the world sorted by population descending
     *
     * @return arrayList of countries
     * @author Matthew
     */
    public ArrayList<Country> getCountriesInWorldByPopulationDescending() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                            + "FROM country "
                            + "ORDER BY country.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countryList = new ArrayList<Country>();
            while (rset.next()) {
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

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Function that returns an arraylist of country in a specific continent ordered by population descending
     *
     * @return ArrayList of country
     * @author Matthew
     */
    public ArrayList<Country> getCountriesInContinentOrderByPopulationDescending(String continent) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                            + "FROM country "
                            + "WHERE country.Continent ='" + continent + "'"
                            + "ORDER BY country.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countryList = new ArrayList<Country>();
            while (rset.next()) {
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

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * This function returns an arraylist of all cities in the world, ordered by population descending
     *
     * @return An ArrayList of cities
     */
    public ArrayList<City> getCitiesOrderByPopulationDescending() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cityList = new ArrayList<City>();
            while (rset.next()) {
                City c = new City();
                c.setName(rset.getString("city.Name"));
                c.setCountryCode(rset.getString("city.CountryCode"));
                c.setDistrict(rset.getString("city.District"));
                c.setPopulation(rset.getInt("city.Population"));
                cityList.add(c);
            }
            return cityList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * This function returns an arraylist of all cities in the world, ordered by population descending
     *
     * @return An ArrayList of cities
     */
    public ArrayList<City> TopNCitiesByPop(int n) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + n;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cityList = new ArrayList<City>();
            while (rset.next()) {
                City c = new City();
                c.setName(rset.getString("city.Name"));
                c.setCountryCode(rset.getString("city.CountryCode"));
                c.setDistrict(rset.getString("city.District"));
                c.setPopulation(rset.getInt("city.Population"));
                cityList.add(c);
            }
            return cityList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * This function returns an arraylist of all cities in a country, ordered by population descending
     *
     * @param country
     * @return ArrayList<City>
     */
    public ArrayList<City> getCitiesInCountryByPopDESC(String country) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population "
                            + "FROM city JOIN country ON (city.CountryCode = country.Code) "
                            + "WHERE country.Name='" + country + "'"
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cityList = new ArrayList<City>();
            while (rset.next()) {
                City c = new City();
                c.setName(rset.getString("city.Name"));
                c.setCountryCode(rset.getString("city.CountryCode"));
                c.setDistrict(rset.getString("city.District"));
                c.setPopulation(rset.getInt("city.Population"));
                cityList.add(c);
            }
            return cityList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * This function returns an arraylist of city that are all the capital cities in a particular continent
     *
     * @param continent
     * @return ArrayList<City>
     */
    public ArrayList<City> allCapitalCitiesInContinentByPopDESC(String continent) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.Population FROM city JOIN country ON city.CountryCode=country.Code "
                            + "WHERE country.Capital=city.ID AND country.Continent = 'Europe' "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cityList = new ArrayList<City>();
            while (rset.next()) {
                City c = new City();
                c.setName(rset.getString("city.Name"));
                c.setCountryCode(rset.getString("city.CountryCode"));
                c.setPopulation(rset.getInt("city.Population"));
                cityList.add(c);
            }
            return cityList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public ArrayList<City> allCapitalCitiesByPopDESC() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.Population "
                            + "FROM city, country "
                            + "WHERE country.Capital=city.ID "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cityList = new ArrayList<City>();
            while (rset.next()) {
                City c = new City();
                c.setName(rset.getString("city.Name"));
                c.setCountryCode(rset.getString("city.CountryCode"));
                c.setPopulation(rset.getInt("city.Population"));
                cityList.add(c);
            }
            return cityList;

        } catch (Exception e) {
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
    public ArrayList<Country> getCountryByRegion(String n) {
        if (n == null) {
            return null;
        } else {
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
     * This is the method used to return an array list of top N Countries order by highest to lowest population.
     * Dependant on the SQL used in the method.
     *
     * @return ArrayList<Country> List of Countries
     */
    public ArrayList<Country> getCountryTopNPop(String n) {
        try {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                                + "FROM country "
                                + "ORDER BY country.population DESC "
                                + "LIMIT " + n;

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

    /**
     * This function takes in a number N and a string C to list the top N countries in continent N
     *
     * @param n
     * @param c
     * @return arraylist of countries
     */
    public ArrayList<Country> TopNCountriesInAContinent(String n, String c) {
        try {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                                + "FROM country "
                                + "WHERE country.Continent ='" + c + "'"
                                + "ORDER BY country.population DESC "
                                + "LIMIT " + n;

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

    public Population getWorldPopulation() {
        try {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "Select  SUM(country.Population) as Population FROM country";
                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract employee information
                Population pop = new Population();
                while (rset.next()) {
                    pop.setName("World");
                    pop.setPopulation(rset.getLong("Population"));
                }
                return pop;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public Population getContinentPopulation(String continent){
        try {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "Select  SUM(country.Population) as Population FROM country " +
                                "WHERE country.Continent = '"+continent+"'";
                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract employee information
                Population pop = new Population();
                while (rset.next()) {
                    pop.setName(continent);
                    pop.setPopulation(rset.getLong("Population"));
                }
                return pop;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public Population getRegionPopulation(String region)
    {
        try {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "Select  SUM(country.Population) as Population FROM country " +
                                "WHERE country.Region = '"+region+"'";
                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract employee information
                Population pop = new Population();
                while (rset.next()) {
                    pop.setName(region);
                    pop.setPopulation(rset.getLong("Population"));
                }
                return pop;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public Population getCountryPopulation(String country)
    {
        try {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "Select  SUM(country.Population) as Population FROM country " +
                                "WHERE country.Name = '"+country+"'";
                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract employee information
                Population pop = new Population();
                while (rset.next()) {
                    pop.setName(country);
                    pop.setPopulation(rset.getLong("Population"));
                }
                return pop;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public Population getDistrictPopulation(String district)
    {
        try {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "Select  SUM(city.Population) as Population FROM city " +
                                "WHERE city.District = '"+district+"'";
                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract employee information
                Population pop = new Population();
                while (rset.next()) {
                    pop.setName(district);
                    pop.setPopulation(rset.getLong("Population"));
                }
                return pop;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public Population getCityPopulation(String city)
    {
        try {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "Select  SUM(city.Population) as Population FROM city " +
                                "WHERE city.Name = '"+city+"'";
                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract employee information
                Population pop = new Population();
                while (rset.next()) {
                    pop.setName(city);
                    pop.setPopulation(rset.getLong("Population"));
                }
                return pop;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }


    /**
     * This is a method used to print out the List of Countries
     */
    public void printCountries(ArrayList<Country> country) {
        // Check countries is not null
        if (country == null) {
            System.out.println("No countries found");
            return;
        }

        // Print first row
        System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s%n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country cnt : country) {
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
     */
    public void printCities(ArrayList<City> city) {
        // Check countries is not null
        if (city == null) {
            System.out.println("No cities found");
            return;
        }

        // Print first row
        System.out.printf("%-30s %-30s %-30s %-30s%n", "Name", "CountryCode", "District", "Population");
        // Loop over all countries in the list
        for (City c : city) {
            if (c == null)
                continue;
            String c_string =
                    String.format("%-30s %-30s %-30s %-30s",
                            c.getName(), c.getCountryCode(), c.getDistrict(), c.getPopulation());
            System.out.println(c_string);
        }
    }

    /**
     * This function takes in an arrayList of city then prints out in a format suitable for a capital city report
     *
     * @param city
     */
    public void printCapitalCities(ArrayList<City> city) {
        // Check countries is not null
        if (city == null) {
            System.out.println("No cities found");
            return;
        }

        // Print first row
        System.out.printf("%-30s %-30s %-30s%n", "Name", "Country", "Population");
        // Loop over all countries in the list
        for (City c : city) {
            if (c == null)
                continue;
            String c_string =
                    String.format("%-30s %-30s %-30s",
                            c.getName(), c.getCountryCode(), c.getPopulation());
            System.out.println(c_string);
        }
    }

    /**
     * This function takes in a population list and prints all the data in the list to the console in a nice format
     *
     * @param popList The list of population data generated from getTotalXData functions
     */
    public void printPopulationReport(ArrayList<Population> popList) {
        if (popList == null) {
            System.out.println("List is empty");
            return;
        }
        // Print first row
        System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s%n", "Name", "Total Population", "Population living in cities", "City Percentage", "Population not living in cities", "Not City Percentage");
        for (Population pop : popList) {
            if (pop == null) {
                continue;
            }
            String cnt_string =
                    String.format("%-30s %-30s %-30s %-30s %-30s %-30s",
                            pop.getName(), pop.getPopulation(), pop.getCityPopulation(), pop.getCityPercentage(), pop.getNotCityPopulation(), pop.getNotCityPercentage());
            System.out.println(cnt_string);
        }
    }

    public void printSinglePopulationReport(Population pop) {
        if (pop == null) {
            System.out.println("Input is null");
            return;
        }
        //Print first row
        System.out.printf("%-30s %-30s%n", "Name", "Total Population");
        String pop_string =
                String.format("%-30s %-30s",
                        pop.getName(), pop.getPopulation());
        System.out.println(pop_string);
    }

    public ArrayList<Population> getTotalContinentData() {
        try {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "Select country.Continent, SUM(distinct country.Population) as `Total Population`,"
                                + "SUM( city.Population) as `Total Population in Cities`, "
                                + "CONCAT(ROUND(((SUM(city.Population)) / (SUM(distinct country.Population)) * 100),2),'%') as `City Percentage`,"
                                + "((SUM(distinct country.Population))-(SUM( city.Population))) as `Total Population Not in Cities`,"
                                + "CONCAT(ROUND(((((SUM(distinct country.Population))-(SUM( city.Population)))) / (SUM(distinct country.Population)) * 100),2),'%') as `Not City Percentage`"
                                + "FROM city JOIN country ON(city.CountryCode=country.Code) "
                                + "GROUP BY country.Continent";

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                ArrayList<Population> popList = new ArrayList<Population>();
                while (rset.next()) {
                    Population p = new Population();
                    p.setName(rset.getString("Continent"));
                    p.setPopulation(rset.getLong("Total Population"));
                    p.setCityPopulation(rset.getLong("Total Population in Cities"));
                    p.setCityPercentage(rset.getString("City Percentage"));
                    p.setNotCityPopulation(rset.getLong("Total Population Not in Cities"));
                    p.setNotCityPercentage(rset.getString("Not City Percentage"));
                    popList.add(p);
                }
                return popList;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public ArrayList<Population> getTotalRegionData() {
        try {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "Select country.Region, SUM(distinct country.Population) as `Total Population`,"
                                + "SUM( city.Population) as `Total Population in Cities`, "
                                + "CONCAT(ROUND(((SUM(city.Population)) / (SUM(distinct country.Population)) * 100),2),'%') as `City Percentage`,"
                                + "((SUM(distinct country.Population))-(SUM( city.Population))) as `Total Population Not in Cities`,"
                                + "CONCAT(ROUND(((((SUM(distinct country.Population))-(SUM( city.Population)))) / (SUM(distinct country.Population)) * 100),2),'%') as `Not City Percentage`"
                                + "FROM city JOIN country ON(city.CountryCode=country.Code) "
                                + "GROUP BY country.Region";

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                ArrayList<Population> popList = new ArrayList<Population>();
                while (rset.next()) {
                    Population p = new Population();
                    p.setName(rset.getString("Region"));
                    p.setPopulation(rset.getLong("Total Population"));
                    p.setCityPopulation(rset.getLong("Total Population in Cities"));
                    p.setCityPercentage(rset.getString("City Percentage"));
                    p.setNotCityPopulation(rset.getLong("Total Population Not in Cities"));
                    p.setNotCityPercentage(rset.getString("Not City Percentage"));
                    popList.add(p);
                }
                return popList;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public ArrayList<Population> getTotalCountryData() {
        try {
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "Select country.Name, SUM(distinct country.Population) as `Total Population`,"
                                + "SUM( city.Population) as `Total Population in Cities`, "
                                + "CONCAT(ROUND(((SUM(city.Population)) / (SUM(distinct country.Population)) * 100),2),'%') as `City Percentage`,"
                                + "((SUM(distinct country.Population))-(SUM( city.Population))) as `Total Population Not in Cities`,"
                                + "CONCAT(ROUND(((((SUM(distinct country.Population))-(SUM( city.Population)))) / (SUM(distinct country.Population)) * 100),2),'%') as `Not City Percentage`"
                                + "FROM city JOIN country ON(city.CountryCode=country.Code) "
                                + "GROUP BY country.Name";

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                ArrayList<Population> popList = new ArrayList<Population>();
                while (rset.next()) {
                    Population p = new Population();
                    p.setName(rset.getString("Name"));
                    p.setPopulation(rset.getLong("Total Population"));
                    p.setCityPopulation(rset.getLong("Total Population in Cities"));
                    p.setCityPercentage(rset.getString("City Percentage"));
                    p.setNotCityPopulation(rset.getLong("Total Population Not in Cities"));
                    p.setNotCityPercentage(rset.getString("Not City Percentage"));
                    popList.add(p);
                }
                return popList;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }


}

