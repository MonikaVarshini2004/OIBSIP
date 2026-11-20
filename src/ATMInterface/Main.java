package ATMInterface;


public class Main {

    public static void main(String[] args) {

        // Create Bank object
        Bank bank = new Bank();

        // Create ATM object
        ATM atm = new ATM(bank);

        // Login
        Account account = atm.login();

        // Open ATM menu only after successful login
        if (account != null) {

            atm.showMenu(account);

        }

    }

}

