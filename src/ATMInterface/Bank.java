package ATMInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {

    private HashMap<String, Account> accounts;
    private ArrayList<Transaction> transactions;

    // Constructor
    public Bank() {

        accounts = new HashMap<>();
        transactions = new ArrayList<>();

        // Sample accounts for testing
        accounts.put("1001", new Account("1001", "1234", 10000));
        accounts.put("1002", new Account("1002", "5678", 8000));
        accounts.put("1003", new Account("1003", "9876", 5000));

    }

    // Find account using User ID
    public Account getAccount(String userId) {
        return accounts.get(userId);
    }

    // Check login
    public boolean validateLogin(String userId, String pin) {

        Account account = accounts.get(userId);

        if (account != null && account.checkPin(pin)) {
            return true;
        }

        return false;
    }

    // Add transaction to history
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Display transaction history for an account
    public void showTransactionHistory(String userId) {

        boolean found = false;

        System.out.println("\n========== TRANSACTION HISTORY ==========");

        for (Transaction transaction : transactions) {

            if (transaction.getAccountId().equals(userId)) {
                transaction.displayTransaction();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No transactions found.");
        }

        System.out.println("=========================================");
    }

    // Transfer money between two accounts
    public boolean transfer(Account sender, Account receiver, double amount) {

        if (sender == null || receiver == null || sender == receiver) {
            return false;
        }

        if (amount <= 0 || sender.getBalance() < amount) {
            return false;
        }

        // Deduct from sender and add to receiver
        if (sender.withdraw(amount)) {

            receiver.deposit(amount);

            addTransaction(new Transaction(
                sender.getUserId(),
                "TRANSFER SENT",
                amount,
                "Transferred to account " + receiver.getUserId()
            ));

            addTransaction(new Transaction(
                receiver.getUserId(),
                "TRANSFER RECEIVED",
                amount,
                "Received from account " + sender.getUserId()
            ));

            return true;
        }

        return false;
    }

}
