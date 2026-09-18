package com.dovertraining.assignment4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class PolymorphismTest {
    @Test
    void parentInterfaceHandlesAllLinearStructures() {
        Stack<Integer> stack = new Stack<>(2);
        stack.push(1);
        Queue<Integer> queue = new Queue<>(2);
        queue.enqueue(2);
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(3);

        List<LinearStructure<Integer>> structures = List.of(stack, queue, list);
        assertEquals(List.of(1, 1, 1), structures.stream().map(LinearStructure::size).toList());
        assertTrue(structures.stream().noneMatch(LinearStructure::isEmpty));
    }
}
