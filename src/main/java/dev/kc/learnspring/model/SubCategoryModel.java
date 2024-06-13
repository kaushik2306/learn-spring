package dev.kc.learnspring.model;

import java.util.StringJoiner;

public record SubCategoryModel(Long id,String name) {
    @Override
    public String toString() {
        return new StringJoiner(", ", SubCategoryModel.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .toString();
    }
}
