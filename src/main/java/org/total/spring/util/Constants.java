package org.total.spring.util;

/**
 * Created by pavlo.fandych on 11/22/2016.
 */

public final class Constants {

    public static final String CALL_FETCH_ALL_RESULTS_SQL = "getResults";

    public static final String CALL_FETCH_TEAM_BY_TEAM_CODE = "getTeamByTeamCode";

    public static final String CALL_GET_SEASON_LIST = "getSeasonsList";

    public static final String CALL_RESULT_SIZE = "getResultSize";

    public static final String CALL_GET_TOURNAMENT_LIST = "getTournamentList";

    public static final String CALL_GET_ALL_RESULTS_BY_SEASON_CODE_AND_TOURNAMENT_CODE = "getAllResultsBySeasonCodeAndTournamentCode";

    public static final String INSERT_RESULT =
            "INSERT INTO GoalDB.Result (date, goalsByGuest," + " goalsByHost, matchDay, resultCode, guestTeamId,"
                    + " hostTeamId, seasonId, tournamentId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String INSERT_CACHED_STANDINGS =
            "INSERT INTO GoalDB.Standings" + " (seasonId, tournamentId, standing) VALUES (?, ?, ?)";

    public static final String INSERT_CACHED_TEAMS_LIST =
            "INSERT INTO GoalDB.TeamsList" + " (seasonId, tournamentId, list) VALUES (?, ?, ?)";

    public static final String UPDATE_CACHED_STANDINGS =
            "UPDATE GoalDB.Standings set standing = ?" + " WHERE seasonId = ? AND tournamentId = ?";

    public static final String UPDATE_CACHED_TEAMS_LIST =
            "UPDATE GoalDB.TeamsList set list = ?" + " WHERE seasonId = ? AND tournamentId = ?";

    public static final String COUNT_CACHED_STANDINGS =
            "SELECT COUNT(*) FROM GoalDB.Standings " + "WHERE seasonId = ? AND tournamentId = ?";

    public static final String COUNT_CACHED_TEAMS_LIST =
            "SELECT COUNT(*) FROM GoalDB.TeamsList " + "WHERE seasonId = ? AND tournamentId = ?";

    public static final String FETCH_SEASON_BY_SEASON_CODE = "SELECT * FROM GoalDB.Season WHERE seasonCode = ?";

    public static final String FETCH_TOURNAMENT_BY_TOURNAMENT_CODE =
            "SELECT * FROM " + "GoalDB.Tournament WHERE tournamentCode = ?";

    public static final String PROTOCOL_SEPARATOR = "://";

    public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";

    public static final String INVALID_TOURNAMENT_CODE = "Invalid tournament code";

    public static final String INVALID_SEASON_CODE = "Invalid season code";

    public static final String NO_TOURNAMENT_CODE_FOUND = "No tournament code found";

    public static final String HOME_TEAM_NAME = "homeTeamName";

    public static final String AWAY_TEAM_NAME = "awayTeamName";

    public static final String GOALS_HOME_TEAM = "goalsHomeTeam";

    public static final String GOALS_AWAY_TEAM = "goalsAwayTeam";

    public static final String MATCH_DAY = "matchday";

    public static final String MATCH_STATUS_FINISHED = "FINISHED";

    public static final String SEASON_MAPPER_FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";

    public static final int MAX_ENTRIES_LOCAL_HEAP = 10000;

    public static final int MAX_ENTRIES_LOCAL_DISK = 1000000;

    public static final int TIME_TO_IDLE_SECONDS = 60;

    private Constants() {
    }
}