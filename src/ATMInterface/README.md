# ATM Interface – Java Console Application

**Internship:** Oasis Infobyte Internship Program  
**Task:** Task 3 – ATM Interface  
**Programming Language:** Java  
**Application Type:** Console-Based Application  
**Concepts:** Object-Oriented Programming (OOP), Encapsulation, ArrayList, HashMap, Switch-Case

---

## 1. Project Overview

The ATM Interface is a console-based Java application that simulates the basic operations of an Automated Teller Machine (ATM).

The application allows users to log in using their User ID and PIN and perform banking operations such as withdrawing money, depositing money, transferring funds, and viewing transaction history.

The project is developed using Java Object-Oriented Programming concepts and multiple classes to organize the application structure.

## 2. Features

- **User Authentication:** Login using User ID and PIN.
- **Login Security:** Access is denied after three incorrect login attempts.
- **Transaction History:** View previously performed transactions during the current session.
- **Withdraw Money:** Withdraw money after checking the available account balance.
- **Deposit Money:** Deposit money and update the account balance.
- **Transfer Money:** Transfer money to another registered account.
- **Balance Validation:** Displays an insufficient funds message when the available balance is not enough.
- **Transaction Records:** Stores transaction details using an ArrayList.
- **Menu Navigation:** Uses a switch-case menu to perform different operations.
- **Quit Option:** Allows users to exit the application.

## 3. Technologies Used

- Java
- Java Collections Framework
- ArrayList
- HashMap
- Scanner
- Object-Oriented Programming

## 4. Project Structure

```text
OIBSIP/
│
└── src/
    │
    └── ATMInterface/
        ├── Account.java
        ├── ATM.java
        ├── Bank.java
        ├── Main.java
        ├── Transaction.java
        └── README.md
```

### Class Description

| Class | Description |
|---|---|
| Main | Entry point of the application. |
| ATM | Handles login, menu display, and banking operations. |
| Account | Stores user account details and manages account balance. |
| Transaction | Stores and displays individual transaction details. |
| Bank | Manages accounts, transaction records, and fund transfers. |

## 5. How to Run the Project

### Prerequisites

- Java Development Kit (JDK)
- Eclipse IDE or any Java-supported IDE

### Steps

1. Clone or download this repository.
2. Open Eclipse IDE.
3. Import the project into Eclipse as an existing Java project, or create a new Java project.
4. Create the package `com.atm`.
5. Add all five Java source files.
6. Ensure that each class has the correct package declaration.
7. Open `Main.java`.
8. Right-click and select **Run As → Java Application**.
9. Enter the User ID and PIN to access the ATM menu.

## 6. Sample Login Credentials

The application includes sample accounts for testing.

| User ID | PIN | Initial Balance |
|---|---|---:|
| 1001 | 1234 | ₹10,000 |
| 1002 | 5678 | ₹8,000 |
| 1003 | 9876 | ₹5,000 |

**Note:** These are fictional credentials provided for testing purposes only.

## 7. Application Menu

After successful login, the following menu is displayed:

```text
========== ATM MENU ==========
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit
==============================
```

Users can select an option to perform the corresponding operation.

## 8. Concepts Implemented

This project demonstrates the following Java concepts:

- **Classes and Objects:** Organizing the application into separate classes.
- **Encapsulation:** Using private fields and public methods to manage account information.
- **Constructors:** Initializing account and transaction objects.
- **ArrayList:** Maintaining transaction records.
- **HashMap:** Managing accounts using User IDs.
- **Switch-Case:** Handling menu selections.
- **Loops:** Managing login attempts and menu navigation.
- **Conditional Statements:** Validating account balances and user inputs.
- **Exception Handling:** Handling invalid numerical inputs.
- **Methods:** Separating application operations into reusable methods.

## 9. Limitations

- Account information and balances are stored in memory.
- Transaction history is maintained only during the current application session.
- Data is not permanently stored in a database.
- This project is an educational ATM simulation and is not connected to any real banking system.

## 10. Future Enhancements

- Integrate a MySQL database for permanent account storage.
- Add secure PIN management.
- Implement transaction receipts.
- Add account creation and registration.
- Introduce a graphical user interface.

## 11. Conclusion

The ATM Interface project provides a practical understanding of Java programming and Object-Oriented Programming concepts.

It demonstrates how multiple classes can work together to simulate basic banking operations, manage account balances, validate transactions, and maintain transaction history.

---

**Developed as part of the Oasis Infobyte Internship Program – Task 3.**