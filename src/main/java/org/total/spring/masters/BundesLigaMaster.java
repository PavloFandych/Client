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

@Component("bundesLigaMaster")
public final class BundesLigaMaster implements Master {

    @Autowired
    private DataFinder dataFinderBundesLiga1;

    @Autowired
    private ResultDAO resultDAO;

    public DataFinder getDataFinderBundesLiga1() {
        return dataFinderBundesLiga1;
    }

    public void setDataFinderBundesLiga1(DataFinder dataFinderBundesLiga1) {
        this.dataFinderBundesLiga1 = dataFinderBundesLiga1;
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
        for (Result item : getDataFinderBundesLiga1().findResults()) {
            if (!savedResults.contains(item)) {
                getResultDAO().insertResult(item);
            }
        }
    }

    public void populateResults(final SeasonCode seasonCode) {
        final SortedSet<Result> savedResults = getResultDAO()
                .findResultsBySeasonCodeAndTournamentCode(seasonCode, TournamentCode.DEU_BUNDESLIGA_1);

        getDataFinderBundesLiga1().findResults().stream().filter(result -> !savedResults.contains(result))
                .forEach(getResultDAO()::insertResult);
    }
}