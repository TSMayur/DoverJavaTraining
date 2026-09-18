package GDB_App;

public abstract class Account {
    private final String accountNumber;
    private final String holderName;
    private double balance;

    protected Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = Math.max(0, balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void updateBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
            return;
        }

        updateBalance(balance + amount);
        System.out.println("Deposit successful: " + amount);
    }

    public abstract void withdraw(double amount);

    public void displayAccountDetails() {
        System.out.println("Type: " + getClass().getSimpleName());
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}
