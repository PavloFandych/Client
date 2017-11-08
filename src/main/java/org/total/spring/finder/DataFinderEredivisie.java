package org.total.spring.finder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.total.spring.dao.DutchTeamDAO;
import org.total.spring.dao.TournamentDAO;
import org.total.spring.entity.Result;
import org.total.spring.entity.Team;
import org.total.spring.entity.Tournament;
import org.total.spring.entity.enums.Protocol;
import org.total.spring.entity.enums.TournamentCode;
import org.total.spring.util.Constants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

/**
 * @author Pavlo.Fandych
 */

@Repository("dataFinderEredivisie")
public final class DataFinderEredivisie extends DataFinder {

    @Autowired
    private DutchTeamDAO dutchTeamDAO;

    @Autowired
    private TournamentDAO tournamentDAO;

    public DutchTeamDAO getDutchTeamDAO() {
        return dutchTeamDAO;
    }

    public void setDutchTeamDAO(DutchTeamDAO dutchTeamDAO) {
        this.dutchTeamDAO = dutchTeamDAO;
    }

    public TournamentDAO getTournamentDAO() {
        return tournamentDAO;
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    @Override
    protected String getUrl() {
        try {
            final Properties credentials = new Properties();
            credentials.load(DataFinderEredivisie.class.getClassLoader().getResourceAsStream("credentials.properties"));

            final String api = credentials.getProperty("apiNLD_EREDIVISIE");
            return Protocol.HTTP.name().concat(Constants.PROTOCOL_SEPARATOR).concat(api);
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
        return null;
    }

    @Override
    public List<Result> findResults() {
        final List<Result> results = new ArrayList<>();
        try {
            final JSONArray fixtures = getFixtures();
            if (fixtures == null) {
                return Collections.emptyList();
            }
            final Iterator<JSONObject> iterator = fixtures.iterator();

            final Tournament tournament = getTournamentDAO()
                    .fetchTournamentByTournamentCode(TournamentCode.NLD_EREDIVISIE.name());

            while (iterator.hasNext()) {
                final JSONObject item = iterator.next();
                final JSONObject result = (JSONObject) item.get("result");

                final Team homeTeam = getDutchTeamDAO().findByTeamName((String) item.get(Constants.HOME_TEAM_NAME));
                final Team awayTeam = getDutchTeamDAO().findByTeamName((String) item.get(Constants.AWAY_TEAM_NAME));

                if (item.get("date") != null && result.get(Constants.GOALS_HOME_TEAM) != null
                        && result.get(Constants.GOALS_AWAY_TEAM) != null && item.get(Constants.MATCH_DAY) != null
                        && homeTeam != null && awayTeam != null && item.get("status").equals(Constants.MATCH_STATUS_FINISHED)
                        && tournament != null) {
                    final String dateString = ((String) item.get("date")).replace('T', ' ');
                    final Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(dateString);
                    if (getSeasonMapper().mapSeason(date) > 0) {
                        final Result targetResult = new Result();
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
