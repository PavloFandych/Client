package org.total.spring.finder;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.total.spring.dao.SpanishTeamDAO;
import org.total.spring.entity.Result;
import org.total.spring.entity.Team;
import org.total.spring.entity.enums.Protocol;
import org.total.spring.util.Constants;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by pavlo.fandych on 11/29/2016.
 */

@Repository("dataFinderSpainPrimera")
public class DataFinderSpainPrimera extends DataFinder {
    @Autowired
    private SpanishTeamDAO spanishTeamDAO;

    public SpanishTeamDAO getSpanishTeamDAO() {
        return spanishTeamDAO;
    }

    public void setSpanishTeamDAO(SpanishTeamDAO spanishTeamDAO) {
        this.spanishTeamDAO = spanishTeamDAO;
    }

    @Override
    protected final String getUrl() {
        return Protocol.HTTP.name()
                + Constants.API_ESP_PRIMERA;
    }

    @Override
    public List<Result> findResults() {
        List<Result> results = new ArrayList<>();
        try {
            Iterator<JSONObject> iterator = getFixtures().iterator();

            while (iterator.hasNext()) {
                JSONObject item = iterator.next();
                JSONObject result = (JSONObject) item.get("result");

                Team homeTeam = getSpanishTeamDAO().findByTeamName((String) item.get("homeTeamName"));
                Team awayTeam = getSpanishTeamDAO().findByTeamName((String) item.get("awayTeamName"));

                if (item.get("date") != null
                        && result.get("goalsHomeTeam") != null
                        && result.get("goalsAwayTeam") != null
                        && item.get("matchday") != null
                        && homeTeam != null
                        && awayTeam != null) {
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
                    targetResult.setTournamentId(7L);

                    results.add(targetResult);
                }
            }
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
        return results;
    }
}
