package com.projectname.e2e.tests.data.enums;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public enum Country {

    SERBIA("Serbia", "RS", "Serbia (Србија)"),
    MALTA("Malta", "MT", "Malta");


    private final String countryName;
    private final String countryAbbreviation;
    private final String countryDialCode;

    private Country(String countryName, String countryAbbreviation, String countryDialCode){
        this.countryName = countryName;
        this.countryAbbreviation = countryAbbreviation;
        this.countryDialCode = countryDialCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public String getCountryDialCode() {
        return countryDialCode;
    }

    public static Country getRandomCountry (){
        List<Country> countries = new ArrayList<>();
        countries.add(Country.SERBIA);
        countries.add(Country.MALTA);

        return countries.get(RandomUtils.nextInt(0, countries.size()-1));
    }
}
