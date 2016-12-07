package org.total.spring.masters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.total.spring.dao.ResultDAO;
import org.total.spring.entity.Result;
import org.total.spring.entity.enums.TournamentCode;
import org.total.spring.finder.DataFinder;

import java.util.TreeSet;

/**
 * Created by pavlo.fandych on 11/24/2016.
 */

@Component("premierLeagueMaster")
public class PremierLeagueMaster implements Master {
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
        TreeSet<Result> savedResults = getResultDAO()
                .findResultsByTournamentCode(TournamentCode.ENG_PREM_LEAGUE);
        for (Result item : getDataFinderEnglishPremierLeague().findResults()) {
            if (!savedResults.contains(item)) {
                getResultDAO().insertResult(item);
            }
        }
    }
}
