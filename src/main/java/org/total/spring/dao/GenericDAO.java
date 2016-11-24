package org.total.spring.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.total.spring.entity.Team;
import org.total.spring.util.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public abstract class GenericDAO {
    protected static final Logger LOGGER = Logger.getLogger(GenericDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    protected Team findTeam(final String teamName, final Map<String, Long> mapping) {
        if (mapping.containsKey(teamName)) {
            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(getJdbcTemplate())
                    .withProcedureName(Constants.CALL_FETCH_TEAM_BY_TEAM_ID)
                    .returningResultSet("team", new RowMapper<Team>() {
                        @Override
                        public Team mapRow(ResultSet resultSet, int i) throws SQLException {
                            Team team = new Team();
                            team.setTeamId(resultSet.getLong("teamId"));
                            team.setTeamCode(resultSet.getString("teamCode"));
                            team.setTeamName(resultSet.getString("teamName"));
                            team.setCityId(resultSet.getLong("cityId"));
                            return team;
                        }
                    });

            Map<String, Object> out = simpleJdbcCall
                    .execute(new MapSqlParameterSource()
                            .addValue("teamId", mapping.get(teamName)));

            return ((List<Team>) out.get("team")).get(0);
        }
        return null;
    }
}