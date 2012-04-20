package com.etapix.beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Armel
 */
@ManagedBean
@ViewScoped
public class WeatherController implements Serializable{

    /**
     * Creates a new instance of WeatherController
     */
    private String conditions;
    private String city;
    private String unit = "c";		//default
    private Map<String, String> cities;
    private WeatherService weatherService = new YAHOOWeatherService();

    @PostConstruct
    public void init() {
        cities = new LinkedHashMap<String, String>();
        cities.put("Istanbul", "TUXX0014");
        cities.put("Barcelona", "SPXX0015");
        cities.put("London", "UKXX0085");
        cities.put("New York", "USNY0996");
        cities.put("Paris", "FRXX2071");
        cities.put("Rome", "ITXX0067");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void retrieveConditions() {
        conditions = weatherService.getConditions(city, unit);
    }

    public void saveSettings() {
        conditions = null;
    }
}
