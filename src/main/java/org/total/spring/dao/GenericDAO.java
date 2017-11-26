package org.total.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.total.spring.entity.Team;
import org.total.spring.util.Constants;

import java.util.List;
import java.util.Map;

/**
 * @author Pavlo.Fandych
 */

public abstract class GenericDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    protected Team findTeam(final String teamName, final Map<String, String> mapping) {
        if (mapping.containsKey(teamName)) {
            final SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(getJdbcTemplate())
                    .withProcedureName(Constants.CALL_FETCH_TEAM_BY_TEAM_CODE).returningResultSet("team", (resultSet, i) -> {
                        final Team team = new Team();
                        team.setTeamId(resultSet.getLong("teamId"));
                        team.setTeamCode(resultSet.getString("teamCode"));
                        team.setTeamName(resultSet.getString("teamName"));
                        team.setCityId(resultSet.getLong("cityId"));

                        return team;
                    });

            final List<Team> resultList = (List<Team>) simpleJdbcCall
                    .execute(new MapSqlParameterSource().addValue("teamCode", mapping.get(teamName))).get("team");

            return (resultList != null && !resultList.isEmpty()) ? resultList.get(0) : null;
        }
        return null;
    }
}