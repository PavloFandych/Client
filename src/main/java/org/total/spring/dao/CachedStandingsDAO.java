package org.total.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.total.spring.entity.Season;
import org.total.spring.entity.enums.SeasonCode;
import org.total.spring.http.HttpExecutor;
import org.total.spring.util.Constants;
import org.total.spring.util.PasswordManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by pavlo.fandych on 12/1/2016.
 */

@Repository("cachedStandingsDAO")
public class CachedStandingsDAO extends GenericDAO {
    @Autowired
    private HttpExecutor httpExecutor;

    @Autowired
    private PasswordManager passwordManager;

    @Autowired
    private SeasonDAO seasonDAO;

    public HttpExecutor getHttpExecutor() {
        return httpExecutor;
    }

    public void setHttpExecutor(HttpExecutor httpExecutor) {
        this.httpExecutor = httpExecutor;
    }

    public PasswordManager getPasswordManager() {
        return passwordManager;
    }

    public void setPasswordManager(PasswordManager passwordManager) {
        this.passwordManager = passwordManager;
    }

    public SeasonDAO getSeasonDAO() {
        return seasonDAO;
    }

    public void setSeasonDAO(SeasonDAO seasonDAO) {
        this.seasonDAO = seasonDAO;
    }

    public void saveStandings(String seasonCode, String tournamentCode) {
        try {
            Properties credentials = new Properties();
            credentials.load(CachedStandingsDAO.class.getClassLoader()
                    .getResourceAsStream("credentials.properties"));

            String user = credentials.getProperty("user");
            String userpass = credentials.getProperty("userpass");

            if (seasonCode != null
                    && !seasonCode.isEmpty()
                    && tournamentCode != null
                    && !tournamentCode.isEmpty()
                    && user != null
                    && !user.isEmpty()
                    && userpass != null
                    && !userpass.isEmpty()) {
                StringBuilder builder = new StringBuilder();
                builder.append("?seasonCode=")
                        .append(seasonCode)
                        .append("&tournamentCode=")
                        .append(tournamentCode);

                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", Constants.CONTENT_TYPE_APPLICATION_JSON);
                headers.put("Version", "V1");
                headers.put("Authorization", getPasswordManager().encodeBase64(user + ":" + userpass));

                LOGGER.info(getHttpExecutor().executeGet(Constants.URL_STANDINGS, headers, builder.toString()));

                Long seasonId = -1L;

                for (Season item : getSeasonDAO().seasons()) {
                    if (item.getSeasonCode().equals(SeasonCode.valueOf(seasonCode))) {
                        seasonId = item.getSeasonId();
                        break;
                    }
                }

                if (seasonId > 0) {
                    LOGGER.info("SeasonId = " + seasonId);
                }
            } else {
                LOGGER.error("Invalid input parameters");
            }
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
    }
}
