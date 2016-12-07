package org.total.spring.masters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.total.spring.dao.ResultDAO;
import org.total.spring.entity.Result;
import org.total.spring.entity.enums.SeasonCode;
import org.total.spring.entity.enums.TournamentCode;
import org.total.spring.finder.DataFinder;

import java.util.TreeSet;

/**
 * Created by total on 11/23/16.
 */

@Component("bundesLigaMaster")
public class BundesLigaMaster implements Master {
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

    }

    public void populateResults(SeasonCode seasonCode) {
        TreeSet<Result> savedResults = getResultDAO()
                .findResultsBySeasonCodeAndTournamentCode(seasonCode, TournamentCode.DEU_BUNDESLIGA_1);
        for (Result item : getDataFinderBundesLiga1().findResults()) {
            if (!savedResults.contains(item)) {
                getResultDAO().insertResult(item);
            }
        }
    }
}