package org.total.spring.masters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.total.spring.dao.CachedStandingsDAO;
import org.total.spring.util.SeasonMapper;

import java.util.Date;

/**
 * Created by pavlo.fandych on 12/1/2016.
 */

@Component("cachedStandingsMaster")
public class CachedStandingsMaster implements Master {
    @Autowired
    private CachedStandingsDAO cachedStandingsDAO;

    @Autowired
    private SeasonMapper seasonMapper;

    public CachedStandingsDAO getCachedStandingsDAO() {
        return cachedStandingsDAO;
    }

    public void setCachedStandingsDAO(CachedStandingsDAO cachedStandingsDAO) {
        this.cachedStandingsDAO = cachedStandingsDAO;
    }

    public SeasonMapper getSeasonMapper() {
        return seasonMapper;
    }

    public void setSeasonMapper(SeasonMapper seasonMapper) {
        this.seasonMapper = seasonMapper;
    }

    @Override
    public void populateResults() {
        /*code here*/
    }

    public void populateResults(String tournamentCode) {
        /*current season*/
        System.out.println(getSeasonMapper().mapSeason(new Date()));
    }

    public void populateResults(String seasonCode, String tournamentCode) {
        getCachedStandingsDAO().saveStandings(seasonCode, tournamentCode);
    }
}