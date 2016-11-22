package org.total.spring.entity;

import org.total.spring.entity.enums.SeasonCode;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by kostya on 10/15/16.
 */

public class Season implements Serializable {
    private long seasonId;
    private String seasonName;
    private SeasonCode seasonCode;
    private Set<Result> results;

    public Season() {
    }

    public Season(long seasonId, String seasonName, SeasonCode seasonCode) {
        this.seasonId = seasonId;
        this.seasonName = seasonName;
        this.seasonCode = seasonCode;
    }

    public Season(long seasonId, String seasonName, SeasonCode seasonCode, Set<Result> results) {
        this.seasonId = seasonId;
        this.seasonName = seasonName;
        this.seasonCode = seasonCode;
        this.results = results;
    }

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

    public Set<Result> getResults() {
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Season season = (Season) o;

        if (seasonId != season.seasonId) return false;
        if (seasonCode != season.seasonCode) return false;
        if (!seasonName.equals(season.seasonName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seasonId ^ (seasonId >>> 32));
        result = 31 * result + seasonName.hashCode();
        result = 31 * result + seasonCode.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Season{seasonId=" + seasonId +
                ", seasonName='" + seasonName + '\'' +
                ", seasonCode=" + seasonCode +
                '}';
    }
}