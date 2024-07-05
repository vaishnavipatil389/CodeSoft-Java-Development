import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10; // Maximum number of attempts allowed per game
        int score = 0; // Variable to keep track of user's score

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("\nI'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            boolean guessedCorrectly = false;
            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else if (userGuess > generatedNumber) {
                    System.out.println("Too high! Try a lower number.");
                } else {
                    System.out.println("Congratulations! You guessed the number (" + generatedNumber + ") in " + attempt + " attempts.");
                    guessedCorrectly = true;
                    score += attempt;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you didn't guess the number. It was " + generatedNumber + ".");
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        } while (true);

        System.out.println("\nGame Over. Your total score is: " + score);

        scanner.close();
    }
}
