package com.napier.sem;

/**
 * Represents a city
 */
public class City {

    /**
     * Represents the city id
     */
    public int ID;

    /**
     * City's name
     */
    public String Name;

    /**
     * City's Country Code
     */
    public String CountryCode;

    /**
     * City's District
     */
    public String District;

    /**
     * the population of the city
     */
    public int Population;

    /**constructors
     * Empty constructor
     **/
    public City() {}
    /**
     *City constructor
     * @param ID City's ID
     * @param Name  City's name
     * @param District City's District
     * @param Population City's population
     */
    public City(int ID, String Name, String District, int Population) {
        this.ID = ID;
        this.Name = Name;
        this.District = District;
        this.Population = Population;
    }    //getters and setters

    /**
     * gets ID value
     * @return ID City's ID
     */
    public int getId() {
        return ID;
    }

    /**
     * sets ID value
     * @param ID city's ID
     */
    public void setId(int ID){
        this.ID = ID;
    }

    /**
     * gets name value
     * @return Name City's name
     */
    public String getName(){
        return Name;
    }

    /**
     * sets name value
     * @param Name City's name
     */

    public void  setName(String Name){
        this.Name = Name;
    }
    /**
     * gets Country Code value
     * @return CountryCode City's Country Code
     */

    public String getCountryCode(){
        return CountryCode;
    }

    /**
     * sets Country Code value
     * @param CountryCode City's Country Code
     */

    public void  setCountryCode(String CountryCode){
        this.CountryCode = CountryCode;
    }

    /**
     * gets District value
     * @return District City's District
     */

    public String getDistrict() {
        return District;
    }

    /**
     * sets District value
     * @param District City's District
     */

    public void setDistrict(String District) {
        this.District = District;
    }

    /**
     * gets Population value
     * @return Population City's population
     */

    public int getPopulation() {
        return Population;
    }

    /**
     * sets Population value
     * @param Population City's population
     */

    public void setPopulation(int Population) {
        this.Population = Population;
    }

    /**
     * To string method for City Class
     */
    @Override
    public String toString() {
        return "City{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                ", District='" + District + '\'' +
                ", Population='" + Population + '\'' +
                '}';
    }

}
