package com.kevin.generics.spike;

public class Column<T> {

    private final Class<T> type;

    public Column(Class<T> inType) {
        this.type = inType;
    }



    public T cast(Object obj) {
        return obj == null ? null : type.cast(obj);
    }
}