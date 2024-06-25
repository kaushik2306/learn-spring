package dev.kc.learnspring.model;

import java.util.List;
import java.util.StringJoiner;

public record ProductModel(Long id,String name) {

    @Override
    public String toString() {
        return new StringJoiner(", ", ProductModel.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .toString();
    }
}
