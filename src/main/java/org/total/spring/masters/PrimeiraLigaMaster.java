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
 * Created by pavlo.fandych on 12/13/2016.
 */

@Component("primeiraLigaMaster")
public final class PrimeiraLigaMaster implements Master {

    @Autowired
    private DataFinder dataFinderPortugalPrimeiraLiga;

    @Autowired
    private ResultDAO resultDAO;

    public DataFinder getDataFinderPortugalPrimeiraLiga() {
        return dataFinderPortugalPrimeiraLiga;
    }

    public void setDataFinderPortugalPrimeiraLiga(DataFinder dataFinderPortugalPrimeiraLiga) {
        this.dataFinderPortugalPrimeiraLiga = dataFinderPortugalPrimeiraLiga;
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
        for (Result item : getDataFinderPortugalPrimeiraLiga().findResults()) {
            if (!savedResults.contains(item)) {
                getResultDAO().insertResult(item);
            }
        }
    }

    public void populateResults(final SeasonCode seasonCode) {
        final SortedSet<Result> savedResults = getResultDAO()
                .findResultsBySeasonCodeAndTournamentCode(seasonCode, TournamentCode.PRT_PRIMEIRA_LIGA);

        getDataFinderPortugalPrimeiraLiga().findResults().stream().filter(result -> !savedResults.contains(result))
                .forEach(result -> getResultDAO().insertResult(result));
    }
}