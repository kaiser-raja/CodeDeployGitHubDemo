package com.backend.domain.model.type;

public interface IntegerEnumType<E extends Enum<E>> {
    int getCode();
}