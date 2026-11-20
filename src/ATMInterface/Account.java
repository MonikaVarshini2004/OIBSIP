package ATMInterface;

public class Account {

    private String userId;
    private String pin;
    private double balance;

    // Constructor
    public Account(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    // Check login details
    public boolean checkPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    // Deposit money
    public void deposit(double amount) {
        balance = balance + amount;
    }

    // Withdraw money
    public boolean withdraw(double amount) {

        if (amount > 0 && balance >= amount) {
            balance = balance - amount;
            return true;
        }

        return false;
    }

}