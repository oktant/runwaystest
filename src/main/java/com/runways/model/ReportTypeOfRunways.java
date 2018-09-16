package com.runways.model;

/**
 * DAO Report for Type for Runways
 * @author oalizada
 */
public class ReportTypeOfRunways {
    private String countryCode;
    private String countryName;
    private String surface;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    @Override
    public String toString() {
        return "ReportTypeOfRunways{" +
                "countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", surface='" + surface + '\'' +
                '}';
    }
}
