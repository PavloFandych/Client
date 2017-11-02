package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by total on 12/13/16.
 */

@Repository("belgiumTeamDAO")
public final class BelgiumTeamDAO extends GenericDAO {

    private static final Map<String, String> BELGIUM_TEAMS_MAPPING = new HashMap<>();

    static {
        BELGIUM_TEAMS_MAPPING.put("Club Brugge", "BEL001");
    }

    public static Map<String, String> getBelgiumTeamsMapping() {
        return BELGIUM_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, BELGIUM_TEAMS_MAPPING);
    }
}