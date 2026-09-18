package com.dovertraining.assignment4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class QueueTest {
    @Test
    void enqueueDequeuePeekAndCustomIteratorWorkWithWrapAround() {
        Queue<Integer> queue = new Queue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue());
        queue.enqueue(4);

        assertEquals(2, queue.peek());
        assertEquals(List.of(2, 3, 4), toList(queue));
    }

    @Test
    void queueRejectsInvalidOperations() {
        Queue<Integer> queue = new Queue<>(1);
        assertThrows(IllegalStateException.class, queue::dequeue);
        queue.enqueue(10);
        assertThrows(IllegalStateException.class, () -> queue.enqueue(20));
        assertEquals(10, queue.dequeue());
        assertTrue(queue.isEmpty());
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
