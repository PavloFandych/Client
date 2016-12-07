package org.total.spring.masters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.total.spring.dao.ResultDAO;
import org.total.spring.entity.Result;
import org.total.spring.entity.enums.TournamentCode;
import org.total.spring.finder.DataFinder;

import java.util.TreeSet;

/**
 * Created by total on 11/24/16.
 */

@Component("serieAMaster")
public class SerieAMaster implements Master {
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
        TreeSet<Result> savedResults = getResultDAO()
                .findResultsByTournamentCode(TournamentCode.ITA_SERIA_A);
        for (Result item : getDataFinderItalianSerieA().findResults()) {
            if (!savedResults.contains(item)) {
                getResultDAO().insertResult(item);
            }
        }
    }
}
