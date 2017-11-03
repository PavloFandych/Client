package org.total.spring.masters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.total.spring.dao.ResultDAO;
import org.total.spring.entity.Result;
import org.total.spring.entity.enums.SeasonCode;
import org.total.spring.entity.enums.TournamentCode;
import org.total.spring.finder.DataFinder;

import java.util.SortedSet;

/**
 * Created by pavlo.fandych on 11/24/2016.
 */

@Component("premierLeagueMaster")
public final class PremierLeagueMaster implements Master {

    @Autowired
    private DataFinder dataFinderEnglishPremierLeague;

    @Autowired
    private ResultDAO resultDAO;

    public DataFinder getDataFinderEnglishPremierLeague() {
        return dataFinderEnglishPremierLeague;
    }

    public void setDataFinderEnglishPremierLeague(DataFinder dataFinderEnglishPremierLeague) {
        this.dataFinderEnglishPremierLeague = dataFinderEnglishPremierLeague;
    }

    public ResultDAO getResultDAO() {
        return resultDAO;
    }

    public void setResultDAO(ResultDAO resultDAO) {
        this.resultDAO = resultDAO;
    }

    @Override
    public void populateResults() {
        final SortedSet<Result> savedResults = getResultDAO().results();
        for (Result item : getDataFinderEnglishPremierLeague().findResults()) {
            if (!savedResults.contains(item)) {
                getResultDAO().insertResult(item);
            }
        }
    }

    public void populateResults(final SeasonCode seasonCode) {
        final SortedSet<Result> savedResults = getResultDAO()
                .findResultsBySeasonCodeAndTournamentCode(seasonCode, TournamentCode.ENG_PREM_LEAGUE);

        getDataFinderEnglishPremierLeague().findResults().stream().filter(result -> !savedResults.contains(result))
                .forEach(getResultDAO()::insertResult);
    }
}
