package com.dovertraining.assignment4;

public abstract class AbstractLinearStructure<T> implements LinearStructure<T> {
    protected int size;

    @Override
    public int size() {
        return size;
    }
}
