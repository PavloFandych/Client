package org.total.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.total.spring.http.HttpExecutor;
import org.total.spring.util.Constants;
import org.total.spring.util.PasswordManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pavlo.fandych on 12/1/2016.
 */

@Repository("cachedStandingsDAO")
public class CachedStandingsDAO extends GenericDAO {
    @Autowired
    private HttpExecutor httpExecutor;

    @Autowired
    private PasswordManager passwordManager;

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

    public void saveStandings(String seasonCode, String tournamentCode) {
        try {
            if (seasonCode != null
                    && !seasonCode.isEmpty()
                    && tournamentCode != null
                    && !tournamentCode.isEmpty()) {
                StringBuilder builder = new StringBuilder();
                builder.append("?seasonCode=")
                        .append(seasonCode)
                        .append("&tournamentCode=")
                        .append(tournamentCode);

                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", Constants.CONTENT_TYPE_APPLICATION_JSON);
                headers.put("Version", "V1");
                headers.put("Authorization", getPasswordManager().encodeBase64("Admin:admin"));

                LOGGER.info(getHttpExecutor().executeGet(Constants.URL_STANDINGS, headers, builder.toString()));
            } else {
                LOGGER.error("Invalid input parameters");
            }
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
    }
}
