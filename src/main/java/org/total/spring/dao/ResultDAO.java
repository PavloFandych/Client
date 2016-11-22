package org.total.spring.dao;

import org.total.spring.entity.Result;
import org.total.spring.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by pavlo.fandych on 11/22/2016.
 */

public class ResultDAO extends GenericDAO<Result> {
    public List<Result> results() {
        List<Result> list = new ArrayList<>();

        List<Map<String, Object>> rows = getJdbcTemplate()
                .queryForList(Constants.FETCH_ALL_RESULTS_SQL);

        for (Map<String, Object> row : rows) {

        }

        return list;
    }
}