package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pavlo.fandych on 11/24/2016.
 */

@Repository("italianTeamDAO")
public class ItalianTeamDAO extends GenericDAO {
    private static final Map<String, Long> ITALY_TEAMS_MAPPING = new HashMap<>();

    static {
        ITALY_TEAMS_MAPPING.put("AS Roma", 336L);
        ITALY_TEAMS_MAPPING.put("Udinese Calcio", 373L);
        ITALY_TEAMS_MAPPING.put("Juventus Turin", 308L);
        ITALY_TEAMS_MAPPING.put("ACF Fiorentina", 327L);
        ITALY_TEAMS_MAPPING.put("AC Milan", 297L);
        ITALY_TEAMS_MAPPING.put("Torino FC", 377L);
        ITALY_TEAMS_MAPPING.put("Genoa CFC", 288L);
        ITALY_TEAMS_MAPPING.put("Cagliari Calcio", 340L);
        ITALY_TEAMS_MAPPING.put("Atalanta BC", 302L);
        ITALY_TEAMS_MAPPING.put("SS Lazio", 298L);
        ITALY_TEAMS_MAPPING.put("Bologna FC", 305L);
        ITALY_TEAMS_MAPPING.put("FC Crotone", 294L);
        ITALY_TEAMS_MAPPING.put("AC Chievo Verona", 366L);
        ITALY_TEAMS_MAPPING.put("FC Internazionale Milano", 360L);
        ITALY_TEAMS_MAPPING.put("Empoli FC", 324L);
        ITALY_TEAMS_MAPPING.put("UC Sampdoria", 374L);
        ITALY_TEAMS_MAPPING.put("US Cittá di Palermo", 334L);
        ITALY_TEAMS_MAPPING.put("US Sassuolo Calcio", 371L);
        ITALY_TEAMS_MAPPING.put("Pescara Calcio", 353L);
        ITALY_TEAMS_MAPPING.put("SSC Napoli", 343L);
    }

    public Team findByTeamName(String teamName) {
        return findTeam(teamName, ITALY_TEAMS_MAPPING);
    }
}