package org.total.spring.entity;

import java.io.Serializable;
import java.util.Date;

public class Result implements Serializable {
    private long resultId;
    private Date date;
    private long goalsByGuest;
    private long goalsByHost;
    private long matchDay;
    private String resultCode;
    private long guestTeamId;
    private long hostTeamId;
    private long seasonId;
    private long tournamentId;

    public Result() {
    }

    public Result(Date date, String resultCode) {
        this.date = date;
        this.resultCode = resultCode;
    }

    public long getResultId() {
        return resultId;
    }

    public void setResultId(long resultId) {
        this.resultId = resultId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getGoalsByGuest() {
        return goalsByGuest;
    }

    public void setGoalsByGuest(long goalsByGuest) {
        this.goalsByGuest = goalsByGuest;
    }

    public long getGoalsByHost() {
        return goalsByHost;
    }

    public void setGoalsByHost(long goalsByHost) {
        this.goalsByHost = goalsByHost;
    }

    public long getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(long matchDay) {
        this.matchDay = matchDay;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public long getGuestTeamId() {
        return guestTeamId;
    }

    public void setGuestTeamId(long guestTeamId) {
        this.guestTeamId = guestTeamId;
    }

    public long getHostTeamId() {
        return hostTeamId;
    }

    public void setHostTeamId(long hostTeamId) {
        this.hostTeamId = hostTeamId;
    }

    public long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(long seasonId) {
        this.seasonId = seasonId;
    }

    public long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(long tournamentId) {
        this.tournamentId = tournamentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (goalsByGuest != result.goalsByGuest) return false;
        if (goalsByHost != result.goalsByHost) return false;
        if (guestTeamId != result.guestTeamId) return false;
        if (hostTeamId != result.hostTeamId) return false;
        if (matchDay != result.matchDay) return false;
        if (seasonId != result.seasonId) return false;
        if (tournamentId != result.tournamentId) return false;
        if (!resultCode.equals(result.resultCode)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultId=" + resultId +
                ", date=" + date +
                ", goalsByGuest=" + goalsByGuest +
                ", goalsByHost=" + goalsByHost +
                ", matchDay=" + matchDay +
                ", resultCode='" + resultCode + '\'' +
                ", guestTeamId=" + guestTeamId +
                ", hostTeamId=" + hostTeamId +
                ", seasonId=" + seasonId +
                ", tournamentId=" + tournamentId +
                '}';
    }
}