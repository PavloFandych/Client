package org.total.spring.finder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.total.spring.dao.EnglishTeamDAO;
import org.total.spring.dao.TournamentDAO;
import org.total.spring.entity.Result;
import org.total.spring.entity.Team;
import org.total.spring.entity.Tournament;
import org.total.spring.entity.enums.Protocol;
import org.total.spring.entity.enums.TournamentCode;
import org.total.spring.util.Constants;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by pavlo.fandych on 11/24/2016.
 */

@Repository("dataFinderEnglishPremierLeague")
public final class DataFinderEnglishPremierLeague extends DataFinder {
    @Autowired
    private EnglishTeamDAO englishTeamDAO;

    @Autowired
    private TournamentDAO tournamentDAO;

    public EnglishTeamDAO getEnglishTeamDAO() {
        return englishTeamDAO;
    }

    public void setEnglishTeamDAO(EnglishTeamDAO englishTeamDAO) {
        this.englishTeamDAO = englishTeamDAO;
    }

    public TournamentDAO getTournamentDAO() {
        return tournamentDAO;
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    @Override
    protected final String getUrl() {
        return Protocol.HTTP.name()
                + Constants.API_ENG_PREM_LEAGUE;
    }

    @Override
    public List<Result> findResults() {
        List<Result> results = new ArrayList<>();
        try {
            JSONArray fixtures = getFixtures();
            if (fixtures == null) {
                return null;
            }

            Iterator<JSONObject> iterator = fixtures.iterator();

            Tournament tournament = getTournamentDAO()
                    .fetchTournamentByTournamentCode(TournamentCode.ENG_PREM_LEAGUE.name());

            while (iterator.hasNext()) {
                JSONObject item = iterator.next();
                JSONObject result = (JSONObject) item.get("result");

                Team homeTeam = getEnglishTeamDAO()
                        .findByTeamName((String) item.get(Constants.HOME_TEAM_NAME));
                Team awayTeam = getEnglishTeamDAO()
                        .findByTeamName((String) item.get(Constants.AWAY_TEAM_NAME));

                if (item.get("date") != null
                        && result.get(Constants.GOALS_HOME_TEAM) != null
                        && result.get(Constants.GOALS_AWAY_TEAM) != null
                        && item.get(Constants.MATCH_DAY) != null
                        && homeTeam != null
                        && awayTeam != null
                        && item.get("status").equals(Constants.MATCH_STATUS_FINISHED)
                        && tournament != null) {
                    String dateString = ((String) item.get("date")).replace('T', ' ');
                    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                            Locale.ENGLISH).parse(dateString);
                    if (getSeasonMapper().mapSeason(date) > 0) {
                        Result targetResult = new Result();
                        targetResult.setDate(date);
                        targetResult.setGoalsByGuest((long) result.get(Constants.GOALS_AWAY_TEAM));
                        targetResult.setGoalsByHost((long) result.get(Constants.GOALS_HOME_TEAM));
                        targetResult.setMatchDay((long) item.get(Constants.MATCH_DAY));
                        targetResult.setResultCode(generateResultCode(dateString, homeTeam, awayTeam));
                        targetResult.setGuestTeamId(awayTeam.getTeamId());
                        targetResult.setHostTeamId(homeTeam.getTeamId());
                        targetResult.setSeasonId(getSeasonMapper().mapSeason(date));
                        targetResult.setTournamentId(tournament.getTournamentId());

                        results.add(targetResult);
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
        return results;
    }
}
