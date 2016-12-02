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
import org.total.spring.util.Constants;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by pavlo.fandych on 11/24/2016.
 */

@Repository("dataFinderEnglishPremierLeague")
public class DataFinderEnglishPremierLeague extends DataFinder {
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

            Tournament tournament = getTournamentDAO().fetchTournamentByTournamentCode("ENG_PREM_LEAGUE");

            while (iterator.hasNext()) {
                JSONObject item = iterator.next();
                JSONObject result = (JSONObject) item.get("result");

                Team homeTeam = getEnglishTeamDAO().findByTeamName((String) item.get("homeTeamName"));
                Team awayTeam = getEnglishTeamDAO().findByTeamName((String) item.get("awayTeamName"));

                if (item.get("date") != null
                        && result.get("goalsHomeTeam") != null
                        && result.get("goalsAwayTeam") != null
                        && item.get("matchday") != null
                        && homeTeam != null
                        && awayTeam != null
                        && item.get("status").equals("FINISHED")
                        && tournament != null) {
                    Result targetResult = new Result();

                    String dateString = ((String) item.get("date")).replace('T', ' ');
                    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                            Locale.ENGLISH).parse(dateString);
                    targetResult.setDate(date);
                    targetResult.setGoalsByGuest((long) result.get("goalsAwayTeam"));
                    targetResult.setGoalsByHost((long) result.get("goalsHomeTeam"));
                    targetResult.setMatchDay((long) item.get("matchday"));
                    targetResult.setResultCode(generateResultCode(dateString, homeTeam, awayTeam));
                    targetResult.setGuestTeamId(awayTeam.getTeamId());
                    targetResult.setHostTeamId(homeTeam.getTeamId());
                    targetResult.setSeasonId(getSeasonMapper().mapSeason(date));
                    targetResult.setTournamentId(tournament.getTournamentId());

                    results.add(targetResult);
                }
            }
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
        return results;
    }
}
