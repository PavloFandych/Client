package org.total.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.total.spring.entity.Result;
import org.total.spring.util.Constants;
import org.total.spring.util.ResultSet;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository("resultDAO")
public class ResultDAO extends GenericDAO<Result> {
    @Autowired
    private ResultSet resultSet;

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public Set<Result> results() {
        Set<Result> set = getResultSet().getResults();

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(Constants.FETCH_ALL_RESULTS_SQL);

        for (Map<String, Object> row : rows) {
            Result result = new Result();
            result.setResultId((long) row.get("resultId"));
            result.setGoalsByGuest((int) row.get("goalsByGuest"));
            result.setGoalsByHost((int) row.get("goalsByHost"));
            result.setMatchDay((int) row.get("matchDay"));
            set.add(result);
        }
        return set;
    }
}