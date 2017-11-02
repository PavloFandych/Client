package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pavlo.fandych on 11/29/2016.
 */

@Repository("frenchTeamDAO")
public final class FrenchTeamDAO extends GenericDAO {

    private static final Map<String, String> FRANCE_TEAMS_MAPPING = new HashMap<>();

    static {
        FRANCE_TEAMS_MAPPING.put("SC Bastia", "FRA036");
        FRANCE_TEAMS_MAPPING.put("Paris Saint-Germain", "FRA017");
        FRANCE_TEAMS_MAPPING.put("AS Monaco FC", "FRA012");
        FRANCE_TEAMS_MAPPING.put("EA Guingamp", "FRA022");
        FRANCE_TEAMS_MAPPING.put("FC Girondins de Bordeaux", "FRA002");
        FRANCE_TEAMS_MAPPING.put("AS Saint-Étienne", "FRA039");
        FRANCE_TEAMS_MAPPING.put("SM Caen", "FRA037");
        FRANCE_TEAMS_MAPPING.put("FC Lorient", "FRA027");
        FRANCE_TEAMS_MAPPING.put("Dijon FCO", "FRA028");
        FRANCE_TEAMS_MAPPING.put("FC Nantes", "FRA020");
        FRANCE_TEAMS_MAPPING.put("FC Metz", "FRA014");
        FRANCE_TEAMS_MAPPING.put("OSC Lille", "FRA007");
        FRANCE_TEAMS_MAPPING.put("Montpellier Hérault SC", "FRA030");
        FRANCE_TEAMS_MAPPING.put("Angers SCO", "FRA003");
        FRANCE_TEAMS_MAPPING.put("AS Nancy", "FRA008");
        FRANCE_TEAMS_MAPPING.put("Olympique Lyonnais", "FRA024");
        FRANCE_TEAMS_MAPPING.put("OGC Nice", "FRA013");
        FRANCE_TEAMS_MAPPING.put("Stade Rennais FC", "FRA033");
        FRANCE_TEAMS_MAPPING.put("Olympique de Marseille", "FRA005");
        FRANCE_TEAMS_MAPPING.put("Toulouse FC", "FRA026");
    }

    public static Map<String, String> getFranceTeamsMapping() {
        return FRANCE_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, FRANCE_TEAMS_MAPPING);
    }
}