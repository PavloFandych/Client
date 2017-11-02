package org.total.spring.entity;

import org.total.spring.entity.enums.SeasonCode;

import java.io.Serializable;

/**
 * Created by total on 11/23/16.
 */

public final class Season implements Serializable {

    private long seasonId;

    private SeasonCode seasonCode;

    private String seasonName;

    public long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(long seasonId) {
        this.seasonId = seasonId;
    }

    public SeasonCode getSeasonCode() {
        return seasonCode;
    }

    public void setSeasonCode(SeasonCode seasonCode) {
        this.seasonCode = seasonCode;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    @Override
    public String toString() {
        return "Season{" + "seasonId=" + seasonId + ", seasonCode=" + seasonCode + ", seasonName='" + seasonName + '\'' + '}';
    }
}