package org.total.spring.masters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.total.spring.dao.CachedTeamsListDAO;

/**
 * @author Pavlo.Fandych
 */

@Component("cachedTeamsListMaster")
public class CachedTeamsListMaster implements Master {

    @Autowired
    private CachedTeamsListDAO cachedTeamsListDAO;

    public CachedTeamsListDAO getCachedTeamsListDAO() {
        return cachedTeamsListDAO;
    }

    public void setCachedTeamsListDAO(CachedTeamsListDAO cachedTeamsListDAO) {
        this.cachedTeamsListDAO = cachedTeamsListDAO;
    }

    @Override
    public void populateResults() {
        /*code here*/
    }

    public void populateResults(final String seasonCode, final String tournamentCode) {
        getCachedTeamsListDAO().saveTeamsList(seasonCode, tournamentCode);
    }
}