package Q1;

import java.time.LocalDate;

public class Account {
    String accountNumber;
    double balance;
    LocalDate dateCreated;

    Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dateCreated = LocalDate.now();
    }

    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setBalance(double balance) { this.balance = balance; }
    public void setDateCreated(LocalDate dateCreated) { this.dateCreated = dateCreated; }

    public String getAccountNumber() { return this.accountNumber; }
    public double getBalance() { return this.balance; }
    public LocalDate getDateCreated() { return this.dateCreated; }


    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdrawal(double amount) {
        if (amount > this.balance) return false;

        this.balance -= amount;
        return true;
    }

    public String toString() {
        return String.format("Account Number: %s\nBalance: %.2f\nDate Created: %s\n", this.accountNumber, this.balance, this.dateCreated);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Account)) return false;


        return this.accountNumber.equals(((Account) obj).accountNumber);
    }
}
