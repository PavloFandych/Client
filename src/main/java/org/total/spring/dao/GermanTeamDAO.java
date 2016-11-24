package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

@Repository("germanTeamDAO")
public class GermanTeamDAO extends GenericDAO {
    private static final Map<String, Long> GERMANY_TEAMS_MAPPING = new HashMap<>();

    static {
        GERMANY_TEAMS_MAPPING.put("FC Bayern München", 181L);
        GERMANY_TEAMS_MAPPING.put("Werder Bremen", 153L);
        GERMANY_TEAMS_MAPPING.put("FC Augsburg", 268L);
        GERMANY_TEAMS_MAPPING.put("VfL Wolfsburg", 116L);
        GERMANY_TEAMS_MAPPING.put("1. FC Köln", 156L);
        GERMANY_TEAMS_MAPPING.put("SV Darmstadt 98", 127L);
        GERMANY_TEAMS_MAPPING.put("Borussia Dortmund", 272L);
        GERMANY_TEAMS_MAPPING.put("1. FSV Mainz 05", 111L);
        GERMANY_TEAMS_MAPPING.put("Hamburger SV", 274L);
        GERMANY_TEAMS_MAPPING.put("FC Ingolstadt 04", 205L);
        GERMANY_TEAMS_MAPPING.put("Eintracht Frankfurt", 135L);
        GERMANY_TEAMS_MAPPING.put("FC Schalke 04", 138L);
        GERMANY_TEAMS_MAPPING.put("Bor. Mönchengladbach", 209L);
        GERMANY_TEAMS_MAPPING.put("Bayer Leverkusen", 75L);
        GERMANY_TEAMS_MAPPING.put("Hertha BSC", 91L);
        GERMANY_TEAMS_MAPPING.put("SC Freiburg", 107L);
        GERMANY_TEAMS_MAPPING.put("TSG 1899 Hoffenheim", 219L);
        GERMANY_TEAMS_MAPPING.put("Red Bull Leipzig", 204L);
        GERMANY_TEAMS_MAPPING.put("OSV Hannover", 259L);
        GERMANY_TEAMS_MAPPING.put("VfB Stuttgart", 263L);
    }

    public Team findByTeamName(String teamName) {
        return findTeam(teamName, GERMANY_TEAMS_MAPPING);
    }
}