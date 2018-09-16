package com.runways.model;

/**
 * DAO Report for Countries with the  Highest and  the Lowest Airport
 * @author oalizada
 */
public class ReportTypeHighestAirportDaoAndTheLowest {
    private String countryName;
    private String countryCode;
    private int count;



    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ReportTypeHighestAirportDao{" +
                "countryName='" + countryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", count=" + count +
                '}';
    }
}
