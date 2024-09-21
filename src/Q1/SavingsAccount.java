package Q1;

public class SavingsAccount extends Account {
    private static double interestRate = 0.05;

    SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        SavingsAccount.interestRate = interestRate;
    }

    public double calculateInterestRate() {
        return getBalance() * interestRate / 12;
    }

    public void addInterest() {
        deposit(calculateInterestRate());
    }
}
