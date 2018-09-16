package com.runways.model;



/**
 * QueryTypeDao class for querying by code or CountryName
 * @author oalizada
 */
public class QueryTypeDao {
    private String countryName;
    private String countryCode;
    private String type;
    private String name;
    private String latitude_deg;
    private String longitude_deg;
    private String elevation;
    private String municipality;


    private String surface;
    private String le_ident;
    private String closed;


    public QueryTypeDao(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueryTypeDao that = (QueryTypeDao) o;

        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null) return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (latitude_deg != null ? !latitude_deg.equals(that.latitude_deg) : that.latitude_deg != null) return false;
        if (longitude_deg != null ? !longitude_deg.equals(that.longitude_deg) : that.longitude_deg != null)
            return false;
        if (elevation != null ? !elevation.equals(that.elevation) : that.elevation != null) return false;
        if (municipality != null ? !municipality.equals(that.municipality) : that.municipality != null) return false;
        if (surface != null ? !surface.equals(that.surface) : that.surface != null) return false;
        if (le_ident != null ? !le_ident.equals(that.le_ident) : that.le_ident != null) return false;
        return closed != null ? closed.equals(that.closed) : that.closed == null;
    }

    @Override
    public int hashCode() {
        int result = countryName != null ? countryName.hashCode() : 0;
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (latitude_deg != null ? latitude_deg.hashCode() : 0);
        result = 31 * result + (longitude_deg != null ? longitude_deg.hashCode() : 0);
        result = 31 * result + (elevation != null ? elevation.hashCode() : 0);
        result = 31 * result + (municipality != null ? municipality.hashCode() : 0);
        result = 31 * result + (surface != null ? surface.hashCode() : 0);
        result = 31 * result + (le_ident != null ? le_ident.hashCode() : 0);
        result = 31 * result + (closed != null ? closed.hashCode() : 0);
        return result;
    }

    public QueryTypeDao(String countryName, String countryCode, String type, String name, String latitude_deg, String longitude_deg,
                        String elevation, String municipality, String surface, String le_ident, String closed) {
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.type = type;
        this.name = name;
        this.latitude_deg = latitude_deg;
        this.longitude_deg = longitude_deg;
        this.elevation = elevation;
        this.municipality = municipality;
        this.surface = surface;
        this.le_ident = le_ident;
        this.closed = closed;
    }

    public String getLatitude_deg() {
        return latitude_deg;
    }

    public void setLatitude_deg(String latitude_deg) {
        this.latitude_deg = latitude_deg;
    }

    public String getLongitude_deg() {
        return longitude_deg;
    }

    public void setLongitude_deg(String longitude_deg) {
        this.longitude_deg = longitude_deg;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getLe_ident() {
        return le_ident;
    }

    public void setLe_ident(String le_ident) {
        this.le_ident = le_ident;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }
}
