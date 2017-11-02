package org.total.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.sf.ehcache.config.CacheConfiguration;
import org.apache.log4j.Logger;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.total.spring.util.Constants;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class AppConfig {

    private static final Logger LOGGER = Logger.getLogger(AppConfig.class);

    @Bean
    public DataSource getDataSource() {
        final ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            final Properties credentials = new Properties();
            credentials.load(AppConfig.class.getClassLoader().getResourceAsStream("credentials.properties"));

            dataSource.setDriverClass(credentials.getProperty("mysqlDriver").trim());
            dataSource.setJdbcUrl(credentials.getProperty("mysqlUrl").trim());
            dataSource.setUser(credentials.getProperty("mysqlUser").trim());
            dataSource.setPassword(credentials.getProperty("mysqlUserPass").trim());
            dataSource.setInitialPoolSize(5);
            dataSource.setMaxPoolSize(50);
            dataSource.setMinPoolSize(10);
            dataSource.setAcquireIncrement(5);
            dataSource.setMaxStatements(100);
        } catch (Exception e) {
            LOGGER.error(e, e);
        }
        return dataSource;
    }

    @Bean(destroyMethod = "shutdown")
    public net.sf.ehcache.CacheManager ehCacheManager() {
        final CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setName("applicationCache");

        cacheConfiguration.setMaxEntriesLocalHeap(Constants.MAX_ENTRIES_LOCAL_HEAP);
        cacheConfiguration.setMaxEntriesLocalDisk(Constants.MAX_ENTRIES_LOCAL_DISK);

        cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");

        /*
        * timeToIdle – The maximum number of seconds
        * an element can exist in the cache
        * without being accessed
        * */
        cacheConfiguration.setTimeToIdleSeconds(Constants.TIME_TO_IDLE_SECONDS);

        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(cacheConfiguration);

        return net.sf.ehcache.CacheManager.newInstance(config);
    }

    @Bean(name = "springCashManager")
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        final JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());

        return jdbcTemplate;
    }
}