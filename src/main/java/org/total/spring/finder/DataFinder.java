package org.total.spring.finder;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.total.spring.dao.GenericDAO;
import org.total.spring.entity.Result;
import org.total.spring.entity.Team;
import org.total.spring.http.HttpExecutor;
import org.total.spring.util.SeasonMapper;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by total on 11/2/16.
 */

public abstract class DataFinder {
    protected static final Logger LOGGER = Logger.getLogger(DataFinder.class);

    @Autowired
    private HttpExecutor httpExecutor;

    @Autowired
    private SeasonMapper seasonMapper;

    protected abstract String getUrl();

    public abstract List<Result> findResults();

    public HttpExecutor getHttpExecutor() {
        return httpExecutor;
    }

    public void setHttpExecutor(HttpExecutor httpExecutor) {
        this.httpExecutor = httpExecutor;
    }

    public SeasonMapper getSeasonMapper() {
        return seasonMapper;
    }

    public void setSeasonMapper(SeasonMapper seasonMapper) {
        this.seasonMapper = seasonMapper;
    }

    protected final JSONArray getFixtures() {
        try {
            return (JSONArray) ((JSONObject) new JSONParser()
                    .parse(getHttpExecutor()
                            .executeGet(getUrl(), new HashMap<String, String>(), ""))).get("fixtures");
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
        return null;
    }

    protected String generateResultCode(String target, Team home, Team away) {
        String[] arrayOne = target.split(" ");
        String[] arrayTwo = arrayOne[0].split("-");
        StringBuilder builder = new StringBuilder();
        builder.append(arrayTwo[2])
                .append(arrayTwo[1])
                .append(arrayTwo[0])
                .append(home.getTeamCode())
                .append(away.getTeamCode())
                .append("XXXX");
        return builder.toString();
    }
}