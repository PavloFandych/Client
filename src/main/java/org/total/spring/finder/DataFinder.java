package org.total.spring.finder;

import org.apache.log4j.Logger;
import org.total.spring.entity.Result;

import java.util.List;

/**
 * Created by total on 11/2/16.
 */

public abstract class DataFinder {
    protected static final Logger LOGGER = Logger.getLogger(DataFinder.class);

    protected abstract String getUrl();

    public abstract List<Result> findResults();
}