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
import org.total.spring.util.SeasonMapper;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by total on 11/20/16.
 */

@Repository("dataFinderBundesLiga1")
public class DataFinderBundesLiga1 extends DataFinder {
    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private SeasonMapper seasonMapper;

    public TeamDAO getTeamDAO() {
        return teamDAO;
    }

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public SeasonMapper getSeasonMapper() {
        return seasonMapper;
    }

    public void setSeasonMapper(SeasonMapper seasonMapper) {
        this.seasonMapper = seasonMapper;
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

                    String[] arrayOne = dateString.split(" ");
                    String[] arrayTwo = arrayOne[0].split("-");
                    StringBuilder builder = new StringBuilder();
                    builder.append(arrayTwo[2])
                            .append(arrayTwo[1])
                            .append(arrayTwo[0])
                            .append(homeTeam.getTeamCode())
                            .append(awayTeam.getTeamCode())
                            .append("XXX");
                    targetResult.setResultCode(builder.toString());
                    targetResult.setGuestTeamId(awayTeam.getTeamId());
                    targetResult.setHostTeamId(homeTeam.getTeamId());
                    targetResult.setSeasonId(getSeasonMapper().mapSeason(date));
                    targetResult.setTournamentId(1L);

                    results.add(targetResult);
                }
            }
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
        return results;
    }
}