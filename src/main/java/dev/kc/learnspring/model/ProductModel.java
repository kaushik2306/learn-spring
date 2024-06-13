package dev.kc.learnspring.model;

import java.util.StringJoiner;

public record ProductModel(String name) {

    @Override
    public String toString() {
        return new StringJoiner(", ", ProductModel.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
