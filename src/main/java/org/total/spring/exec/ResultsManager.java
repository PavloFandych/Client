package org.total.spring.exec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.total.spring.finder.DataFinderBundesLiga1;

public class ResultsManager {
    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        new String[]{"applicationContext.xml"});

//        System.out.println(((ResultDAO) context.getBean("resultDAO")).results());
        System.out.println(((DataFinderBundesLiga1) context.getBean("dataFinderBundesLiga1")).findResults());
    }
}