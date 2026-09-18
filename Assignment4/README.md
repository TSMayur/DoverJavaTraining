# Assignment 4 – Generic Data Structures

A Maven project implementing custom generic data structures and a custom Iterator design pattern.

## Included

- `Stack<T>`: push, pop, peek, `isEmpty`, `isFull`
- `Queue<T>`: enqueue, dequeue, peek, `isEmpty`, `isFull`
- `LinkedList<T>`: add first, add last, insert, delete, get
- Custom `Iterator<T>` and `Iterable<T>` interfaces
- `LinearStructure<T>` interface and `AbstractLinearStructure<T>` base class
- Generic storage examples using `String`, `Employee`, and `Object`
- `BracketValidator` for balanced bracket validation
- JUnit 5 tests

## Run the application

Open `App.java` in Eclipse and select **Run As ? Java Application**.

## Run tests

Right-click `src/test/java` or any `*Test.java` class and select **Run As ? JUnit Test**.

If Maven is installed:

```cmd
mvn test
```
