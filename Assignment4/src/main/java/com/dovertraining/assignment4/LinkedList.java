package com.dovertraining.assignment4;


public class LinkedList<T> extends AbstractLinearStructure<T> {
    private Node<T> head;
    private Node<T> tail;

    public void addFirst(T value) {
        Node<T> node = new Node<>(value, head);
        head = node;
        if (tail == null) {
            tail = node;
        }
        size++;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value, null);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node<T> previous = nodeAt(index - 1);
            previous.next = new Node<>(value, previous.next);
            size++;
        }
    }

    public T delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            T value = head.value;
            head = head.next;
            if (--size == 0) {
                tail = null;
            }
            return value;
        }
        Node<T> previous = nodeAt(index - 1);
        Node<T> removed = previous.next;
        previous.next = removed.next;
        if (removed == tail) {
            tail = previous;
        }
        size--;
        return removed.value;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return nodeAt(index).value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements.");
                }
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    private Node<T> nodeAt(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}


