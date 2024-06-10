package dev.kc.learnspring.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Deprecated
//@Primary
public class DeprecatedTimepassBean implements ITimepassBean{

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
