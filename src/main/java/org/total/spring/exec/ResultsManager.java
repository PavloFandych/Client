package org.total.spring.exec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.total.spring.config.AppConfig;
import org.total.spring.dao.ResultDAO;
import org.total.spring.finder.DataFinder;
import org.total.spring.finder.DataFinderBundesLiga1;

/**
 * Created by pavlo.fandych on 11/21/2016.
 */

public class ResultsManager {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        DataFinder dataFinder = new DataFinderBundesLiga1();
//        System.out.println(dataFinder.findResults());

        ResultDAO resultDAO = (ResultDAO)context.getBean("resultDAO");
        System.out.println(resultDAO.results());
    }
}