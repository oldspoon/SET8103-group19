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


    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        ArrayList<Country> country = a.getCountryByRegion();
        a.printCountries(country);

        // Disconnect from database
        a.disconnect();


    }

    public ArrayList<Country> getCountryByRegion()
    {
        try{
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital "
                            +"FROM country "
                            +"WHERE country.Region ='Caribbean'"
                            +"ORDER BY country.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> country = new ArrayList<Country>();
            while (rset.next())
            {
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

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }

    }
    public void printCountries (ArrayList<Country> country) {
        // Check countries is not null
        if (country == null)
        {
            System.out.println("No countries found");
            return;
        }

        // Print header
        System.out.printf("%-40s %-40s %-40s %-40s %-40s %-40s%n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country cnt : country)
        {
            if (cnt == null)
                continue;
            String cnt_string =
                    String.format("%-40s %-40s %-40s %-40s %-40s %-40s",
                            cnt.getCode(), cnt.getName(), cnt.getContinent(), cnt.getRegion(), cnt.getPopulation(), cnt.getCapital());
            System.out.println(cnt_string);
        }
    }
}

