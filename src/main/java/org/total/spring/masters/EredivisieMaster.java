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
 * @author Pavlo.Fandych
 */

@Component("eredivisieMaster")
public final class EredivisieMaster implements Master {

    @Autowired
    private DataFinder dataFinderEredivisie;

    @Autowired
    private ResultDAO resultDAO;

    public DataFinder getDataFinderEredivisie() {
        return dataFinderEredivisie;
    }

    public void setDataFinderEredivisie(DataFinder dataFinderEredivisie) {
        this.dataFinderEredivisie = dataFinderEredivisie;
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
        for (Result item : getDataFinderEredivisie().findResults()) {
            if (!savedResults.contains(item)) {
                getResultDAO().insertResult(item);
            }
        }
    }

    public void populateResults(final SeasonCode seasonCode) {
        final SortedSet<Result> savedResults = getResultDAO()
                .findResultsBySeasonCodeAndTournamentCode(seasonCode, TournamentCode.NLD_EREDIVISIE);

        getDataFinderEredivisie().findResults().stream().filter(result -> !savedResults.contains(result))
                .forEach(getResultDAO()::insertResult);
    }
}
