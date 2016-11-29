package org.total.spring.exec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.total.spring.masters.*;

public class ResultsManager {
    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        new String[]{"applicationContext.xml"});
        BundesLigaMaster bundesLigaMaster = ((BundesLigaMaster) context.getBean("bundesLigaMaster"));
        bundesLigaMaster.populateResults();
        ((PremierLeagueMaster) context.getBean("premierLeagueMaster")).populateResults();
        ((SerieAMaster) context.getBean("serieAMaster")).populateResults();

        LaLigaMaster laLigaMaster = (LaLigaMaster) context.getBean("laLigaMaster");
        laLigaMaster.populateResults();

        Ligue1Master ligue1Master = (Ligue1Master) context.getBean("ligue1Master");
        ligue1Master.populateResults();

        Long size = bundesLigaMaster.getResultDAO().getResultSize();
        System.out.println(size);
    }
}