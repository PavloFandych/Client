package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by total on 12/13/16.
 */

@Repository("croatianTeamDAO")
public final class CroatianTeamDAO extends GenericDAO {
    private static final Map<String, String> CROATIA_TEAMS_MAPPING = new HashMap<>();

    static {
        CROATIA_TEAMS_MAPPING.put("GNK Dinamo Zagreb", "HRV001");
    }

    public static Map<String, String> getCroatiaTeamsMapping() {
        return CROATIA_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, CROATIA_TEAMS_MAPPING);
    }
}