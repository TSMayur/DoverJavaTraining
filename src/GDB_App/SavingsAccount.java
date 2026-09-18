package GDB_App;

public class SavingsAccount extends Account {
    private double interestRate;
    private double minimumBalance;

    public SavingsAccount(String accountNumber, String holderName, double balance,
            double interestRate, double minimumBalance) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
        } else if (getBalance() - amount < minimumBalance) {
            System.out.println("Withdrawal rejected: minimum balance must be " + minimumBalance);
        } else {
            updateBalance(getBalance() - amount);
            System.out.println("Savings withdrawal successful: " + amount);
        }
    }

    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Minimum Balance: " + minimumBalance);
    }
}
