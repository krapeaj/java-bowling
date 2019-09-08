package bowling.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserPrompt {
    private static final int ACCEPTED_LENGTH = 3;

    private static String takeInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int takeNumberOfPlayers() {
        try {
            String input = takeInput();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Only numbers (0~10) are allowed.");
            return takeNumberOfPlayers();
        }
    }

    private static String validateName(String name) {
        if (name.length() != ACCEPTED_LENGTH) {
            throw new IllegalArgumentException("Requres 3 letters.");
        }
        return name;
    }

    private static String promptUserForName(int number) {
        try {
            System.out.printf("Player %d's name (3 english letters): ", number);
            return validateName(takeInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return promptUserForName(number);
        }
    }

    public static List<String> promptUserForNames() {
        System.out.println("Number of players? ");
        int numberOfPeople = takeNumberOfPlayers();
        List<String> playerNames = new ArrayList<>();
        for (int number = 0; number < numberOfPeople; number++) {
            String name = promptUserForName(number);
            playerNames.add(name);
        }
        return playerNames;
    }

    public static int promptUserForBowl(String name) {
        try {
            System.out.printf("%s's turn: ", name);
            String input = takeInput();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Only numbers (0~10) are allowed.");
            return promptUserForBowl(name);
        }
    }
}