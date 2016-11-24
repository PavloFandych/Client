package org.total.spring.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.total.spring.entity.Result;
import org.total.spring.util.Constants;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Repository("resultDAO")
public class ResultDAO extends GenericDAO {
    public List<Result> results() {
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

        return (List<Result>) out.get("results");
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