package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavlo.Fandych
 */

@Repository("italianTeamDAO")
public final class ItalianTeamDAO extends GenericDAO {

    private static final Map<String, String> ITALY_TEAMS_MAPPING = new HashMap<>();

    static {
        ITALY_TEAMS_MAPPING.put("AS Roma", "ITA055");
        ITALY_TEAMS_MAPPING.put("Udinese Calcio", "ITA092");
        ITALY_TEAMS_MAPPING.put("Juventus Turin", "ITA027");
        ITALY_TEAMS_MAPPING.put("ACF Fiorentina", "ITA046");
        ITALY_TEAMS_MAPPING.put("AC Milan", "ITA016");
        ITALY_TEAMS_MAPPING.put("Torino FC", "ITA096");
        ITALY_TEAMS_MAPPING.put("Genoa CFC", "ITA007");
        ITALY_TEAMS_MAPPING.put("Cagliari Calcio", "ITA059");
        ITALY_TEAMS_MAPPING.put("Atalanta BC", "ITA021");
        ITALY_TEAMS_MAPPING.put("SS Lazio", "ITA017");
        ITALY_TEAMS_MAPPING.put("Bologna FC", "ITA024");
        ITALY_TEAMS_MAPPING.put("FC Crotone", "ITA013");
        ITALY_TEAMS_MAPPING.put("AC Chievo Verona", "ITA085");
        ITALY_TEAMS_MAPPING.put("FC Internazionale Milano", "ITA079");
        ITALY_TEAMS_MAPPING.put("Empoli FC", "ITA043");
        ITALY_TEAMS_MAPPING.put("UC Sampdoria", "ITA093");
        ITALY_TEAMS_MAPPING.put("US Cittá di Palermo", "ITA053");
        ITALY_TEAMS_MAPPING.put("US Sassuolo Calcio", "ITA090");
        ITALY_TEAMS_MAPPING.put("Pescara Calcio", "ITA072");
        ITALY_TEAMS_MAPPING.put("SSC Napoli", "ITA062");
        ITALY_TEAMS_MAPPING.put("Hellas Verona FC", "ITA047");
        ITALY_TEAMS_MAPPING.put("SPAL Ferrara", "ITA037");
        ITALY_TEAMS_MAPPING.put("Benevento Calcio", "ITA015");
    }

    public static Map<String, String> getItalyTeamsMapping() {
        return ITALY_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, ITALY_TEAMS_MAPPING);
    }
}