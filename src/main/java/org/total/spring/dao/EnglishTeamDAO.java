package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pavlo.fandych on 11/24/2016.
 */

@Repository("englishTeamDAO")
public class EnglishTeamDAO extends GenericDAO {
    private static final Map<String, String> ENGLAND_TEAMS_MAPPING = new HashMap<>();

    static {
        ENGLAND_TEAMS_MAPPING.put("Hull City FC", "ENG021");
        ENGLAND_TEAMS_MAPPING.put("Leicester City FC", "ENG037");
        ENGLAND_TEAMS_MAPPING.put("Burnley FC", "ENG002");
        ENGLAND_TEAMS_MAPPING.put("Swansea City FC", "ENG013");
        ENGLAND_TEAMS_MAPPING.put("Crystal Palace FC", "ENG039");
        ENGLAND_TEAMS_MAPPING.put("West Bromwich Albion FC", "ENG022");
        ENGLAND_TEAMS_MAPPING.put("Everton FC", "ENG029");
        ENGLAND_TEAMS_MAPPING.put("Tottenham Hotspur FC", "ENG011");
        ENGLAND_TEAMS_MAPPING.put("Middlesbrough FC", "ENG016");
        ENGLAND_TEAMS_MAPPING.put("Stoke City FC", "ENG019");
        ENGLAND_TEAMS_MAPPING.put("Southampton FC", "ENG034");
        ENGLAND_TEAMS_MAPPING.put("Watford FC", "ENG031");
        ENGLAND_TEAMS_MAPPING.put("Manchester City FC", "ENG042");
        ENGLAND_TEAMS_MAPPING.put("Sunderland AFC", "ENG027");
        ENGLAND_TEAMS_MAPPING.put("AFC Bournemouth", "ENG003");
        ENGLAND_TEAMS_MAPPING.put("Manchester United FC", "ENG015");
        ENGLAND_TEAMS_MAPPING.put("Arsenal FC", "ENG020");
        ENGLAND_TEAMS_MAPPING.put("Liverpool FC", "ENG030");
        ENGLAND_TEAMS_MAPPING.put("Chelsea FC", "ENG040");
        ENGLAND_TEAMS_MAPPING.put("West Ham United FC", "ENG014");
    }

    public Team findByTeamName(String teamName) {
        return findTeam(teamName, ENGLAND_TEAMS_MAPPING);
    }
}
