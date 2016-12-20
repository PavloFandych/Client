package org.total.spring.exec;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.total.spring.entity.enums.SeasonCode;
import org.total.spring.entity.enums.TournamentCode;
import org.total.spring.masters.*;
import org.total.spring.util.Constants;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/*ENG_PREM_LEAGUE DEU_BUNDESLIGA_1 ITA_SERIA_A ESP_PRIMERA FRA_LIGUE_1 NLD_EREDIVISIE PRT_PRIMEIRA_LIGA*/

public final class ResultsManager {
    private static final Logger LOGGER = Logger.getLogger(ResultsManager.class);

    public static void main(String[] args) {
        if (args != null
                && args.length > 0) {
            try {
                long start = System.nanoTime();

                ApplicationContext context =
                        new ClassPathXmlApplicationContext(
                                new String[]{"applicationContext.xml"});

                CachedStandingsMaster cachedStandingsMaster = (CachedStandingsMaster) context
                        .getBean("cachedStandingsMaster");

                CachedTeamsListMaster cachedTeamsListMaster = (CachedTeamsListMaster) context
                        .getBean("cachedTeamsListMaster");

                Properties credentials = new Properties();
                credentials.load(ResultsManager.class.getClassLoader()
                        .getResourceAsStream("credentials.properties"));
                String seasonCode = credentials
                        .getProperty("currentSeasonCode");

                if (isSeasonCodeValid(seasonCode)) {
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
                                bundesLigaMaster.populateResults(SeasonCode.valueOf(seasonCode));
                                cachedStandingsMaster.populateResults(seasonCode,
                                        TournamentCode.DEU_BUNDESLIGA_1.name());
                                cachedTeamsListMaster.populateResults(seasonCode,
                                        TournamentCode.DEU_BUNDESLIGA_1.name());
                                break;
                            }
                            case ENG_PREM_LEAGUE: {
                                PremierLeagueMaster premierLeagueMaster = ((PremierLeagueMaster) context
                                        .getBean("premierLeagueMaster"));
                                premierLeagueMaster.populateResults(SeasonCode.valueOf(seasonCode));
                                cachedStandingsMaster.populateResults(seasonCode,
                                        TournamentCode.ENG_PREM_LEAGUE.name());
                                cachedTeamsListMaster.populateResults(seasonCode,
                                        TournamentCode.ENG_PREM_LEAGUE.name());
                                break;
                            }
                            case ITA_SERIA_A: {
                                SerieAMaster serieAMaster = ((SerieAMaster) context
                                        .getBean("serieAMaster"));
                                serieAMaster.populateResults(SeasonCode.valueOf(seasonCode));
                                cachedStandingsMaster.populateResults(seasonCode,
                                        TournamentCode.ITA_SERIA_A.name());
                                cachedTeamsListMaster.populateResults(seasonCode,
                                        TournamentCode.ITA_SERIA_A.name());
                                break;
                            }
                            case ESP_PRIMERA: {
                                LaLigaMaster laLigaMaster = (LaLigaMaster) context
                                        .getBean("laLigaMaster");
                                laLigaMaster.populateResults(SeasonCode.valueOf(seasonCode));
                                cachedStandingsMaster.populateResults(seasonCode,
                                        TournamentCode.ESP_PRIMERA.name());
                                cachedTeamsListMaster.populateResults(seasonCode,
                                        TournamentCode.ESP_PRIMERA.name());
                                break;
                            }
                            case FRA_LIGUE_1: {
                                Ligue1Master ligue1Master = (Ligue1Master) context
                                        .getBean("ligue1Master");
                                ligue1Master.populateResults(SeasonCode.valueOf(seasonCode));
                                cachedStandingsMaster.populateResults(seasonCode,
                                        TournamentCode.FRA_LIGUE_1.name());
                                cachedTeamsListMaster.populateResults(seasonCode,
                                        TournamentCode.FRA_LIGUE_1.name());
                                break;
                            }
                            case NLD_EREDIVISIE: {
                                EredivisieMaster eredivisieMaster = (EredivisieMaster) context
                                        .getBean("eredivisieMaster");
                                eredivisieMaster.populateResults(SeasonCode.valueOf(seasonCode));
                                cachedStandingsMaster.populateResults(seasonCode,
                                        TournamentCode.NLD_EREDIVISIE.name());
                                cachedTeamsListMaster.populateResults(seasonCode,
                                        TournamentCode.NLD_EREDIVISIE.name());
                                break;
                            }
                            case PRT_PRIMEIRA_LIGA: {
                                PrimeiraLigaMaster primeiraLigaMaster = (PrimeiraLigaMaster) context
                                        .getBean("primeiraLigaMaster");
                                primeiraLigaMaster.populateResults(SeasonCode.valueOf(seasonCode));
                                cachedStandingsMaster.populateResults(seasonCode,
                                        TournamentCode.PRT_PRIMEIRA_LIGA.name());
                                cachedTeamsListMaster.populateResults(seasonCode,
                                        TournamentCode.PRT_PRIMEIRA_LIGA.name());
                                break;
                            }
                            case CHAMPIONS_LEAGUE: {
                                ChampionsLeagueMaster championsLeagueMaster = (ChampionsLeagueMaster) context
                                        .getBean("championsLeagueMaster");
                                championsLeagueMaster.populateResults(SeasonCode.valueOf(seasonCode));
                                break;
                            }
                            default: {
                                LOGGER.error(Constants.INVALID_TOURNAMENT_CODE);
                            }
                        }
                    }
                }

                long end = System.nanoTime();

                String duration = String.format("%d min, %d sec",
                        TimeUnit.NANOSECONDS.toMinutes((end - start)),
                        TimeUnit.NANOSECONDS.toSeconds((end - start)) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes((end - start)))
                );
                LOGGER.info("Duration: ".concat(duration));
            } catch (Exception e) {
                LOGGER.error(e, e);
            }
        } else {
            LOGGER.error(Constants.NO_TOURNAMENT_CODE_FOUND);
        }
    }

    private static boolean isSeasonCodeValid(final String seasonCode) {
        SeasonCode seasonCodeEnum = null;
        try {
            seasonCodeEnum = SeasonCode.valueOf(seasonCode);
            return (seasonCodeEnum != null) ? true : false;
        } catch (Exception e) {
            LOGGER.error(Constants.INVALID_SEASON_CODE);
        }
        return false;
    }
}