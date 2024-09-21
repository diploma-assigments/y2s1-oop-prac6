package Q1;

import java.util.Scanner;

public class SavingsAccountMenu {
    private static final Scanner scanner = new Scanner(System.in);
    static SavingsAccount savingsAccount;

    public static void main(String[] args) {
        savingsAccount = new SavingsAccount("12345", 2000.0);
        mainMenu();
    }

    static void mainMenu() {
        while (true) {
            System.out.printf("""
                \n\nSavings Account: %s
                Your Balance: RM%.2f
                
                1 - Deposit
                2 - Withdrawal
                0 - Exit
                
                > 
                """, savingsAccount.getAccountNumber(), savingsAccount.getBalance());

            int selection = scanner.nextInt();
            if (selection == 1) { deposit(); }
            else if (selection == 2) { withdrawal(); }
            else break;
        }
    }

    static void deposit() {
        System.out.printf("""
                 Deposit
                =========
                Savings Account: %s
                Your Balance: %.2f
                
                Deposit Amount: RM
                """, savingsAccount.getAccountNumber(), savingsAccount.getBalance());

        double depositAmount = scanner.nextDouble();
        savingsAccount.deposit(depositAmount);

        System.out.printf("Updated balance: RM%.2f\n", savingsAccount.getBalance());
    }

    static void withdrawal() {
        System.out.printf("""
                 Withdrawal
                ============
                Savings Account: %s
                Your Balance: %.2f
                
                Withdraw Amount: RM
                """, savingsAccount.getAccountNumber(), savingsAccount.getBalance());
        double withdrawalAmount = scanner.nextDouble();

        boolean result = savingsAccount.withdrawal(withdrawalAmount);

        if (result) {
            System.out.println("Withdrawal successful");
            System.out.printf("Updated account balance is: RM%.2f\n", savingsAccount.getBalance());
        } else {
            System.out.println("Withdrawal declined");
        }
    }

    static void addInterest(SavingsAccount savingsAccount) {
        System.out.printf("\nSavings account %s has balance before interest: RM%.2f\n", savingsAccount.getAccountNumber(), savingsAccount.getBalance());

        System.out.printf("Adding interest of RM%.2f\n", savingsAccount.calculateInterestRate());
        savingsAccount.addInterest();

        System.out.printf("The updated balance of account is: RM%.2f\n", savingsAccount.getBalance());
    }
}
