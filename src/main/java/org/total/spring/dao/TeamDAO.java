package org.total.spring.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;
import org.total.spring.util.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("teamDAO")
public class TeamDAO extends GenericDAO<Team> {
    private static final Map<String, Long> GERMANY_TEAMS_MAPPING = new HashMap<>();

    static {
        GERMANY_TEAMS_MAPPING.put("FC Bayern München", 181L);
        GERMANY_TEAMS_MAPPING.put("Werder Bremen", 153L);
        GERMANY_TEAMS_MAPPING.put("FC Augsburg", 268L);
        GERMANY_TEAMS_MAPPING.put("VfL Wolfsburg", 116L);
        GERMANY_TEAMS_MAPPING.put("1. FC Köln", 156L);
        GERMANY_TEAMS_MAPPING.put("SV Darmstadt 98", 127L);
        GERMANY_TEAMS_MAPPING.put("Borussia Dortmund", 272L);
        GERMANY_TEAMS_MAPPING.put("1. FSV Mainz 05", 111L);
        GERMANY_TEAMS_MAPPING.put("Hamburger SV", 274L);
        GERMANY_TEAMS_MAPPING.put("FC Ingolstadt 04", 205L);
        GERMANY_TEAMS_MAPPING.put("Eintracht Frankfurt", 135L);
        GERMANY_TEAMS_MAPPING.put("FC Schalke 04", 138L);
        GERMANY_TEAMS_MAPPING.put("Bor. Mönchengladbach", 209L);
        GERMANY_TEAMS_MAPPING.put("Bayer Leverkusen", 75L);
        GERMANY_TEAMS_MAPPING.put("Hertha BSC", 91L);
        GERMANY_TEAMS_MAPPING.put("SC Freiburg", 107L);
        GERMANY_TEAMS_MAPPING.put("TSG 1899 Hoffenheim", 219L);
        GERMANY_TEAMS_MAPPING.put("Red Bull Leipzig", 204L);
        GERMANY_TEAMS_MAPPING.put("OSV Hannover", 259L);
        GERMANY_TEAMS_MAPPING.put("VfB Stuttgart", 263L);
    }

    public Team findByTeamName(String teamName) {
        if (GERMANY_TEAMS_MAPPING.containsKey(teamName)) {
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
                            .addValue("teamId", GERMANY_TEAMS_MAPPING.get(teamName)));

            return ((List<Team>) out.get("team")).get(0);
        }
        return null;
    }
}