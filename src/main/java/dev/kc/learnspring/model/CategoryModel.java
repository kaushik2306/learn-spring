package dev.kc.learnspring.model;

import java.util.List;
import java.util.StringJoiner;

public record CategoryModel(Long id,String name) {

    @Override
    public String toString() {
        return new StringJoiner(", ", CategoryModel.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .toString();
    }
}
