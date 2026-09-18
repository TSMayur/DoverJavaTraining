# Assignments 2 and 3 – Bank Account System

This project demonstrates Java classes, encapsulation, constructors, inheritance, and runtime polymorphism.

## Account types

- `SavingsAccount` – preserves a minimum balance and calculates interest.
- `CurrentAccount` – supports an overdraft limit.
- `FixedDepositAccount` – calculates maturity amount and rejects withdrawals before maturity.
- `SalaryAccount` – standard balance-based withdrawals with company and salary details.

`Account` is the abstract parent class. `AccountMain` demonstrates deposits, withdrawals, interest, maturity amount, and polymorphic `withdraw()` calls.

## Run

Open `AccountMain.java` and select **Run As ? Java Application**.

## Tests

The JUnit test class is located at:

```text
test/GDB_App/AccountTest.java
```

Right-click it in Eclipse and select **Run As ? JUnit Test**.
