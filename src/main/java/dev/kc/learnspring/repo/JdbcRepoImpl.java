package dev.kc.learnspring.repo;

import org.springframework.stereotype.Component;

@Component
public class JdbcRepoImpl implements IRepo{
    /**
     * @return
     */
    @Override
    public String getRepoName() {
        return "JDBC REPO";
    }
}
