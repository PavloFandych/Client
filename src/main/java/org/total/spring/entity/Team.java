package org.total.spring.entity;

import java.io.Serializable;
import java.util.Set;


public class Team implements Serializable {
    private long teamId;
    private String teamName;
    private String teamCode;
    private City city;
    private Set<Result> resultsAsHost;
    private Set<Result> resultsAsGuest;

    public Team() {
    }

    public Team(long teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Result> getResultsAsHost() {
        return resultsAsHost;
    }

    public void setResultsAsHost(Set<Result> resultsAsHost) {
        this.resultsAsHost = resultsAsHost;
    }

    public Set<Result> getResultsAsGuest() {
        return resultsAsGuest;
    }

    public void setResultsAsGuest(Set<Result> resultsAsGuest) {
        this.resultsAsGuest = resultsAsGuest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (teamId != team.teamId) return false;
        if (!city.equals(team.city)) return false;
        if (!teamCode.equals(team.teamCode)) return false;
        if (!teamName.equals(team.teamName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (teamId ^ (teamId >>> 32));
        result = 31 * result + teamName.hashCode();
        result = 31 * result + teamCode.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", teamId=" + teamId +
                '}';
    }
}