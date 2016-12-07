package org.total.spring.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.total.spring.entity.Season;
import org.total.spring.entity.enums.SeasonCode;
import org.total.spring.util.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by total on 11/23/16.
 */

@Repository("seasonDAO")
public final class SeasonDAO extends GenericDAO {
    public List<Season> seasons() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(getJdbcTemplate())
                .withProcedureName(Constants.CALL_GET_SEASON_LIST)
                .returningResultSet("seasons", new RowMapper<Season>() {
                    @Override
                    public Season mapRow(ResultSet resultSet, int i) throws SQLException {
                        Season season = new Season();
                        season.setSeasonId(resultSet.getLong("seasonId"));
                        season.setSeasonCode(SeasonCode.valueOf(resultSet.getString("seasonCode")));
                        season.setSeasonName(resultSet.getString("seasonName"));
                        return season;
                    }
                });

        Map<String, Object> out = simpleJdbcCall
                .execute();

        List<Season> resultList = (List<Season>) out.get("seasons");

        return (resultList != null && !resultList.isEmpty()) ? resultList : null;
    }

    public Season fetchSeasonBySeasonCode(final String seasonCode) {
        Season result = getJdbcTemplate()
                .queryForObject(Constants.FETCH_SEASON_BY_SEASON_CODE,
                        new RowMapper<Season>() {
                            @Override
                            public Season mapRow(ResultSet resultSet, int i) throws SQLException {
                                Season season = new Season();
                                season.setSeasonId(resultSet.getLong("seasonId"));
                                season.setSeasonCode(SeasonCode.valueOf(resultSet
                                        .getString("seasonCode")));
                                season.setSeasonName(resultSet.getString("seasonName"));
                                return season;
                            }
                        }, seasonCode);
        return (result != null) ? result : null;
    }
}
