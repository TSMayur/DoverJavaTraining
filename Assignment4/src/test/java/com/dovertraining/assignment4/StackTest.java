package com.dovertraining.assignment4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class StackTest {
    @Test
    void pushPopPeekAndCustomIteratorWork() {
        Stack<Integer> stack = new Stack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertTrue(stack.isFull());
        assertEquals(3, stack.peek());
        assertEquals(List.of(3, 2, 1), toList(stack));
        assertEquals(3, stack.pop());
        assertEquals(2, stack.size());
    }

    @Test
    void fullAndEmptyStacksRejectInvalidOperations() {
        Stack<String> stack = new Stack<>(1);
        assertThrows(IllegalStateException.class, stack::pop);
        stack.push("A");
        assertThrows(IllegalStateException.class, () -> stack.push("B"));
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void genericStackStoresEmployees() {
        Stack<Employee> stack = new Stack<>(2);
        Employee employee = new Employee(1, "Ravi");
        stack.push(employee);
        assertEquals(employee, stack.pop());
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
