package Q1;

import java.util.Scanner;

public class CurrentAccountMenu {
    private static final Scanner scanner = new Scanner(System.in);
    static CurrentAccount currentAccount;

    public static void main(String[] args) {
        currentAccount = new CurrentAccount("12345", 2000.0);

        CurrentAccount anotherCurrentAccount = new CurrentAccount("54321", 1400.0);
        if (currentAccount.equals(anotherCurrentAccount)) System.out.println("They have the same account number.");
        else System.out.println("They don't have the same account number.");

        mainMenu();
    }

    static void mainMenu() {
        while (true) {
            System.out.printf("""
                \n\n%s
                
                1 - Deposit
                2 - Withdrawal
                0 - Exit
                
                > 
                """, currentAccount);

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
                %s
                
                Deposit Amount: RM
                """, currentAccount);

        double depositAmount = scanner.nextDouble();
        currentAccount.deposit(depositAmount);
        System.out.printf("Updated balance: RM%.2f\n", currentAccount.getBalance());
    }

    static void withdrawal() {
        System.out.printf("""
                 Withdrawal
                ============
                %s
                
                Withdraw Amount: RM
                """, currentAccount);

        double withdrawalAmount = scanner.nextDouble();
        boolean result = currentAccount.withdrawal(withdrawalAmount);

        if (result) {
            System.out.println("Withdrawal successful");
            System.out.printf("Updated account balance is: RM%.2f\n", currentAccount.getBalance());
        } else {
            System.out.println("Withdrawal declined");
        }
    }


}
