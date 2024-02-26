package com.Unyime.springTutorial.config;

import com.Unyime.springTutorial.dao.AuthorDao;
import com.Unyime.springTutorial.dao.impl.AuthorDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
