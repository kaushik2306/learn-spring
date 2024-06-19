package dev.kc.learnspring.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class MyTestListener implements TestExecutionListener {
    private static final Logger log = LoggerFactory.getLogger(MyTestListener.class);

    @Override
    public void beforeTestExecution(TestContext testContext) throws Exception {
       var name = testContext.getApplicationContext().getApplicationName();
       log.info("{} APP NAME",name);
    }
}
