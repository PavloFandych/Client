package org.total.spring.entity;

import org.total.spring.entity.enums.TournamentCode;
import org.total.spring.entity.enums.TournamentType;

import java.io.Serializable;

/**
 * Created by total on 12/1/16.
 */

public final class Tournament implements Serializable {
    private long tournamentId;
    private TournamentCode tournamentCode;
    private String tournamentName;
    private TournamentType tournamentType;
    private long countryId;

    public long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public TournamentCode getTournamentCode() {
        return tournamentCode;
    }

    public void setTournamentCode(TournamentCode tournamentCode) {
        this.tournamentCode = tournamentCode;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public TournamentType getTournamentType() {
        return tournamentType;
    }

    public void setTournamentType(TournamentType tournamentType) {
        this.tournamentType = tournamentType;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "tournamentId=" + tournamentId +
                ", tournamentCode=" + tournamentCode +
                ", tournamentName='" + tournamentName + '\'' +
                ", tournamentType=" + tournamentType +
                ", countryId=" + countryId +
                '}';
    }
}