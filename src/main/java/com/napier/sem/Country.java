package com.napier.sem;

/**
 * Class representing a country
 *
 * @author Medárd Seff
 * @version 1.0
 * @since 2022-03-01
 * */
public class Country {

    //properties
    /**
     * Country code
     * */
    private String code;
    /**
     * Country name
     * */
    private String name;
    /**
     * Continent of the country;
     */
    private String continent;
    /**
     * Region of the country
     */
    private String region;
    /**
     * Country's population
     */
    private int population;
    /**
     * Capital of the country
     */
    private String capital;
    //constructors
    //Empty constructor
    public Country() {}

    /**
     *Country constructor
     * @param code Country's code
     * @param name  Country's name
     * @param continent Country's continent
     * @param region Country's region
     * @param population Country's population
     * @param capital Country's capital
     */
    public Country(String code, String name, String continent, String region, int population, String capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }
    //getters and setters

    /**
     * gets code value
     * @return code Country's code
     */
    public String getCode() {
        return code;
    }

    /**
     * sets code value
     * @param code Country's code
     */
    public void setCode(String code){
        this.code = code;
    }

    /**
     * gets name value
     * @return Country's name
     */
    public String getName(){
        return name;
    }

    /**
     * sets name value
     * @param name Country's name
     */
    public void  setName(String name){
        this.name = name;

    }
    /**
     * gets continent value
     * @return continent Country's continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * sets continent value
     * @param continent Country's continent
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * gets region value
     * @return region Country's region
     */
    public String getRegion() {
        return region;
    }

    /**
     * sets region value
     * @param region Country's region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * gets population value
     * @return population Country's population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * sets population value
     * @param population Country's population
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * gets capital value
     * @return capital Country's capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * sets capital value
     * @param capital Country's capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * To string method for Country Class
     */
    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", population=" + population +
                ", capital='" + capital + '\'' +
                '}';
    }

}
