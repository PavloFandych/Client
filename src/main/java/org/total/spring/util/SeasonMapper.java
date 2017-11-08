package org.total.spring.util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 * @author Pavlo.Fandych
 */

@Component("seasonMapper")
public final class SeasonMapper {

    private static final Logger LOGGER = Logger.getLogger(SeasonMapper.class);

    private static final String MIDNIGHT = " 00:00:00";

    private static final Map<Date, Date> SEASONS = new LinkedHashMap<>();

    static {
        try {
            Properties credentials = new Properties();
            credentials.load(SeasonMapper.class.getClassLoader().getResourceAsStream("credentials.properties"));

            String begin = credentials.getProperty("seasonBeginMonthDay");
            String end = credentials.getProperty("seasonEndMonthDay");

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2000-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2001-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2001-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2002-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2002-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2003-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2003-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2004-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2004-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2005-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2005-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2006-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2006-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2007-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2007-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2008-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2008-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2009-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2009-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2010-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2010-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2011-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2011-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2012-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2012-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2013-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2013-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2014-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2014-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2015-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2015-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2016-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2016-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2017-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2017-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2018-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2018-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2019-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2019-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2020-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2020-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2021-".concat(end).concat(MIDNIGHT)));

            SEASONS.put(new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2021-".concat(begin).concat(MIDNIGHT)),
                    new SimpleDateFormat(Constants.SEASON_MAPPER_FORMAT_DATE, Locale.ENGLISH)
                            .parse("2022-".concat(end).concat(MIDNIGHT)));
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
    }

    public long mapSeason(final Date date) {
        long result = 1;
        for (Map.Entry<Date, Date> entry : SEASONS.entrySet()) {
            final Date begin = entry.getKey();
            final Date end = entry.getValue();
            if (begin.compareTo(date) < 0 && end.compareTo(date) > 0) {
                return result;
            }
            result++;
        }
        return -1;
    }
}