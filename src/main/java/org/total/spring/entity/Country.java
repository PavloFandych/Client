package org.total.spring.entity;

import org.total.spring.entity.enums.CountryCode;

import java.io.Serializable;
import java.util.Set;

public class Country implements Serializable {
    private long countryId;
    private String countryName;
    private CountryCode countryCode;
    private Set<City> cities;
    private Set<Tournament> tournaments;

    public Country() {
    }

    public Country(long countryId, String countryName, CountryCode countryCode, Set<Team> teams) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    public Country(String countryName, CountryCode countryCode) {
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (countryId != country.countryId) return false;
        if (countryCode != country.countryCode) return false;
        if (!countryName.equals(country.countryName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (countryId ^ (countryId >>> 32));
        result = 31 * result + countryName.hashCode();
        result = 31 * result + countryCode.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                ", countryCode=" + countryCode +
                '}';
    }
}