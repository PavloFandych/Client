package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavlo.Fandych
 */

@Repository("germanTeamDAO")
public final class GermanTeamDAO extends GenericDAO {

    private static final Map<String, String> GERMANY_TEAMS_MAPPING = new HashMap<>();

    static {
        GERMANY_TEAMS_MAPPING.put("FC Bayern München", "DEU137");
        GERMANY_TEAMS_MAPPING.put("Werder Bremen", "DEU109");
        GERMANY_TEAMS_MAPPING.put("FC Augsburg", "DEU224");
        GERMANY_TEAMS_MAPPING.put("VfL Wolfsburg", "DEU072");
        GERMANY_TEAMS_MAPPING.put("1. FC Köln", "DEU112");
        GERMANY_TEAMS_MAPPING.put("SV Darmstadt 98", "DEU083");
        GERMANY_TEAMS_MAPPING.put("Borussia Dortmund", "DEU228");
        GERMANY_TEAMS_MAPPING.put("1. FSV Mainz 05", "DEU067");
        GERMANY_TEAMS_MAPPING.put("Hamburger SV", "DEU230");
        GERMANY_TEAMS_MAPPING.put("FC Ingolstadt 04", "DEU161");
        GERMANY_TEAMS_MAPPING.put("Eintracht Frankfurt", "DEU091");
        GERMANY_TEAMS_MAPPING.put("FC Schalke 04", "DEU094");
        GERMANY_TEAMS_MAPPING.put("Bor. Mönchengladbach", "DEU165");
        GERMANY_TEAMS_MAPPING.put("Bayer Leverkusen", "DEU031");
        GERMANY_TEAMS_MAPPING.put("Hertha BSC", "DEU047");
        GERMANY_TEAMS_MAPPING.put("SC Freiburg", "DEU063");
        GERMANY_TEAMS_MAPPING.put("TSG 1899 Hoffenheim", "DEU175");
        GERMANY_TEAMS_MAPPING.put("Red Bull Leipzig", "DEU160");
        GERMANY_TEAMS_MAPPING.put("OSV Hannover", "DEU215");
        GERMANY_TEAMS_MAPPING.put("VfB Stuttgart", "DEU219");
        GERMANY_TEAMS_MAPPING.put("Hannover 96", "DEU058");
    }

    public static Map<String, String> getGermanyTeamsMapping() {
        return GERMANY_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, GERMANY_TEAMS_MAPPING);
    }
}