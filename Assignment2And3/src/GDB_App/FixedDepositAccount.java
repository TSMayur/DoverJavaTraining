package GDB_App;

public class FixedDepositAccount extends Account {
    private double interestRate;
    private int tenureInYears;

    public FixedDepositAccount(String accountNumber, String holderName, double balance,
            double interestRate, int tenureInYears) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
        this.tenureInYears = tenureInYears;
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawal rejected: fixed deposit cannot be withdrawn before maturity.");
    }

    public double calculateMaturityAmount() {
        return getBalance() + (getBalance() * interestRate * tenureInYears / 100);
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Tenure: " + tenureInYears + " years");
    }
}