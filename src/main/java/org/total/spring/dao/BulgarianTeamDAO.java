package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by total on 12/13/16.
 */

@Repository("bulgarianTeamDAO")
public final class BulgarianTeamDAO extends GenericDAO {

    private static final Map<String, String> BULGARIA_TEAMS_MAPPING = new HashMap<>();

    static {
        BULGARIA_TEAMS_MAPPING.put("Ludogorez Rasgrad", "BGR001");
    }

    public static Map<String, String> getBulgariaTeamsMapping() {
        return BULGARIA_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, BULGARIA_TEAMS_MAPPING);
    }
}
