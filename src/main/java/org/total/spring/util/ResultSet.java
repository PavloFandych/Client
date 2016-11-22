package org.total.spring.util;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.total.spring.entity.Result;

import java.util.LinkedHashSet;
import java.util.Set;

@Component
@Scope("prototype")
public class ResultSet {
    private Set<Result> results;

    public Set<Result> getResults() {
        if (results == null || results.isEmpty()) {
            results = new LinkedHashSet<>();
        }
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }
}