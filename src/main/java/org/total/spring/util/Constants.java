package org.total.spring.util;

/**
 * Created by pavlo.fandych on 11/22/2016.
 */

public interface Constants {
    public static final String CALL_FETCH_ALL_RESULTS_SQL = "getResults";
    public static final String CALL_FETCH_TEAM_BY_TEAM_ID = "getTeamByTeamId";
    public static final String CALL_GET_SEASON_LIST = "getSeasonsList";
    public static final String CALL_RESULT_SIZE = "getResultSize";

    public static final String INSERT_RESULT = "INSERT INTO GoalDB.Result (date, goalsByGuest," +
            " goalsByHost, matchDay, resultCode, guestTeamId," +
            " hostTeamId, seasonId, tournamentId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String API_BUNDESLIGA_1 = "://api.football-data.org/v1/soccerseasons/430/fixtures";
    public static final String API_BUNDESLIGA_2 = "://api.football-data.org/v1/soccerseasons/431/fixtures";
    public static final String API_ENG_PREM_LEAGUE = "://api.football-data.org/v1/soccerseasons/426/fixtures";
    public static final String API_ESP_PRIMERA = "://api.football-data.org/v1/soccerseasons/436/fixtures";
    public static final String API_ITA_SERIA_A = "://api.football-data.org/v1/soccerseasons/438/fixtures";
}
