package ATMInterface;


import java.util.Scanner;

public class ATM {

    private Bank bank;
    private Scanner sc;

    // Constructor
    public ATM(Bank bank) {
        this.bank = bank;
        sc = new Scanner(System.in);
    }

    // Login method
    public Account login() {

        int attempts = 0;

        System.out.println("==================================");
        System.out.println("       WELCOME TO ATM");
        System.out.println("==================================");

        while (attempts < 3) {

            System.out.print("Enter User ID: ");
            String userId = sc.nextLine().trim();

            System.out.print("Enter PIN: ");
            String pin = sc.nextLine().trim();

            if (bank.validateLogin(userId, pin)) {

                System.out.println("\nLogin Successful!");
                System.out.println("Welcome, " + userId);

                return bank.getAccount(userId);
            }

            attempts++;

            System.out.println("Invalid User ID or PIN!");

            System.out.println(
                "Attempts remaining: " + (3 - attempts)
            );
        }

        System.out.println("\nAccess Denied!");
        System.out.println("Too many incorrect attempts.");

        return null;
    }

    // Main ATM menu
    public void showMenu(Account account) {

        int choice=0;

        do {

            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid menu number.");
                continue;
            }

            // Perform operation based on user choice
            switch (choice) {

                case 1:
                    bank.showTransactionHistory(account.getUserId());
                    break;

                case 2:
                    withdraw(account);
                    break;

                case 3:
                    deposit(account);
                    break;

                case 4:
                    transfer(account);
                    break;

                case 5:
                    System.out.println("\nThank you for using our ATM!");
                    System.out.println("Have a nice day!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");

            }

        } while (choice != 5);

    }

    // Withdraw money
    private void withdraw(Account account) {

        System.out.print("Enter withdrawal amount: Rs. ");

        double amount;

        try {
            amount = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount!");
            return;
        }

        // Check sufficient balance
        if (amount <= 0) {
            System.out.println("Enter a valid positive amount.");
        }

        else if (account.getBalance() < amount) {
            System.out.println("Insufficient Funds!");
        }

        else if (account.withdraw(amount)) {

            bank.addTransaction(new Transaction(
                account.getUserId(),
                "WITHDRAWAL",
                amount,
                "Cash withdrawn"
            ));

            System.out.println("Withdrawal Successful!");
            System.out.println("Remaining Balance: Rs. "
                + account.getBalance());

        }

    }

    // Deposit money
    private void deposit(Account account) {

        System.out.print("Enter deposit amount: Rs. ");

        double amount;

        try {
            amount = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount!");
            return;
        }

        if (amount <= 0) {

            System.out.println("Enter a valid positive amount.");

            return;
        }

        account.deposit(amount);

        bank.addTransaction(new Transaction(
            account.getUserId(),
            "DEPOSIT",
            amount,
            "Cash deposited"
        ));

        System.out.println("Deposit Successful!");

        System.out.println("Updated Balance: Rs. "
            + account.getBalance());

    }

    // Transfer money
    private void transfer(Account sender) {

        System.out.print("Enter recipient Account ID: ");

        String recipientId = sc.nextLine().trim();

        Account receiver = bank.getAccount(recipientId);

        if (receiver == null) {

            System.out.println("Recipient account not found!");

            return;
        }

        if (sender == receiver) {

            System.out.println("Cannot transfer to your own account!");

            return;
        }

        System.out.print("Enter transfer amount: Rs. ");

        double amount;

        try {
            amount = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount!");
            return;
        }

        if (amount <= 0) {

            System.out.println("Enter a valid positive amount.");

        }

        else if (sender.getBalance() < amount) {

            System.out.println("Insufficient Funds!");

        }

        else if (bank.transfer(sender, receiver, amount)) {

            System.out.println("Transfer Successful!");

            System.out.println("Transferred to: " + recipientId);

            System.out.println("Remaining Balance: Rs. "
                + sender.getBalance());

        }

    }

}

