package org.total.spring.entity;

import org.total.spring.entity.enums.CityCode;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class City implements Serializable {
    private long cityId;
    private String cityName;
    private CityCode cityCode;
    private Country country;
    private Set<Team> teams;

    public City() {
    }

    public City(String cityName, CityCode cityCode) {
        this.cityName = cityName;
        this.cityCode = cityCode;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public CityCode getCityCode() {
        return cityCode;
    }

    public void setCityCode(CityCode cityCode) {
        this.cityCode = cityCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Team> getTeams() {
        if (this.teams == null) {
            this.teams = new HashSet<>();
        }
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (cityId != city.cityId) return false;
        if (!cityCode.equals(city.cityCode)) return false;
        if (!cityName.equals(city.cityName)) return false;
        if (!country.equals(city.country)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cityId ^ (cityId >>> 32));
        result = 31 * result + cityName.hashCode();
        result = 31 * result + cityCode.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "country=" + country +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}