package GDB_App;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class AccountTest {
    private static final double DELTA = 0.000001;

    @TestFactory
    Stream<DynamicTest> accountRules() {
        List<DynamicTest> tests = new ArrayList<>();

        List<Supplier<Account>> accountTypes = List.of(
                () -> new SavingsAccount("S1", "Ravi", 1000, 6.5, 100),
                () -> new CurrentAccount("C1", "Priya", 1000, 500),
                () -> new FixedDepositAccount("F1", "Amit", 1000, 7.5, 3),
                () -> new SalaryAccount("SA1", "Neha", 1000, "Dover", 50000));

        for (Supplier<Account> type : accountTypes) {
            for (int amount = 1; amount <= 100; amount++) {
                double value = amount;
                tests.add(DynamicTest.dynamicTest("deposit " + value, () -> {
                    Account account = type.get();
                    quietly(() -> account.deposit(value));
                    assertEquals(1000 + value, account.getBalance(), DELTA);
                }));
            }

            for (double value : new double[] { 0, -1 }) {
                tests.add(DynamicTest.dynamicTest("reject invalid deposit " + value, () -> {
                    Account account = type.get();
                    quietly(() -> account.deposit(value));
                    assertEquals(1000, account.getBalance(), DELTA);
                }));
            }
        }

        for (int amount = 1; amount <= 100; amount++) {
            double value = amount * 80;
            tests.add(DynamicTest.dynamicTest("savings allows " + value, () -> {
                Account account = new SavingsAccount("S1", "Ravi", 10000, 6.5, 2000);
                quietly(() -> account.withdraw(value));
                assertEquals(10000 - value, account.getBalance(), DELTA);
            }));
        }

        for (int amount = 1; amount <= 100; amount++) {
            double value = 8000 + amount;
            tests.add(DynamicTest.dynamicTest("savings rejects below-minimum " + value, () -> {
                Account account = new SavingsAccount("S1", "Ravi", 10000, 6.5, 2000);
                quietly(() -> account.withdraw(value));
                assertEquals(10000, account.getBalance(), DELTA);
            }));
        }

        for (int amount = 1; amount <= 150; amount++) {
            double value = amount * 100;
            tests.add(DynamicTest.dynamicTest("current allows overdraft " + value, () -> {
                Account account = new CurrentAccount("C1", "Priya", 5000, 10000);
                quietly(() -> account.withdraw(value));
                assertEquals(5000 - value, account.getBalance(), DELTA);
            }));
        }

        for (int amount = 1; amount <= 100; amount++) {
            double value = 15000 + amount;
            tests.add(DynamicTest.dynamicTest("current rejects excess overdraft " + value, () -> {
                Account account = new CurrentAccount("C1", "Priya", 5000, 10000);
                quietly(() -> account.withdraw(value));
                assertEquals(5000, account.getBalance(), DELTA);
            }));
        }

        for (int amount = 1; amount <= 100; amount++) {
            double value = amount * 100;
            tests.add(DynamicTest.dynamicTest("fixed deposit rejects withdrawal " + value, () -> {
                Account account = new FixedDepositAccount("F1", "Amit", 50000, 7.5, 3);
                quietly(() -> account.withdraw(value));
                assertEquals(50000, account.getBalance(), DELTA);
            }));
        }

        for (int amount = 1; amount <= 100; amount++) {
            double value = amount * 10;
            tests.add(DynamicTest.dynamicTest("salary allows " + value, () -> {
                Account account = new SalaryAccount("SA1", "Neha", 1000, "Dover", 50000);
                quietly(() -> account.withdraw(value));
                assertEquals(1000 - value, account.getBalance(), DELTA);
            }));
        }

        for (int amount = 1; amount <= 100; amount++) {
            double value = 1000 + amount;
            tests.add(DynamicTest.dynamicTest("salary rejects insufficient balance " + value, () -> {
                Account account = new SalaryAccount("SA1", "Neha", 1000, "Dover", 50000);
                quietly(() -> account.withdraw(value));
                assertEquals(1000, account.getBalance(), DELTA);
            }));
        }

        tests.add(DynamicTest.dynamicTest("savings interest", () ->
                assertEquals(650, new SavingsAccount("S1", "Ravi", 10000, 6.5, 2000).calculateInterest(), DELTA)));
        tests.add(DynamicTest.dynamicTest("fixed deposit maturity", () ->
                assertEquals(61250, new FixedDepositAccount("F1", "Amit", 50000, 7.5, 3)
                        .calculateMaturityAmount(), DELTA)));

        return tests.stream();
    }

    private void quietly(Runnable operation) {
        PrintStream original = System.out;
        try {
            System.setOut(new PrintStream(OutputStream.nullOutputStream()));
            operation.run();
        } finally {
            System.setOut(original);
        }
    }
}
