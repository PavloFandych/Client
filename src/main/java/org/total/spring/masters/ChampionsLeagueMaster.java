package org.total.spring.masters;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.total.spring.entity.Result;
import org.total.spring.finder.DataFinder;

import java.util.List;

/**
 * Created by pavlo.fandych on 12/9/2016.
 */

@Component("championsLeagueMaster")
public final class ChampionsLeagueMaster implements Master {
    private static final Logger LOGGER = Logger.getLogger(ChampionsLeagueMaster.class);

    @Autowired
    private DataFinder dataFinderChampionsLeague;

    public DataFinder getDataFinderChampionsLeague() {
        return dataFinderChampionsLeague;
    }

    public void setDataFinderChampionsLeague(DataFinder dataFinderChampionsLeague) {
        this.dataFinderChampionsLeague = dataFinderChampionsLeague;
    }

    @Override
    public void populateResults() {
        List<Result> results = dataFinderChampionsLeague.findResults();
        for (Result item : results) {
            LOGGER.info(item);
        }
    }
}