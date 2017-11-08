package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavlo.Fandych
 */

@Repository("polandTeamDAO")
public final class PolandTeamDAO extends GenericDAO {

    private static final Map<String, String> POLAND_TEAMS_MAPPING = new HashMap<>();

    static {
        POLAND_TEAMS_MAPPING.put("Legia Warszawa", "POL001");
    }

    public static Map<String, String> getPolandTeamsMapping() {
        return POLAND_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, POLAND_TEAMS_MAPPING);
    }
}