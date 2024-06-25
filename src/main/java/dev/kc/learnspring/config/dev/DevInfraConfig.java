package dev.kc.learnspring.config.dev;

import dev.kc.learnspring.config.commons.AppConfig;
import dev.kc.learnspring.config.commons.IInfraConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
@Profile(value = "dev")
@Import(AppConfig.class)
public class DevInfraConfig implements IInfraConfig {

    private static final Logger log = LoggerFactory.getLogger(DevInfraConfig.class);

    public DevInfraConfig() {
        log.info("{} Constructor invoked",getClass().getSimpleName());
    }

    @Value("${spring.application.name}")
    String applicationName;

    @Value("${spring.profiles.active}")
    String profileName;

    @Value("${my-name}")
    private String myName;

    @Override
    public String getProfileName() {
        return profileName;
    }

    @Override
    public String getApplicationName() {
        return applicationName;
    }

    @Override
    public String getMyName() {
        return myName;
    }

    @Bean
    public DataSource dataSource(){
        log.info("=== DATASOURCE-BUILDER ===");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:h2:mem:test");
        dataSourceBuilder.username("kc");
        dataSourceBuilder.password("kc");
        return dataSourceBuilder.build();
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
        log.info("=== DATASOURCE-INITIALIZER ===");
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("database/TableCreation.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("database/TableData.sql"));
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
        return dataSourceInitializer;
    }
}
