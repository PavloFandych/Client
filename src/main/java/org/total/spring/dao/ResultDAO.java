package org.total.spring.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.total.spring.entity.Result;
import org.total.spring.entity.enums.SeasonCode;
import org.total.spring.entity.enums.TournamentCode;
import org.total.spring.util.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

@Repository("resultDAO")
public final class ResultDAO extends GenericDAO {

    public SortedSet<Result> results() {
        final SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(getJdbcTemplate())
                .withProcedureName(Constants.CALL_FETCH_ALL_RESULTS_SQL)
                .returningResultSet("results", (resultSet, i) -> {
                    final Result result = new Result();

                    try {
                        result.setResultId(resultSet.getLong("resultId"));
                        result.setDate(
                                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(resultSet.getString("date")));
                        result.setGoalsByGuest(resultSet.getLong("goalsByGuest"));
                        result.setGoalsByHost(resultSet.getLong("goalsByHost"));
                        result.setMatchDay(resultSet.getLong("matchDay"));
                        result.setResultCode(resultSet.getString("resultCode"));
                        result.setGuestTeamId(resultSet.getLong("guestTeamId"));
                        result.setHostTeamId(resultSet.getLong("hostTeamId"));
                        result.setSeasonId(resultSet.getLong("seasonId"));
                        result.setTournamentId(resultSet.getLong("tournamentId"));
                    } catch (ParseException e) {
                        LOGGER.error(e, e);
                    }

                    return result;
                });

        final Map<String, Object> out = simpleJdbcCall.execute();

        return (new TreeSet<>((List<Result>) out.get("results")));
    }

    public SortedSet<Result> findResultsBySeasonCodeAndTournamentCode(final SeasonCode seasonCode,
                                                                      final TournamentCode tournamentCode) {
        final SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(getJdbcTemplate())
                .withProcedureName(Constants.CALL_GET_ALL_RESULTS_BY_SEASON_CODE_AND_TOURNAMENT_CODE)
                .returningResultSet("resultsBySeasonCodeAndTournamentCode", (java.sql.ResultSet resultSet, int i) -> {
                    final Result result = new Result();

                    try {
                        result.setResultId(resultSet.getLong("resultId"));
                        result.setDate(
                                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(resultSet.getString("date")));
                        result.setGoalsByGuest(resultSet.getLong("goalsByGuest"));
                        result.setGoalsByHost(resultSet.getLong("goalsByHost"));
                        result.setMatchDay(resultSet.getLong("matchDay"));
                        result.setResultCode(resultSet.getString("resultCode"));
                        result.setGuestTeamId(resultSet.getLong("guestTeamId"));
                        result.setHostTeamId(resultSet.getLong("hostTeamId"));
                        result.setSeasonId(resultSet.getLong("seasonId"));
                        result.setTournamentId(resultSet.getLong("tournamentId"));
                    } catch (ParseException e) {
                        LOGGER.error(e, e);
                    }

                    return result;
                });

        final Map<String, Object> out = simpleJdbcCall.execute(
                new MapSqlParameterSource().addValue("seasonCodeVar", seasonCode.name())
                        .addValue("tournamentCodeVar", tournamentCode.name()));

        return (new TreeSet<>((List<Result>) out.get("resultsBySeasonCodeAndTournamentCode")));
    }

    public Long getResultSize() {
        final SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(getJdbcTemplate()).withProcedureName(Constants.CALL_RESULT_SIZE)
                .returningResultSet("size",
                        (java.sql.ResultSet resultSet, int i) -> resultSet.getLong("COUNT(DISTINCT resultCode)"));

        final Map<String, Object> out = simpleJdbcCall.execute();

        final List<Long> resultList = (List<Long>) out.get("size");

        return (resultList != null && !resultList.isEmpty()) ? resultList.get(0) : -1L;
    }

    public void insertResult(final Result result) {
        LOGGER.info("saving..." + result);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(result.getDate());

        final Object[] objects = new Object[9];
        objects[0] = calendar;
        objects[1] = result.getGoalsByGuest();
        objects[2] = result.getGoalsByHost();
        objects[3] = result.getMatchDay();
        objects[4] = result.getResultCode();
        objects[5] = result.getGuestTeamId();
        objects[6] = result.getHostTeamId();
        objects[7] = result.getSeasonId();
        objects[8] = result.getTournamentId();

        getJdbcTemplate().update(Constants.INSERT_RESULT, objects);
    }
}