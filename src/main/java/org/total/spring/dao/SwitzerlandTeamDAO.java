package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavlo.Fandych
 */

@Repository("switzerlandTeamDAO")
public final class SwitzerlandTeamDAO extends GenericDAO {

    private static final Map<String, String> SWITZERLAND_TEAMS_MAPPING = new HashMap<>();

    static {
        SWITZERLAND_TEAMS_MAPPING.put("FC Basel", "CHE001");
    }

    public static Map<String, String> getSwitzerlandTeamsMapping() {
        return SWITZERLAND_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, SWITZERLAND_TEAMS_MAPPING);
    }
}
