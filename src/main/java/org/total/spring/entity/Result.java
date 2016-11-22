package org.total.spring.entity;

import java.io.Serializable;
import java.util.Date;

public class Result implements Serializable {
    private long resultId;
    private Date date;
    private int goalsByGuest;
    private int goalsByHost;
    private int matchDay;
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

    public int getGoalsByGuest() {
        return goalsByGuest;
    }

    public void setGoalsByGuest(int goalsByGuest) {
        this.goalsByGuest = goalsByGuest;
    }

    public int getGoalsByHost() {
        return goalsByHost;
    }

    public void setGoalsByHost(int goalsByHost) {
        this.goalsByHost = goalsByHost;
    }

    public int getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(int matchDay) {
        this.matchDay = matchDay;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Long getGuestTeamId() {
        return guestTeamId;
    }

    public void setGuestTeamId(Long guestTeamId) {
        this.guestTeamId = guestTeamId;
    }

    public Long getHostTeamId() {
        return hostTeamId;
    }

    public void setHostTeamId(Long hostTeamId) {
        this.hostTeamId = hostTeamId;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String calcScore() {
        return goalsByHost + ":" + goalsByGuest;
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