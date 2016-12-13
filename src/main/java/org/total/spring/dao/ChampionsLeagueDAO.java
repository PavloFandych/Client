package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pavlo.fandych on 12/9/2016.
 */

@Repository("championsLeagueDAO")
public final class ChampionsLeagueDAO extends GenericDAO {
    private static final Map<String, String> CHAMPIONS_LEAGUE_TEAMS_MAPPING = new HashMap<>();

    static {
        for (Map.Entry<String, String> entry : EnglishTeamDAO.getEnglandTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : FrenchTeamDAO.getFranceTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : GermanTeamDAO.getGermanyTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : ItalianTeamDAO.getItalyTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : SpanishTeamDAO.getSpainTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : DutchTeamDAO.getNetherlandsTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, CHAMPIONS_LEAGUE_TEAMS_MAPPING);
    }
}