package org.total.spring.masters;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.total.spring.dao.ResultDAO;
import org.total.spring.entity.Result;
import org.total.spring.finder.DataFinder;

import java.util.List;

/**
 * Created by total on 11/23/16.
 */

@Component("bundesLigaMaster")
public class BundesLigaMaster {
    private static final Logger LOGGER = Logger.getLogger(BundesLigaMaster.class);

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

    public void populateResults() {
        List<Result> savedResults = getResultDAO().results();
        
        for (Result item : getDataFinderBundesLiga1().findResults()) {
            if (!savedResults.contains(item)) {
                getResultDAO().insertResult(item);
            }
        }
    }
}
