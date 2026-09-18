package com.dovertraining.assignment4;

public class App {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>(2);
        names.push("Ravi");
        names.push("Priya");

        Queue<Employee> employees = new Queue<>(2);
        employees.enqueue(new Employee(1, "Mayur"));
        employees.enqueue(new Employee(2, "Arjun"));

        LinkedList<Object> values = new LinkedList<>();
        values.addLast("Hello");
        values.addLast(100); // int is automatically converted to Integer.
        values.addLast(new Employee(3, "Neha"));

        LinearStructure<?>[] structures = { names, employees, values };
        for (LinearStructure<?> structure : structures) {
            System.out.println("\n" + structure.getClass().getSimpleName() + ": " + structure.size());
            printValues(structure);
        }

        System.out.println("\nValid brackets: " + BracketValidator.isValid("[{a+b} * (c-d)]"));
        System.out.println("Invalid brackets: " + BracketValidator.isValid("[((a-b} * (c-d)]]]"));
    }

    private static <T> void printValues(Iterable<T> values) {
        Iterator<T> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
