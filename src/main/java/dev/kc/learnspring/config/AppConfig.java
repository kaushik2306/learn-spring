package dev.kc.learnspring.config;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource(){
        EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .build();
        return embeddedDatabase;
//        JdbcDataSource jdbcDataSource = new JdbcDataSource();
//        jdbcDataSource.setURL("jdbc:h2:mem:testdb");
//        jdbcDataSource.setUser("admin");
//        jdbcDataSource.setPassword("admin");
//        return jdbcDataSource;
    }
}
