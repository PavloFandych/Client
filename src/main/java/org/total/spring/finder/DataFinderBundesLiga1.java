package org.total.spring.finder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.total.spring.entity.enums.Protocol;
import org.total.spring.http.HttpExecutor;
import org.total.spring.entity.Result;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by total on 11/20/16.
 */

public class DataFinderBundesLiga1 extends DataFinder {
    @Override
    protected final String getUrl() {
        return Protocol.HTTP.name()
                + "://api.football-data.org/v1/soccerseasons/430/fixtures";
    }

    @Override
    public Set<Result> findResults() {
        Set<Result> results = new HashSet<>();
        try {
            String response = HttpExecutor.getInstance()
                    .executeGet(getUrl(), new HashMap<String, String>(), "");

            JSONObject jsonObject = (JSONObject) new JSONParser().parse(response);

            JSONArray fixtues = (JSONArray) jsonObject.get("fixtures");

            Iterator<JSONObject> iterator = fixtues.iterator();

            while (iterator.hasNext()) {
                JSONObject item = iterator.next();
                JSONObject result = (JSONObject) item.get("result");

                if (result.get("goalsHomeTeam") != null
                        && result.get("goalsAwayTeam") != null) {
                    System.out.println(item.get("matchday")
                            + " " + item.get("homeTeamName")
                            + " vs " + item.get("awayTeamName")
                            + " - " + result.get("goalsHomeTeam")
                            + ":" + result.get("goalsAwayTeam")
                            + " " + item.get("date"));
                }
            }
        } catch (Exception e) {
            LOGGER.error(e, e);
        }

        return results;
    }
}