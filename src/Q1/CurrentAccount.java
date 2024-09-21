package Q1;

public class CurrentAccount extends Account {
    private static int maxFreeTransaction = 3;
    private static double nominalTransactionFee = 2.0;
    private int transactionCount;

    CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
        this.transactionCount = 0;
    }

    public static int getMaxFreeTransaction() { return maxFreeTransaction; }
    public static double getNominalTransactionFee() { return nominalTransactionFee; }
    public int getTransactionCount() { return this.transactionCount; }

    public static void setMaxFreeTransaction(int maxFreeTransaction) { CurrentAccount.maxFreeTransaction = maxFreeTransaction; }
    public static void setNominalTransactionFee(double nominalTransactionFee) { CurrentAccount.nominalTransactionFee = maxFreeTransaction; }
    public void setTransactionCount(int transactionCount) { this.transactionCount = transactionCount; }

    public void incrementTransactionCount() {
        ++this.transactionCount;
    }

    private void chargeTransactionFee() {
        System.out.printf("""
                You exceeded the the maximum free transactions, RM%.2f will be charged.
                Your updated transaction count: %d
                """, CurrentAccount.getNominalTransactionFee(), this.getTransactionCount());

        this.balance -= CurrentAccount.getNominalTransactionFee();
    }

    @Override
    public boolean withdrawal(double amount) {
        if (amount > this.balance - 2) return false;

        this.balance -= amount;
        this.incrementTransactionCount();

        if (this.transactionCount > CurrentAccount.getMaxFreeTransaction()) this.chargeTransactionFee();
        return true;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;

        this.incrementTransactionCount();
        if (this.transactionCount > CurrentAccount.getMaxFreeTransaction()) this.chargeTransactionFee();
    }



    @Override
    public String toString() {
        return String.format("Account Number: %s\nBalance: %.2f\nDate Created: %s\nTransaction Count: %s\n",
                this.accountNumber,
                this.balance,
                this.dateCreated,
                this.transactionCount
        );
    }
}
