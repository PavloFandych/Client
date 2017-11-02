package org.total.spring.entity;

import java.io.Serializable;

/**
 * Created by pavlo.fandych on 11/23/2016.
 */

public final class Team implements Serializable {

    private long teamId;

    private String teamCode;

    private String teamName;

    private long cityId;

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Team{" + "teamId=" + teamId + ", teamCode='" + teamCode + '\'' + ", teamName='" + teamName + '\'' + ", cityId="
                + cityId + '}';
    }
}