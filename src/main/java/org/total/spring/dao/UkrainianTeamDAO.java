package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by total on 12/13/16.
 */

@Repository("ukrainianTeamDAO")
public final class UkrainianTeamDAO extends GenericDAO {
    private static final Map<String, String> UKRAINE_TEAMS_MAPPING = new HashMap<>();

    static {
        UKRAINE_TEAMS_MAPPING.put("Dynamo Kyiv", "UKR001");
    }

    public static Map<String, String> getUkraineTeamsMapping() {
        return UKRAINE_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, UKRAINE_TEAMS_MAPPING);
    }
}
