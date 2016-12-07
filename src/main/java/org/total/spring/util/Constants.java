package org.total.spring.util;

/**
 * Created by pavlo.fandych on 11/22/2016.
 */

public final class Constants {
    public static final String CALL_FETCH_ALL_RESULTS_SQL = "getResults";
    public static final String CALL_FETCH_TEAM_BY_TEAM_ID = "getTeamByTeamId";
    public static final String CALL_FETCH_TEAM_BY_TEAM_CODE = "getTeamByTeamCode";
    public static final String CALL_GET_SEASON_LIST = "getSeasonsList";
    public static final String CALL_RESULT_SIZE = "getResultSize";
    public static final String CALL_GET_TOURNAMENT_LIST = "getTournamentList";
    public static final String CALL_GET_ALL_RESULTS_BY_SEASON_CODE_AND_TOURNAMENT_CODE = "getAllResultsBySeasonCodeAndTournamentCode";

    public static final String INSERT_RESULT = "INSERT INTO GoalDB.Result (date, goalsByGuest," +
            " goalsByHost, matchDay, resultCode, guestTeamId," +
            " hostTeamId, seasonId, tournamentId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String INSERT_CACHED_STANDINGS = "INSERT INTO GoalDB.Standings" +
            " (seasonId, tournamentId, standing) VALUES (?, ?, ?)";

    public static final String UPDATE_CACHED_STANDINGS = "UPDATE GoalDB.Standings set standing = ?" +
            " WHERE seasonId = ? AND tournamentId = ?";

    public static final String COUNT_CACHED_STANDINGS = "SELECT COUNT(*) FROM Standings " +
            "WHERE seasonId = ? AND tournamentId = ?";

    public static final String FETCH_SEASON_BY_SEASON_CODE = "SELECT * FROM GoalDB.Season WHERE seasonCode = ?";

    public static final String FETCH_TOURNAMENT_BY_TOURNAMENT_CODE = "SELECT * FROM " +
            "GoalDB.Tournament WHERE tournamentCode = ?";

    /*URL football-data.org*/
    public static final String API_BUNDESLIGA_1 = "://api.football-data.org/v1/soccerseasons/430/fixtures";
    public static final String API_BUNDESLIGA_2 = "://api.football-data.org/v1/soccerseasons/431/fixtures";
    public static final String API_ENG_PREM_LEAGUE = "://api.football-data.org/v1/soccerseasons/426/fixtures";
    public static final String API_ESP_PRIMERA = "://api.football-data.org/v1/soccerseasons/436/fixtures";
    public static final String API_ITA_SERIA_A = "://api.football-data.org/v1/soccerseasons/438/fixtures";
    public static final String API_FRA_LIGUE_1 = "://api.football-data.org/v1/soccerseasons/434/fixtures";

    /*URL*/
    public static final String URL_STANDINGS = "http://localhost:8080/standings";

    public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";

    public static final String INVALID_TOURNAMENT_CODE = "Invalid tournament code";
    public static final String INVALID_SEASON_CODE = "Invalid season code";
    public static final String NO_TOURNAMENT_CODE_FOUND = "No tournament code found";
}
