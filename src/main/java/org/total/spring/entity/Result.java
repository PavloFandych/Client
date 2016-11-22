package org.total.spring.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kostya on 10/15/16.
 */


public class Result implements Serializable {
    private long resultId;
    private String resultCode;
    private Tournament tournament;
    private Season season;
    private byte matchDay;
    private Team hostTeam;
    private Team guestTeam;
    private byte goalsByHost;
    private byte goalsByGuest;
    private Date date;

    public Result() {
    }

    public Result(Team hostTeam, Team guestTeam, byte goalsByHost, byte goalsByGuest) {
        this.hostTeam = hostTeam;
        this.guestTeam = guestTeam;
        this.goalsByHost = goalsByHost;
        this.goalsByGuest = goalsByGuest;
    }

    public long getResultId() {
        return resultId;
    }

    public void setResultId(long resultId) {
        this.resultId = resultId;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public byte getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(byte matchDay) {
        this.matchDay = matchDay;
    }

    public Team getHostTeam() {
        return hostTeam;
    }

    public void setHostTeam(Team hostTeam) {
        this.hostTeam = hostTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(Team guestTeam) {
        this.guestTeam = guestTeam;
    }

    public byte getGoalsByHost() {
        return goalsByHost;
    }

    public void setGoalsByHost(byte goalsByHost) {
        this.goalsByHost = goalsByHost;
    }

    public byte getGoalsByGuest() {
        return goalsByGuest;
    }

    public void setGoalsByGuest(byte goalsByGuest) {
        this.goalsByGuest = goalsByGuest;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if ((resultId != result.resultId)
                || (!resultCode.equals(result.resultCode))
                || (!tournament.equals(result.tournament))
                || (!season.equals(result.season))
                || (matchDay != result.matchDay)
                || (!hostTeam.equals(result.hostTeam))
                || (!guestTeam.equals(result.guestTeam))
                || (goalsByHost != result.goalsByHost)
                || (goalsByGuest != result.goalsByGuest)
                || (!date.equals(result.date))
                ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (resultId ^ (resultId >>> 32));
        result = 31 * result + resultCode.hashCode();
        result = 31 * result + hostTeam.hashCode();
        result = 31 * result + guestTeam.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    public String calcScore() {
        return goalsByHost + ":" + goalsByGuest;
    }

    @Override
    public String toString() {
        return "Result{" +
                "goalsByHost=" + goalsByHost +
                ", goalsByGuest=" + goalsByGuest +
                ", resultId=" + resultId +
                ", resultCode='" + resultCode + '\'' +
                ", date=" + date +
                ", hostTeam=" + hostTeam +
                ", guestTeam=" + guestTeam +
                '}';
    }
}