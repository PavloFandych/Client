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
    private static final Map<String, Long> ENGLAND_TEAMS_MAPPING = new HashMap<>();

    static {
        ENGLAND_TEAMS_MAPPING.put("Hull City FC", 21L);
        ENGLAND_TEAMS_MAPPING.put("Leicester City FC", 37L);
        ENGLAND_TEAMS_MAPPING.put("Burnley FC", 2L);
        ENGLAND_TEAMS_MAPPING.put("Swansea City FC", 13L);
        ENGLAND_TEAMS_MAPPING.put("Crystal Palace FC", 39L);
        ENGLAND_TEAMS_MAPPING.put("West Bromwich Albion FC", 22L);
        ENGLAND_TEAMS_MAPPING.put("Everton FC", 29L);
        ENGLAND_TEAMS_MAPPING.put("Tottenham Hotspur FC", 11L);
        ENGLAND_TEAMS_MAPPING.put("Middlesbrough FC", 16L);
        ENGLAND_TEAMS_MAPPING.put("Stoke City FC", 19L);
        ENGLAND_TEAMS_MAPPING.put("Southampton FC", 34L);
        ENGLAND_TEAMS_MAPPING.put("Watford FC", 31L);
        ENGLAND_TEAMS_MAPPING.put("Manchester City FC", 42L);
        ENGLAND_TEAMS_MAPPING.put("Sunderland AFC", 27L);
        ENGLAND_TEAMS_MAPPING.put("AFC Bournemouth", 3L);
        ENGLAND_TEAMS_MAPPING.put("Manchester United FC", 15L);
        ENGLAND_TEAMS_MAPPING.put("Arsenal FC", 20L);
        ENGLAND_TEAMS_MAPPING.put("Liverpool FC", 30L);
        ENGLAND_TEAMS_MAPPING.put("Chelsea FC", 40L);
        ENGLAND_TEAMS_MAPPING.put("West Ham United FC", 14L);
    }

    public Team findByTeamName(String teamName) {
        return findTeam(teamName, ENGLAND_TEAMS_MAPPING);
    }
}
