package org.total.spring.masters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.total.spring.dao.ResultDAO;
import org.total.spring.entity.Result;
import org.total.spring.finder.DataFinder;

import java.util.List;

/**
 * Created by pavlo.fandych on 11/29/2016.
 */

@Component("ligue1Master")
public class Ligue1Master implements Master {
    @Autowired
    private DataFinder dataFinderFrenchLigue1;

    @Autowired
    private ResultDAO resultDAO;

    public DataFinder getDataFinderFrenchLigue1() {
        return dataFinderFrenchLigue1;
    }

    public void setDataFinderFrenchLigue1(DataFinder dataFinderFrenchLigue1) {
        this.dataFinderFrenchLigue1 = dataFinderFrenchLigue1;
    }

    public ResultDAO getResultDAO() {
        return resultDAO;
    }

    public void setResultDAO(ResultDAO resultDAO) {
        this.resultDAO = resultDAO;
    }

    @Override
    public void populateResults() {
        List<Result> savedResults = getResultDAO().results();
        for (Result item : getDataFinderFrenchLigue1().findResults()) {
            if (!savedResults.contains(item)) {
                getResultDAO().insertResult(item);
            }
        }
    }
}