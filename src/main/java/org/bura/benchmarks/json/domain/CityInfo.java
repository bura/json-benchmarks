package org.bura.benchmarks.json.domain;

/**
 * Information about city.
 * 
 * @author Andrey Bloschetsov
 */
public class CityInfo {

    private String id;
    private String city;
    private String state;
    private Integer pop;
    private Integer[] loc;

    public CityInfo() {
    }

    public CityInfo(String id, String city, String state, Integer pop, Integer[] loc) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.pop = pop;
        this.loc = loc;
    }

    /**
     * The zip code.
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * The city name.
     */
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * The two letter state abbreviation.
     */
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * The population of city.
     */
    public Integer getPop() {
        return pop;
    }

    public void setPop(Integer pop) {
        this.pop = pop;
    }

    /**
     *  The city location. Specified as latitude and longitude pair.
     */
    public Integer[] getLoc() {
        return loc;
    }

    public void setLoc(Integer[] loc) {
        this.loc = loc;
    }

}
