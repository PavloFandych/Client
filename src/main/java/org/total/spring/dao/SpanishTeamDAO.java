package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavlo.Fandych
 */

@Repository("spanishTeamDAO")
public final class SpanishTeamDAO extends GenericDAO {

    private static final Map<String, String> SPAIN_TEAMS_MAPPING = new HashMap<>();

    static {
        SPAIN_TEAMS_MAPPING.put("Málaga CF", "ESP038");
        SPAIN_TEAMS_MAPPING.put("CA Osasuna", "ESP026");
        SPAIN_TEAMS_MAPPING.put("RC Deportivo La Coruna", "ESP025");
        SPAIN_TEAMS_MAPPING.put("SD Eibar", "ESP032");
        SPAIN_TEAMS_MAPPING.put("FC Barcelona", "ESP027");
        SPAIN_TEAMS_MAPPING.put("Real Betis", "ESP020");
        SPAIN_TEAMS_MAPPING.put("Granada CF", "ESP009");
        SPAIN_TEAMS_MAPPING.put("Villarreal CF", "ESP041");
        SPAIN_TEAMS_MAPPING.put("Sevilla FC", "ESP033");
        SPAIN_TEAMS_MAPPING.put("RCD Espanyol", "ESP024");
        SPAIN_TEAMS_MAPPING.put("Sporting Gijón", "ESP030");
        SPAIN_TEAMS_MAPPING.put("Athletic Club", "ESP037");
        SPAIN_TEAMS_MAPPING.put("Real Sociedad de Fútbol", "ESP040");
        SPAIN_TEAMS_MAPPING.put("Real Madrid CF", "ESP018");
        SPAIN_TEAMS_MAPPING.put("Club Atlético de Madrid", "ESP039");
        SPAIN_TEAMS_MAPPING.put("Deportivo Alavés", "ESP023");
        SPAIN_TEAMS_MAPPING.put("RC Celta de Vigo", "ESP022");
        SPAIN_TEAMS_MAPPING.put("CD Leganes", "ESP008");
        SPAIN_TEAMS_MAPPING.put("Valencia CF", "ESP042");
        SPAIN_TEAMS_MAPPING.put("UD Las Palmas", "ESP014");
    }

    public static Map<String, String> getSpainTeamsMapping() {
        return SPAIN_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, SPAIN_TEAMS_MAPPING);
    }
}