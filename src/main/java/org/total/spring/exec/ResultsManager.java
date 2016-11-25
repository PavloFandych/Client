package org.total.spring.exec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.total.spring.masters.BundesLigaMaster;
import org.total.spring.masters.PremierLeagueMaster;
import org.total.spring.masters.SerieAMaster;

public class ResultsManager {
    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        new String[]{"applicationContext.xml"});
        BundesLigaMaster bundesLigaMaster = ((BundesLigaMaster) context.getBean("bundesLigaMaster"));
        bundesLigaMaster.populateResults();
        ((PremierLeagueMaster) context.getBean("premierLeagueMaster")).populateResults();
        ((SerieAMaster) context.getBean("serieAMaster")).populateResults();

        Long size = bundesLigaMaster.getResultDAO().getResultSize();
        System.out.println(size);
    }
}