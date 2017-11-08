package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavlo.Fandych
 */

@Repository("russianTeamDAO")
public final class RussianTeamDAO extends GenericDAO {

    private static final Map<String, String> RUSSIA_TEAMS_MAPPING = new HashMap<>();

    static {
        RUSSIA_TEAMS_MAPPING.put("FC Rostov", "RUS001");
        RUSSIA_TEAMS_MAPPING.put("CSKA Moscow", "RUS002");
    }

    public static Map<String, String> getRussiaTeamsMapping() {
        return RUSSIA_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, RUSSIA_TEAMS_MAPPING);
    }
}