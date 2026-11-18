
package NumberGuessingGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NumberGuessingGame {

    // Game settings
    private static int minNumber = 1;
    private static int maxNumber = 100;
    private static int maxAttempts = 7;

    // Game variables
    private static int targetNumber;
    private static int attempts;
    private static int score = 0;
    private static boolean gameOver = false;

    // GUI components
    private static JFrame frame;
    private static JComboBox<String> difficultyBox;
    private static JSpinner attemptsSpinner;
    private static JTextField guessField;

    private static JButton guessButton;
    private static JButton playAgainButton;

    private static JLabel messageLabel;
    private static JLabel attemptsLabel;
    private static JLabel scoreLabel;

    private static final Random random = new Random();

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> createGUI());

    }

    // Create GUI
    private static void createGUI() {

        frame = new JFrame("Number Guessing Game");

        frame.setSize(500, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(12, 1, 10, 10));

        panel.setBorder(
            BorderFactory.createEmptyBorder(20, 30, 20, 30)
        );

        // Title
        JLabel titleLabel = new JLabel(
            "NUMBER GUESSING GAME",
            JLabel.CENTER
        );

        titleLabel.setFont(
            new Font("Arial", Font.BOLD, 22)
        );

        // Instructions
        JLabel instructionLabel = new JLabel(
            "Choose your settings and start guessing!",
            JLabel.CENTER
        );

        // Difficulty label
        JLabel difficultyLabel = new JLabel(
            "Select Difficulty:",
            JLabel.CENTER
        );

        // Difficulty dropdown
        String[] levels = {"Easy", "Medium", "Hard"};

        difficultyBox = new JComboBox<>(levels);

        difficultyBox.setSelectedItem("Medium");

        // Attempts label
        JLabel attemptsInputLabel = new JLabel(
            "Choose Maximum Attempts (1-50):",
            JLabel.CENTER
        );

        // User-selected attempts
        attemptsSpinner = new JSpinner(
            new SpinnerNumberModel(7, 1, 50, 1)
        );

        // Guess input
        guessField = new JTextField();

        guessField.setHorizontalAlignment(
            JTextField.CENTER
        );

        guessField.setFont(
            new Font("Arial", Font.PLAIN, 18)
        );

        // Submit button
        guessButton = new JButton("Submit Guess");

        // Message
        messageLabel = new JLabel(
            "Make your first guess!",
            JLabel.CENTER
        );

        // Attempts remaining
        attemptsLabel = new JLabel(
            "Attempts remaining: 7",
            JLabel.CENTER
        );

        // Score
        scoreLabel = new JLabel(
            "Your Score: 0",
            JLabel.CENTER
        );

        // Play Again button
        playAgainButton = new JButton("Play Again");

        playAgainButton.setEnabled(false);

        // Add components
        panel.add(titleLabel);
        panel.add(instructionLabel);
        panel.add(difficultyLabel);
        panel.add(difficultyBox);
        panel.add(attemptsInputLabel);
        panel.add(attemptsSpinner);
        panel.add(guessField);
        panel.add(guessButton);
        panel.add(messageLabel);
        panel.add(attemptsLabel);
        panel.add(scoreLabel);
        panel.add(playAgainButton);

        frame.add(panel);

        // Submit button event
        guessButton.addActionListener(e -> checkGuess());

        // Enter key event
        guessField.addActionListener(e -> checkGuess());

        // Difficulty change event
        difficultyBox.addActionListener(e -> startNewGame());

        // Attempts change event
        attemptsSpinner.addChangeListener(e -> startNewGame());

        // Play Again event
        playAgainButton.addActionListener(e -> startNewGame());

        // Start first game
        startNewGame();

        frame.setVisible(true);

    }

    // Set difficulty range
    private static void setDifficulty() {

        String level = (String) difficultyBox.getSelectedItem();

        switch (level) {

            case "Easy":

                minNumber = 1;
                maxNumber = 50;

                break;

            case "Medium":

                minNumber = 1;
                maxNumber = 100;

                break;

            case "Hard":

                minNumber = 1;
                maxNumber = 200;

                break;

        }

    }

    // Start new game
    private static void startNewGame() {

        setDifficulty();

        // Get attempts selected by user
        maxAttempts = (Integer) attemptsSpinner.getValue();

        // Generate random number
        targetNumber = random.nextInt(
            maxNumber - minNumber + 1
        ) + minNumber;

        attempts = 0;
        gameOver = false;

        guessField.setText("");
        guessField.setEnabled(true);

        guessButton.setEnabled(true);
        playAgainButton.setEnabled(false);

        messageLabel.setText(
            "Guess a number between "
            + minNumber + " and " + maxNumber
        );

        attemptsLabel.setText(
            "Attempts remaining: " + maxAttempts
        );

        scoreLabel.setText(
            "Your Score: " + score
        );

        guessField.requestFocusInWindow();

    }

    // Check guess
    private static void checkGuess() {

        if (gameOver) {
            return;
        }

        String input = guessField.getText().trim();

        // Empty input validation
        if (input.isEmpty()) {

            messageLabel.setText("Please enter a number!");

            return;
        }

        int guess;

        // Integer validation
        try {

            guess = Integer.parseInt(input);

        } catch (NumberFormatException ex) {

            messageLabel.setText(
                "Invalid input! Enter a whole number."
            );

            return;
        }

        // Range validation
        if (guess < minNumber || guess > maxNumber) {

            messageLabel.setText(
                "Enter a number between "
                + minNumber + " and " + maxNumber
            );

            return;
        }

        // Count valid guesses
        attempts++;

        // Correct guess
        if (guess == targetNumber) {

            int points = maxAttempts * 10
                - (attempts - 1) * 10;

            score += points;

            messageLabel.setText(
                "Congratulations! You won! +"
                + points + " points"
            );

            endGame();

        }

        // Too low
        else if (guess < targetNumber) {

            messageLabel.setText(
                "Too low! Try a higher number."
            );

        }

        // Too high
        else {

            messageLabel.setText(
                "Too high! Try a lower number."
            );

        }

        // Update attempts
        int remaining = maxAttempts - attempts;

        attemptsLabel.setText(
            "Attempts remaining: " + remaining
        );

        // Update score
        scoreLabel.setText(
            "Your Score: " + score
        );

        // Check attempts limit
        if (!gameOver && attempts >= maxAttempts) {

            messageLabel.setText(
                "Game Over! Correct number: " + targetNumber
            );

            endGame();

        }

        guessField.setText("");

        if (!gameOver) {
            guessField.requestFocusInWindow();
        }

    }

    // End game
    private static void endGame() {

        gameOver = true;

        guessField.setEnabled(false);
        guessButton.setEnabled(false);
        playAgainButton.setEnabled(true);

    }

}
