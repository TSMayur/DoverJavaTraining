package com.dovertraining.assignment4;

public interface LinearStructure<T> extends Iterable<T> {
    int size();

    default boolean isEmpty() {
        return size() == 0;
    }
}
