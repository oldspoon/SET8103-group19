package com.napier.sem;

/**
 * Represents info about the language a certain country speaks
 */
public class CountryLanguage {
    /**
     * 3 character code, to link to country table
     */
    public String CountryCode;

    /**
     * The language they speak
     */
    public String Language;

    /**
     * T or F is it the official language of the country
     */
    public char IsOfficial;

    /**
     * percentage of the population speak it
     */
    public float Percentage;
}
