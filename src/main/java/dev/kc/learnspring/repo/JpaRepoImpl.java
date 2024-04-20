package dev.kc.learnspring.repo;

import org.springframework.stereotype.Component;

@Component
public class JpaRepoImpl implements IRepo{
    /**
     * @return
     */
    @Override
    public String getRepoName() {
        return "JPA REPO";
    }
}
