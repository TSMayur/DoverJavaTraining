package GDB_App;

public class SalaryAccount extends Account {
    private String companyName;
    private double monthlySalary;

    public SalaryAccount(String accountNumber, String holderName, double balance,
            String companyName, double monthlySalary) {
        super(accountNumber, holderName, balance);
        this.companyName = companyName;
        this.monthlySalary = monthlySalary;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0 || amount > getBalance()) {
            System.out.println("Withdrawal rejected: invalid amount or insufficient balance.");
        } else {
            updateBalance(getBalance() - amount);
            System.out.println("Salary-account withdrawal successful: " + amount);
        }
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Company: " + companyName);
        System.out.println("Monthly Salary: " + monthlySalary);
    }
}
