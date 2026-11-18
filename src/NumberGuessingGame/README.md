# Number Guessing Game – Java Swing Application

**Internship:** Oasis Infobyte Internship Program  
**Task:** Task 2 – Number Guessing Game  
**Programming Language:** Java  
**Application Type:** Desktop GUI Application  
**GUI Framework:** Java Swing  
**Concepts:** Random Number Generation, Event Handling, Exception Handling, Conditional Statements, Loops

---

## 1. Project Overview

The Number Guessing Game is a Java-based desktop application developed using Java Swing.

In this game, the application generates a random number, and the player has to guess the correct number within the selected number of attempts.

The player can choose from three difficulty levels: Easy, Medium, and Hard. The application provides hints to help the player identify whether the entered number is too high or too low.

It also includes input validation, score calculation, and a Play Again option.

## 2. Features

- **Random Number Generation:** Generates a random number within the selected difficulty range.
- **Difficulty Selection:** Allows players to choose Easy, Medium, or Hard.
- **Custom Attempts:** Allows players to select the maximum number of attempts.
- **Guess Validation:** Checks whether the entered value is a valid integer.
- **Range Validation:** Ensures that guesses are within the selected number range.
- **Hints:** Displays whether the guessed number is too high or too low.
- **Win Message:** Displays a congratulatory message when the correct number is guessed.
- **Game Over:** Displays the correct number when all attempts are used.
- **Score Tracking:** Awards points based on the number of attempts taken.
- **Play Again:** Allows players to start a new round.
- **Enter Key Support:** Players can submit their guesses by pressing the Enter key.

## 3. Difficulty Levels

The game provides three difficulty levels:

| Difficulty | Number Range | Default Attempts |
|---|---:|---:|
| Easy | 1–50 | 7 |
| Medium | 1–100 | 7 |
| Hard | 1–200 | 7 |

Players can also customize the maximum number of attempts from 1 to 50 using the attempts selector.

**Note:** Medium mode uses the original task requirement of guessing a number between 1 and 100 with 7 attempts by default.

## 4. Technologies Used

- Java
- Java Swing
- AWT
- Random Class
- Exception Handling
- Event Handling

## 5. Project Structure

```text
NumberGuessingGame/
│
├── README.md
│
└── src/
    └── com/
        └── NumberGuessingGame.java
```

## 6. How to Run the Project

### Prerequisites

- Java Development Kit (JDK)
- Eclipse IDE or any Java-supported IDE

### Steps

1. Clone or download the repository.
2. Open Eclipse IDE.
3. Import the project into Eclipse or create a new Java project.
4. Create a package named `com`.
5. Create a Java class named `NumberGuessingGame`.
6. Add the source code to the Java class.
7. Open `NumberGuessingGame.java`.
8. Right-click and select **Run As → Java Application**.
9. The Number Guessing Game window will appear.
10. Select a difficulty level and maximum attempts to start playing.

## 7. How to Play

1. Launch the application.
2. Select a difficulty level.
3. Choose the maximum number of attempts.
4. Enter a number in the input field.
5. Click the **Submit Guess** button or press Enter.
6. Read the hint displayed by the application.
7. Continue guessing until you find the correct number or run out of attempts.
8. Click **Play Again** to start another round.

## 8. Scoring System

The score depends on the selected maximum attempts and the number of guesses taken.

The scoring formula is:

```text
Points = (Maximum Attempts × 10)
         - ((Attempts Used - 1) × 10)
```

A correct guess on the first attempt earns the maximum points. Each additional attempt reduces the points by 10.

An unsuccessful round does not award any points.

The total score is maintained across multiple rounds during the application session.

## 9. Concepts Implemented

This project demonstrates the following Java concepts:

- **JFrame:** Creates the main application window.
- **JPanel:** Organizes GUI components.
- **JLabel:** Displays instructions and game messages.
- **JTextField:** Accepts user input.
- **JButton:** Handles user actions.
- **JComboBox:** Provides difficulty selection.
- **JSpinner:** Allows users to select the maximum attempts.
- **GridLayout:** Arranges GUI components.
- **ActionListener:** Handles button clicks and Enter key events.
- **Random:** Generates random numbers.
- **Conditional Statements:** Checks whether the guess is correct, too high, or too low.
- **Exception Handling:** Handles invalid numerical input.
- **Static Variables:** Maintains game state and score.

## 10. Limitations

- The game is designed for a single player.
- The score is maintained only during the current application session.
- Player scores are not permanently stored.
- The application requires a Java-supported desktop environment.

## 11. Future Enhancements

- Add a high-score leaderboard.
- Store player scores using a database.
- Add sound effects and animations.
- Improve the graphical interface with custom themes.
- Add player names and individual score tracking.

## 12. Conclusion

The Number Guessing Game provides a practical understanding of Java programming and GUI development using Java Swing.

It demonstrates random number generation, event handling, input validation, difficulty selection, and score management through an interactive desktop application.

---

**Developed as part of the Oasis Infobyte Internship Program – Task 2.**