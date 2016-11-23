package org.total.spring.exec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.total.spring.masters.BundesLigaMaster;

public class ResultsManager {
    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        new String[]{"applicationContext.xml"});
        ((BundesLigaMaster) context.getBean("bundesLigaMaster")).populateResults();
    }
}