package org.total.spring.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.total.spring.entity.Result;
import org.total.spring.entity.enums.TournamentCode;
import org.total.spring.util.Constants;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository("resultDAO")
public class ResultDAO extends GenericDAO {
    public TreeSet<Result> results() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(getJdbcTemplate())
                .withProcedureName(Constants.CALL_FETCH_ALL_RESULTS_SQL)
                .returningResultSet("results", new RowMapper<Result>() {
                    @Override
                    public Result mapRow(java.sql.ResultSet resultSet, int i) throws SQLException {
                        Result result = new Result();

                        try {
                            result.setResultId(resultSet.getLong("resultId"));
                            result.setDate(
                                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
                                            .parse(resultSet.getString("date")));
                            result.setGoalsByGuest(resultSet.getLong("goalsByGuest"));
                            result.setGoalsByHost(resultSet.getLong("goalsByHost"));
                            result.setMatchDay(resultSet.getLong("matchDay"));
                            result.setResultCode(resultSet.getString("resultCode"));
                            result.setGuestTeamId(resultSet.getLong("guestTeamId"));
                            result.setHostTeamId(resultSet.getLong("hostTeamId"));
                            result.setSeasonId(resultSet.getLong("seasonId"));
                            result.setTournamentId(resultSet.getLong("tournamentId"));
                        } catch (ParseException e) {
                        }
                        return result;
                    }
                });

        Map<String, Object> out = simpleJdbcCall
                .execute();

        return (new TreeSet<>((List<Result>) out.get("results")));
    }

    public TreeSet<Result> findResultsByTournamentCode(TournamentCode tournamentCode) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(getJdbcTemplate())
                .withProcedureName(Constants.CALL_GET_ALL_RESULTS_BY_TOURNAMENT_CODE)
                .returningResultSet("resultsByTournamentCode", new RowMapper<Result>() {
                    @Override
                    public Result mapRow(java.sql.ResultSet resultSet, int i) throws SQLException {
                        Result result = new Result();

                        try {
                            result.setResultId(resultSet.getLong("resultId"));
                            result.setDate(
                                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
                                            .parse(resultSet.getString("date")));
                            result.setGoalsByGuest(resultSet.getLong("goalsByGuest"));
                            result.setGoalsByHost(resultSet.getLong("goalsByHost"));
                            result.setMatchDay(resultSet.getLong("matchDay"));
                            result.setResultCode(resultSet.getString("resultCode"));
                            result.setGuestTeamId(resultSet.getLong("guestTeamId"));
                            result.setHostTeamId(resultSet.getLong("hostTeamId"));
                            result.setSeasonId(resultSet.getLong("seasonId"));
                            result.setTournamentId(resultSet.getLong("tournamentId"));
                        } catch (ParseException e) {
                        }
                        return result;
                    }
                });

        Map<String, Object> out = simpleJdbcCall
                .execute(new MapSqlParameterSource()
                        .addValue("tournamentCodeVar", tournamentCode.name()));

        return (new TreeSet<>((List<Result>) out.get("resultsByTournamentCode")));
    }

    public Long getResultSize() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(getJdbcTemplate())
                .withProcedureName(Constants.CALL_RESULT_SIZE)
                .returningResultSet("size", new RowMapper<Long>() {
                    @Override
                    public Long mapRow(java.sql.ResultSet resultSet, int i) throws SQLException {
                        return resultSet.getLong("COUNT(DISTINCT resultCode)");
                    }
                });

        Map<String, Object> out = simpleJdbcCall
                .execute();

        List<Long> resultList = (List<Long>) out.get("size");

        return (resultList!= null && !resultList.isEmpty()) ? resultList.get(0) : -1;
    }

    public void insertResult(final Result result) {
        LOGGER.info("saving..." + result);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(result.getDate());
        getJdbcTemplate().update(Constants.INSERT_RESULT, new Object[]{calendar,
                result.getGoalsByGuest(),
                result.getGoalsByHost(),
                result.getMatchDay(),
                result.getResultCode(),
                result.getGuestTeamId(),
                result.getHostTeamId(),
                result.getSeasonId(),
                result.getTournamentId()});
    }
}