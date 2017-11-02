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
 * Created by total on 11/24/16.
 */

@Component("serieAMaster")
public final class SerieAMaster implements Master {

    @Autowired
    private DataFinder dataFinderItalianSerieA;

    @Autowired
    private ResultDAO resultDAO;

    public DataFinder getDataFinderItalianSerieA() {
        return dataFinderItalianSerieA;
    }

    public void setDataFinderItalianSerieA(DataFinder dataFinderItalianSerieA) {
        this.dataFinderItalianSerieA = dataFinderItalianSerieA;
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
        for (Result item : getDataFinderItalianSerieA().findResults()) {
            if (!savedResults.contains(item)) {
                getResultDAO().insertResult(item);
            }
        }
    }

    public void populateResults(final SeasonCode seasonCode) {
        final SortedSet<Result> savedResults = getResultDAO()
                .findResultsBySeasonCodeAndTournamentCode(seasonCode, TournamentCode.ITA_SERIA_A);

        getDataFinderItalianSerieA().findResults().stream().filter(result -> !savedResults.contains(result))
                .forEach(result -> getResultDAO().insertResult(result));
    }
}
