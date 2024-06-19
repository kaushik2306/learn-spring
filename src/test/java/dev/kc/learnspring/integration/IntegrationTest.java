package dev.kc.learnspring.integration;

import dev.kc.learnspring.config.TestConfig;
import dev.kc.learnspring.listeners.MyTestListener;
import dev.kc.learnspring.service.category.ICategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {TestConfig.class})
//@TestPropertySource(properties = {"spring.profiles.active=test","spring.application.name=e-commerce","my-name=kaushik","app.version=1.0","server.port=81"})

@SpringJUnitConfig(classes = {TestConfig.class})
//@TestPropertySource(properties = {"spring.profiles.active=test"})
@ActiveProfiles(value = {"test"})
/* Note: We can use @TestPropertySource or @ActiveProfiles to active profile for our test
 *  Note: We can use @ActiveProfiles only on a JUnit test
 * */

//@TestPropertySource(properties = {"org.springframework.test.context.jdbc=DEBUG","org.springframework.jdbc.datasource.init=DEBUG"})
//@Sql(scripts = {"classpath:IntegrationTest-Schema.sql"})
@TestExecutionListeners(value = {MyTestListener.class},mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
public class IntegrationTest {

    @Autowired
    private ICategoryService categoryService;

    @Test
    void getAllCategories(){
        var latestCategories = categoryService.getLatestCategories();
        Assertions.assertEquals(2,latestCategories.size(),"Number of categories");
    }


}
