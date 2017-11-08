package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavlo.Fandych
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

        for (Map.Entry<String, String> entry : PortugalTeamDAO.getPortugalTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : SwitzerlandTeamDAO.getSwitzerlandTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : BulgarianTeamDAO.getBulgariaTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : TurkeyTeamDAO.getTurkeyTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : ScotlandTeamDAO.getScotlandTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : UkrainianTeamDAO.getUkraineTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : RussianTeamDAO.getRussiaTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : CroatianTeamDAO.getCroatiaTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : BelgiumTeamDAO.getBelgiumTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : DenmarkTeamDAO.getDenmarkTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : PolandTeamDAO.getPolandTeamsMapping().entrySet()) {
            CHAMPIONS_LEAGUE_TEAMS_MAPPING.put(entry.getKey(), entry.getValue());
        }
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, CHAMPIONS_LEAGUE_TEAMS_MAPPING);
    }
}