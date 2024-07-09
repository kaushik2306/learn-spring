package dev.kc.learnspring.dtos;

import java.util.StringJoiner;

public record ProductDto(String productName, String productCategory) {
    @Override
    public String toString() {
        return new StringJoiner(", ", ProductDto.class.getSimpleName() + "[", "]")
                .add("productName='" + productName + "'")
                .add("productCategory='" + productCategory + "'")
                .toString();
    }
}
