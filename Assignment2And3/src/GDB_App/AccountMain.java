package GDB_App;

public class AccountMain {
    public static void main(String[] args) {
        Account savings = new SavingsAccount("S101", "Ravi", 10000, 6.5, 2000);
        Account current = new CurrentAccount("C101", "Priya", 5000, 10000);
        Account fixedDeposit = new FixedDepositAccount("F101", "Amit", 50000, 7.5, 3);
        Account salary = new SalaryAccount("SA101", "Neha", 12000, "Dover", 50000);

        Account[] accounts = { savings, current, fixedDeposit, salary };

        System.out.println("--- Account Details ---");
        for (Account account : accounts) {
            account.displayAccountDetails();
            System.out.println();
        }

        savings.deposit(2000);
        savings.withdraw(3000);

        current.deposit(5000);
        current.withdraw(12000);

        fixedDeposit.withdraw(10000);

        System.out.println("Ravi interest: " + ((SavingsAccount) savings).calculateInterest());
        System.out.println("Amit maturity amount: " + ((FixedDepositAccount) fixedDeposit).calculateMaturityAmount());

        System.out.println("\n--- Final Balances ---");
        for (Account account : accounts) {
            System.out.println(account.getAccountNumber() + ": " + account.getBalance());
        }
    }
}