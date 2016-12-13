package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by total on 12/13/16.
 */

@Repository("denmarkTeamDAO")
public final class DenmarkTeamDAO extends GenericDAO {
    private static final Map<String, String> DENMARK_TEAMS_MAPPING = new HashMap<>();

    static {
        DENMARK_TEAMS_MAPPING.put("FC Copenhagen", "DNK001");
    }

    public static Map<String, String> getDenmarkTeamsMapping() {
        return DENMARK_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, DENMARK_TEAMS_MAPPING);
    }
}