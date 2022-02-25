package com.napier.sem;

/**
 * Represents info about the language a certain country speaks
 */
public class CountryLanguage {
    /**
     * 3 character code, to link to country table
     */
    public String country_code;

    /**
     * The language they speak
     */
    public String language;

    /**
     * T or F is it the official language of the country
     */
    public char is_official;

    /**
     * percentage of the poopulation speak it
     */
    public float percentage;
}
