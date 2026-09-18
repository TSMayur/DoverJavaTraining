package com.dovertraining.assignment4;


public class Stack<T> extends AbstractLinearStructure<T> {
    private final Object[] values;

    public Stack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        values = new Object[capacity];
    }

    public void push(T value) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full.");
        }
        values[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        T value = (T) values[--size];
        values[size] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return (T) values[size - 1];
    }

    public boolean isFull() {
        return size == values.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = size - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements.");
                }
                return (T) values[index--];
            }
        };
    }
}


