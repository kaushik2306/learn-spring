package dev.kc.learnspring.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class RecentTimepassBean implements ITimepassBean{
    @Override
    public String toString() {
        return "RecentTimepassBean{}";
    }
}
