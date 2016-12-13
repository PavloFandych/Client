package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by total on 12/13/16.
 */

@Repository("scotlandTeamDAO")
public final class ScotlandTeamDAO extends GenericDAO {
    private static final Map<String, String> SCOTLAND_TEAMS_MAPPING = new HashMap<>();

    static {
        SCOTLAND_TEAMS_MAPPING.put("Celtic FC", "SCT001");
    }

    public static Map<String, String> getScotlandTeamsMapping() {
        return SCOTLAND_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, SCOTLAND_TEAMS_MAPPING);
    }
}
