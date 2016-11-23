package org.total.spring.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by total on 11/23/16.
 */

@Component("seasonMapper")
public class SeasonMapper {
    private static final Map<Date, Date> SEASONS = new LinkedHashMap<>();

    static {
        try {
            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2000-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2001-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2001-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2002-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2002-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2003-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2003-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2004-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2004-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2005-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2005-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2006-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2006-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2007-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2007-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2008-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2008-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2009-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2009-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2010-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2010-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2011-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2011-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2012-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2012-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2013-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2013-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2014-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2014-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2015-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2015-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2016-06-01 00:00:00"));

            SEASONS.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2016-07-15 00:00:00"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse("2017-06-01 00:00:00"));
        } catch (Exception e) {
        }
    }

    public long mapSeason(final Date date) {
        long result = 1;
        for (Map.Entry<Date, Date> entry : SEASONS.entrySet()) {
            Date begin = entry.getKey();
            Date end = entry.getValue();
            if (begin.compareTo(date) < 0 && end.compareTo(date) > 0) {
                return result;
            }
            result++;
        }
        return -1;
    }
}
