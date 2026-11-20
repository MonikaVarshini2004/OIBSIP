package ATMInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String accountId;
    private String type;
    private double amount;
    private String details;
    private String dateTime;

    // Constructor
    public Transaction(String accountId, String type,
                       double amount, String details) {

        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.details = details;

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter format =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        this.dateTime = now.format(format);
    }

    // Display transaction details
    public void displayTransaction() {

        System.out.println("--------------------------------------");
        System.out.println("Date       : " + dateTime);
        System.out.println("Account ID : " + accountId);
        System.out.println("Type       : " + type);
        System.out.println("Amount     : Rs. " + amount);
        System.out.println("Details    : " + details);

    }
    
    public String getAccountId() {
        return accountId;
    }

}
