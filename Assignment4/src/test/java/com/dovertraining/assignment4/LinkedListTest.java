package com.dovertraining.assignment4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class LinkedListTest {
    @Test
    void addInsertDeleteGetAndCustomIteratorWork() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        list.insert(2, 3);

        assertEquals(4, list.size());
        assertEquals(3, list.get(2));
        assertEquals(3, list.delete(2));
        assertEquals(List.of(1, 2, 4), toList(list));
    }

    @Test
    void invalidIndexesAreRejected() {
        LinkedList<String> list = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(1, "A"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(0));
    }

    private <T> List<T> toList(Iterable<T> values) {
        List<T> result = new ArrayList<>();
        Iterator<T> iterator = values.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }
}
