package org.total.spring.masters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.total.spring.dao.CachedStandingsDAO;

/**
 * Created by pavlo.fandych on 12/1/2016.
 */

@Component("cachedStandingsMaster")
public final class CachedStandingsMaster implements Master {
    @Autowired
    private CachedStandingsDAO cachedStandingsDAO;

    public CachedStandingsDAO getCachedStandingsDAO() {
        return cachedStandingsDAO;
    }

    public void setCachedStandingsDAO(CachedStandingsDAO cachedStandingsDAO) {
        this.cachedStandingsDAO = cachedStandingsDAO;
    }

    @Override
    public void populateResults() {
        /*code here*/
    }

    public void populateResults(final String seasonCode,
                                final String tournamentCode) {
        getCachedStandingsDAO().saveStandings(seasonCode, tournamentCode);
    }
}