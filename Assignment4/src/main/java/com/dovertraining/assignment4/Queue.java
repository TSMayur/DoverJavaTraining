package com.dovertraining.assignment4;


public class Queue<T> extends AbstractLinearStructure<T> {
    private final Object[] values;
    private int front;

    public Queue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        values = new Object[capacity];
    }

    public void enqueue(T value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full.");
        }
        values[(front + size++) % values.length] = value;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        T value = (T) values[front];
        values[front] = null;
        front = (front + 1) % values.length;
        size--;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return (T) values[front];
    }

    public boolean isFull() {
        return size == values.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements.");
                }
                return (T) values[(front + index++) % values.length];
            }
        };
    }
}


