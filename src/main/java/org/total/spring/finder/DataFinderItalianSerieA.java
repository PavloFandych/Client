package org.total.spring.finder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.total.spring.dao.ItalianTeamDAO;
import org.total.spring.dao.TournamentDAO;
import org.total.spring.entity.Result;
import org.total.spring.entity.Team;
import org.total.spring.entity.Tournament;
import org.total.spring.entity.enums.Protocol;
import org.total.spring.util.Constants;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by total on 11/24/16.
 */

@Repository("dataFinderItalianSerieA")
public class DataFinderItalianSerieA extends DataFinder {
    @Autowired
    private ItalianTeamDAO italianTeamDAO;

    @Autowired
    private TournamentDAO tournamentDAO;

    public ItalianTeamDAO getItalianTeamDAO() {
        return italianTeamDAO;
    }

    public void setItalianTeamDAO(ItalianTeamDAO italianTeamDAO) {
        this.italianTeamDAO = italianTeamDAO;
    }

    public TournamentDAO getTournamentDAO() {
        return tournamentDAO;
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    @Override
    protected String getUrl() {
        return Protocol.HTTP.name()
                + Constants.API_ITA_SERIA_A;
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

            Tournament tournament = getTournamentDAO().fetchTournamentByTournamentCode("ITA_SERIA_A");

            while (iterator.hasNext()) {
                JSONObject item = iterator.next();
                JSONObject result = (JSONObject) item.get("result");

                Team homeTeam = getItalianTeamDAO().findByTeamName((String) item.get("homeTeamName"));
                Team awayTeam = getItalianTeamDAO().findByTeamName((String) item.get("awayTeamName"));

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
