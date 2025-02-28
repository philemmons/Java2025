package com.philemmons;

public interface List<T> {

    void insert(T data);

    void remove(T data);

    void traverse();

    boolean isEmpty();
}
