package org.total.spring.dao;

import org.springframework.stereotype.Repository;
import org.total.spring.entity.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pavlo.fandych on 12/13/2016.
 */

@Repository("portugalTeamDAO")
public final class PortugalTeamDAO extends GenericDAO {

    private static final Map<String, String> PORTUGAL_TEAMS_MAPPING = new HashMap<>();

    static {
        PORTUGAL_TEAMS_MAPPING.put("FC Rio Ave", "PRT006");
        PORTUGAL_TEAMS_MAPPING.put("FC Porto", "PRT002");
        PORTUGAL_TEAMS_MAPPING.put("Moreirense FC", "PRT016");
        PORTUGAL_TEAMS_MAPPING.put("FC Paços de Ferreira", "PRT013");
        PORTUGAL_TEAMS_MAPPING.put("Sporting CP", "PRT003");
        PORTUGAL_TEAMS_MAPPING.put("Maritimo Funchal", "PRT009");
        PORTUGAL_TEAMS_MAPPING.put("CD Tondela", "PRT018");
        PORTUGAL_TEAMS_MAPPING.put("SL Benfica", "PRT001");
        PORTUGAL_TEAMS_MAPPING.put("Boavista Porto FC", "PRT014");
        PORTUGAL_TEAMS_MAPPING.put("FC Arouca", "PRT012");
        PORTUGAL_TEAMS_MAPPING.put("Vitoria Setubal", "PRT010");
        PORTUGAL_TEAMS_MAPPING.put("C.F. Os Belenenses", "PRT008");
        PORTUGAL_TEAMS_MAPPING.put("Vitoria Guimaraes", "PRT005");
        PORTUGAL_TEAMS_MAPPING.put("Sporting Braga", "PRT004");
        PORTUGAL_TEAMS_MAPPING.put("GD Estoril Praia", "PRT011");
        PORTUGAL_TEAMS_MAPPING.put("Feirense", "PRT017");
        PORTUGAL_TEAMS_MAPPING.put("G.D. Chaves", "PRT007");
        PORTUGAL_TEAMS_MAPPING.put("Nacional Funchal", "PRT015");
    }

    public static Map<String, String> getPortugalTeamsMapping() {
        return PORTUGAL_TEAMS_MAPPING;
    }

    public Team findByTeamName(final String teamName) {
        return findTeam(teamName, PORTUGAL_TEAMS_MAPPING);
    }
}