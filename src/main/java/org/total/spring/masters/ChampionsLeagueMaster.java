package org.total.spring.masters;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.total.spring.dao.ResultDAO;
import org.total.spring.entity.Result;
import org.total.spring.entity.enums.SeasonCode;
import org.total.spring.entity.enums.TournamentCode;
import org.total.spring.finder.DataFinder;

import java.util.List;
import java.util.TreeSet;

/**
 * Created by pavlo.fandych on 12/9/2016.
 */

@Component("championsLeagueMaster")
public final class ChampionsLeagueMaster implements Master {
    private static final Logger LOGGER = Logger.getLogger(ChampionsLeagueMaster.class);

    @Autowired
    private ResultDAO resultDAO;

    @Autowired
    private DataFinder dataFinderChampionsLeague;

    public DataFinder getDataFinderChampionsLeague() {
        return dataFinderChampionsLeague;
    }

    public void setDataFinderChampionsLeague(DataFinder dataFinderChampionsLeague) {
        this.dataFinderChampionsLeague = dataFinderChampionsLeague;
    }

    public ResultDAO getResultDAO() {
        return resultDAO;
    }

    public void setResultDAO(ResultDAO resultDAO) {
        this.resultDAO = resultDAO;
    }

    @Override
    public void populateResults() {
        TreeSet<Result> savedResults = getResultDAO()
                .results();
        for (Result item : getDataFinderChampionsLeague().findResults()) {
            if (!savedResults.contains(item)) {
                getResultDAO().insertResult(item);
            }
        }
    }

    public void populateResults(final SeasonCode seasonCode) {
        TreeSet<Result> savedResults = getResultDAO()
                .findResultsBySeasonCodeAndTournamentCode(seasonCode, TournamentCode.CHAMPIONS_LEAGUE);
        for (Result item : getDataFinderChampionsLeague().findResults()) {
            if (!savedResults.contains(item)) {
                getResultDAO().insertResult(item);
            }
        }
    }
}