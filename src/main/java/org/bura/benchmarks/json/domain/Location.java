package org.bura.benchmarks.json.domain;

/**
 * Information about location.
 * 
 * @author Andrey Bloschetsov
 */
public class Location {

    public static final Integer TYPE_HOME = 1;
    public static final Integer TYPE_WORK = 2;
    public static final Integer TYPE_OTHER = 3;

    private Integer type;
    private String country;
    private String state;
    private String city;
    private String place;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
