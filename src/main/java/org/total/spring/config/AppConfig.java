package org.total.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Bean
    public DataSource getDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/GoalDB");
            dataSource.setUser("root");
            dataSource.setPassword("mysqlpass");
            dataSource.setInitialPoolSize(5);
            dataSource.setMaxPoolSize(50);
            dataSource.setMinPoolSize(10);
            dataSource.setAcquireIncrement(5);
            dataSource.setMaxStatements(100);
        } catch (Exception e) {
        }
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
}