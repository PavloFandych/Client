package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavlo.Fandych
 */

@Repository("turkeyTeamDAO")
public final class TurkeyTeamDAO extends GenericDAO {

    private static final Map<String, String> TURKEY_TEAMS_MAPPING = new HashMap<>();

    static {
        TURKEY_TEAMS_MAPPING.put("Besiktas JK", "TUR001");
    }

    public static Map<String, String> getTurkeyTeamsMapping() {
        return TURKEY_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, TURKEY_TEAMS_MAPPING);
    }
}