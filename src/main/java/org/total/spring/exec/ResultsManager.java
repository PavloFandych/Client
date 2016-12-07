package org.total.spring.exec;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.total.spring.entity.enums.TournamentCode;
import org.total.spring.masters.*;
import org.total.spring.util.Constants;

import java.util.Properties;

public class ResultsManager {
    private static final Logger LOGGER = Logger.getLogger(ResultsManager.class);

    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            try {
                long start = System.nanoTime();

                ApplicationContext context =
                        new ClassPathXmlApplicationContext(
                                new String[]{"applicationContext.xml"});

                CachedStandingsMaster cachedStandingsMaster = (CachedStandingsMaster) context
                        .getBean("cachedStandingsMaster");

                Properties credentials = new Properties();
                credentials.load(ResultsManager.class.getClassLoader()
                        .getResourceAsStream("credentials.properties"));
                String seasonCode = credentials.getProperty("seasonCodeArgument");

                for (String item : args) {
                    TournamentCode code = null;
                    try {
                        code = TournamentCode.valueOf(item);
                    } catch (Exception e) {
                        LOGGER.error(Constants.INVALID_TOURNAMENT_CODE);
                        break;
                    }

                    switch (code) {
                        case DEU_BUNDESLIGA_1: {
                            BundesLigaMaster bundesLigaMaster = ((BundesLigaMaster) context
                                    .getBean("bundesLigaMaster"));
                            bundesLigaMaster.populateResults();
                            cachedStandingsMaster.populateResults(seasonCode, TournamentCode.DEU_BUNDESLIGA_1.name());
                            break;
                        }
                        case ENG_PREM_LEAGUE: {
                            PremierLeagueMaster premierLeagueMaster = ((PremierLeagueMaster) context
                                    .getBean("premierLeagueMaster"));
                            premierLeagueMaster.populateResults();
                            cachedStandingsMaster.populateResults(seasonCode, TournamentCode.ENG_PREM_LEAGUE.name());
                            break;
                        }
                        case ITA_SERIA_A: {
                            SerieAMaster serieAMaster = ((SerieAMaster) context
                                    .getBean("serieAMaster"));
                            serieAMaster.populateResults();
                            cachedStandingsMaster.populateResults(seasonCode, TournamentCode.ITA_SERIA_A.name());
                            break;
                        }
                        case ESP_PRIMERA: {
                            LaLigaMaster laLigaMaster = (LaLigaMaster) context
                                    .getBean("laLigaMaster");
                            laLigaMaster.populateResults();
                            cachedStandingsMaster.populateResults(seasonCode, TournamentCode.ESP_PRIMERA.name());
                            break;
                        }
                        case FRA_LIGUE_1: {
                            Ligue1Master ligue1Master = (Ligue1Master) context
                                    .getBean("ligue1Master");
                            ligue1Master.populateResults();
                            cachedStandingsMaster.populateResults(seasonCode, TournamentCode.FRA_LIGUE_1.name());
                            break;
                        }
                        default: {
                            LOGGER.error(Constants.INVALID_TOURNAMENT_CODE);
                        }
                    }
                }

                long end = System.nanoTime();
                LOGGER.info("Duration: " + (end - start) / 1000000000 + " sec");
            } catch (Exception e) {
                LOGGER.error(e, e);
            }
        }
        else {
            LOGGER.error(Constants.NO_TOURNAMENT_CODE_FOUND);
        }
    }
}