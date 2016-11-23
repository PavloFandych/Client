package org.total.spring.finder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.total.spring.dao.TeamDAO;
import org.total.spring.entity.Result;
import org.total.spring.entity.Team;
import org.total.spring.entity.enums.Protocol;
import org.total.spring.http.HttpExecutor;
import org.total.spring.util.Constants;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by total on 11/20/16.
 */

@Repository("dataFinderBundesLiga1")
public class DataFinderBundesLiga1 extends DataFinder {
    @Autowired
    private TeamDAO teamDAO;

    public TeamDAO getTeamDAO() {
        return teamDAO;
    }

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    @Override
    protected final String getUrl() {
        return Protocol.HTTP.name()
                + Constants.API_BUNDESLIGA_1;
    }

    @Override
    public List<Result> findResults() {
        List<Result> results = new ArrayList<>();
        try {
            String response = HttpExecutor.getInstance()
                    .executeGet(getUrl(), new HashMap<String, String>(), "");

            JSONObject jsonObject = (JSONObject) new JSONParser().parse(response);

            JSONArray fixtues = (JSONArray) jsonObject.get("fixtures");

            Iterator<JSONObject> iterator = fixtues.iterator();

            while (iterator.hasNext()) {
                JSONObject item = iterator.next();
                JSONObject result = (JSONObject) item.get("result");

                Team homeTeam = getTeamDAO().findByTeamName((String) item.get("homeTeamName"));
                Team awayTeam = getTeamDAO().findByTeamName((String) item.get("awayTeamName"));

                if (result.get("goalsHomeTeam") != null
                        && result.get("goalsAwayTeam") != null
                        && homeTeam != null
                        && awayTeam != null) {
                    Result resultToSave = new Result();
                    resultToSave.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                            Locale.ENGLISH).parse(((String) item.get("date")).replace('T', ' ')));
                    resultToSave.setGoalsByGuest((long) result.get("goalsAwayTeam"));
                    resultToSave.setGoalsByHost((long) result.get("goalsHomeTeam"));
                    resultToSave.setMatchDay((long) item.get("matchday"));
                    resultToSave.setGuestTeamId(awayTeam.getTeamId());
                    resultToSave.setHostTeamId(homeTeam.getTeamId());
                    results.add(resultToSave);
                }
            }
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
        return results;
    }
}