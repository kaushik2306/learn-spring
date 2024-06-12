package dev.kc.learnspring.service.diissue.withproxy;

import dev.kc.learnspring.service.category.CategoryServiceV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * This class is to explain DI issue while injecting dependency of CategoryServiceV2.<br><br>
 * CategoryServiceV2 is proxied.<br><br>
 * Injecting Implementation type is brittle<br><br>
 * Hence instead of injecting implementation type (CategoryServiceV2) inject ICategoryService<br><br>
 *
 * To understand the issue remove @Lazy and re-run the code
 */
@Service
@Lazy
public class DIIssueWithProxyDependencyService {

    private static final Logger log = LoggerFactory.getLogger(DIIssueWithProxyDependencyService.class);

    private final CategoryServiceV2 categoryServiceV2;

    public DIIssueWithProxyDependencyService(CategoryServiceV2 categoryServiceV2) {
        this.categoryServiceV2 = categoryServiceV2;
        log.info("{} Constructor invoked",getClass().getSimpleName());
    }
}
