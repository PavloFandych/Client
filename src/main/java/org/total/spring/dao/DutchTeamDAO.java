package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pavlo.fandych on 12/13/2016.
 */

@Repository("dutchTeamDAO")
public class DutchTeamDAO extends GenericDAO {
    private static final Map<String, String> NETHERLANDS_TEAMS_MAPPING = new HashMap<>();

    static {
        NETHERLANDS_TEAMS_MAPPING.put("NEC Nijmegen", "NLD011");
        NETHERLANDS_TEAMS_MAPPING.put("PEC Zwolle", "NLD016");
        NETHERLANDS_TEAMS_MAPPING.put("ADO Den Haag", "NLD015");
        NETHERLANDS_TEAMS_MAPPING.put("Go Ahead Eagles Deventer", "NLD018");
        NETHERLANDS_TEAMS_MAPPING.put("FC Twente Enschede", "NLD007");
        NETHERLANDS_TEAMS_MAPPING.put("Excelsior", "NLD014");
        NETHERLANDS_TEAMS_MAPPING.put("FC Utrecht", "NLD006");
        NETHERLANDS_TEAMS_MAPPING.put("PSV Eindhoven", "NLD003");
        NETHERLANDS_TEAMS_MAPPING.put("Willem II Tilburg", "NLD013");
        NETHERLANDS_TEAMS_MAPPING.put("Vitesse Arnhem", "NLD008");
        NETHERLANDS_TEAMS_MAPPING.put("FC Groningen", "NLD009");
        NETHERLANDS_TEAMS_MAPPING.put("Feyenoord Rotterdam", "NLD001");
        NETHERLANDS_TEAMS_MAPPING.put("AZ Alkmaar", "NLD005");
        NETHERLANDS_TEAMS_MAPPING.put("SC Heerenveen", "NLD004");
        NETHERLANDS_TEAMS_MAPPING.put("Sparta Rotterdam", "NLD012");
        NETHERLANDS_TEAMS_MAPPING.put("Ajax Amsterdam", "NLD002");
        NETHERLANDS_TEAMS_MAPPING.put("Roda JC Kerkrade", "NLD017");
        NETHERLANDS_TEAMS_MAPPING.put("Heracles Almelo", "NLD010");
    }

    public static Map<String, String> getNetherlandsTeamsMapping() {
        return NETHERLANDS_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, NETHERLANDS_TEAMS_MAPPING);
    }
}