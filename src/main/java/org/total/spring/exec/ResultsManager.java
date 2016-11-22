package org.total.spring.exec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.total.spring.dao.ResultDAO;

public class ResultsManager {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        new String[]{"applicationContext.xml"});

        System.out.println(((ResultDAO) context.getBean("resultDAO")).results());

    }
}