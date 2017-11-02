package org.total.spring.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.total.spring.entity.Tournament;
import org.total.spring.entity.enums.TournamentCode;
import org.total.spring.entity.enums.TournamentType;
import org.total.spring.util.Constants;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * Created by total on 12/1/16.
 */

@Repository("TournamentDAO")
public final class TournamentDAO extends GenericDAO {

    public List<Tournament> tournaments() {
        final SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(getJdbcTemplate())
                .withProcedureName(Constants.CALL_GET_TOURNAMENT_LIST)
                .returningResultSet("tournaments", (ResultSet resultSet, int i) -> {
                    final Tournament tournament = new Tournament();
                    tournament.setTournamentId(resultSet.getLong("tournamentId"));
                    tournament.setTournamentCode(TournamentCode.valueOf(resultSet.getString("tournamentCode")));
                    tournament.setTournamentName(resultSet.getString("tournamentName"));
                    tournament.setTournamentType(TournamentType.valueOf(resultSet.getString("tournamentType")));
                    tournament.setCountryId(resultSet.getLong("countryId"));

                    return tournament;
                });

        final Map<String, Object> out = simpleJdbcCall.execute();

        final List<Tournament> resultList = (List<Tournament>) out.get("tournaments");

        return (resultList != null && !resultList.isEmpty()) ? resultList : null;
    }

    public Tournament fetchTournamentByTournamentCode(final String tournamentCode) {
        return getJdbcTemplate().queryForObject(Constants.FETCH_TOURNAMENT_BY_TOURNAMENT_CODE, (ResultSet resultSet, int i) -> {
            final Tournament tournament = new Tournament();
            tournament.setTournamentId(resultSet.getLong("tournamentId"));
            tournament.setTournamentCode(TournamentCode.valueOf(resultSet.getString("tournamentCode")));
            tournament.setTournamentName(resultSet.getString("tournamentName"));
            tournament.setTournamentType(TournamentType.valueOf(resultSet.getString("tournamentType")));
            tournament.setCountryId(resultSet.getLong("countryId"));

            return tournament;
        }, tournamentCode);
    }
}