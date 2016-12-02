package org.total.spring.exec;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.total.spring.masters.*;

public class ResultsManager {
    private static final Logger LOGGER = Logger.getLogger(ResultsManager.class);

    public static void main(String[] args) {
        try {
            long start = System.nanoTime();

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

            LOGGER.info("ResultSize :" + bundesLigaMaster.getResultDAO().getResultSize());

            CachedStandingsMaster cachedStandingsMaster = (CachedStandingsMaster) context.getBean("cachedStandingsMaster");
            cachedStandingsMaster.populateResults("S20162017", "DEU_BUNDESLIGA_1");
            cachedStandingsMaster.populateResults("S20162017", "ENG_PREM_LEAGUE");
            cachedStandingsMaster.populateResults("S20162017", "ITA_SERIA_A");
            cachedStandingsMaster.populateResults("S20162017", "ESP_PRIMERA");
            cachedStandingsMaster.populateResults("S20162017", "FRA_LIGUE_1");

            long end = System.nanoTime();
            LOGGER.info("Duration: " + (end - start) / 1000000000 + " sec");
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
    }
}