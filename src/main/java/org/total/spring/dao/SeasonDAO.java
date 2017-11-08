package org.total.spring.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.total.spring.entity.Season;
import org.total.spring.entity.enums.SeasonCode;
import org.total.spring.util.Constants;

import java.util.List;
import java.util.Map;

/**
 * @author Pavlo.Fandych
 */

@Repository("seasonDAO")
public final class SeasonDAO extends GenericDAO {

    public List<Season> seasons() {
        final SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(getJdbcTemplate())
                .withProcedureName(Constants.CALL_GET_SEASON_LIST).returningResultSet("seasons", (resultSet, i) -> {
                    final Season season = new Season();
                    season.setSeasonId(resultSet.getLong("seasonId"));
                    season.setSeasonCode(SeasonCode.valueOf(resultSet.getString("seasonCode")));
                    season.setSeasonName(resultSet.getString("seasonName"));

                    return season;
                });

        final Map<String, Object> out = simpleJdbcCall.execute();

        final List<Season> resultList = (List<Season>) out.get("seasons");

        return (resultList != null && !resultList.isEmpty()) ? resultList : null;
    }

    public Season fetchSeasonBySeasonCode(final String seasonCode) {
        return getJdbcTemplate().queryForObject(Constants.FETCH_SEASON_BY_SEASON_CODE, (resultSet, i) -> {
            final Season season = new Season();
            season.setSeasonId(resultSet.getLong("seasonId"));
            season.setSeasonCode(SeasonCode.valueOf(resultSet.getString("seasonCode")));
            season.setSeasonName(resultSet.getString("seasonName"));

            return season;
        }, seasonCode);
    }
}
