package Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FootballTeam {
    private List<FootballPlayer> team = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void createPlayer() {
        for (int i = 1; i <= 11; i++) {
            System.out.println("Enter details for player " + i + ":");

            String name = getStringInput("Name: ");
            int shirtNo = getIntInput("Shirt No: ");
            String position = getStringInput("Position: ");
            double height = getDoubleInput("Height (cm): ");
            double weight = getDoubleInput("Weight (kg): ");
            int age = getIntInput("Age: ");

            FootballPlayer player = new FootballPlayer(name, shirtNo, position, weight, height, age);
            team.add(player);
        }
    }

    private String getStringInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                break;
            }
            System.out.println("Invalid input. Please enter a non-empty string.");
        }
        return input;
    }

    private int getIntInput(String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return input;
    }

    private double getDoubleInput(String prompt) {
        double input;
        while (true) {
            System.out.print(prompt);
            try {
                input = Double.parseDouble(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return input;
    }

    public void display() {
        System.out.println("Football Team Players:");
        for (FootballPlayer player : team) {
            System.out.println(player);
        }
    }

    public void actionMenu() {
        while (true) {
            System.out.println("\nSelect a player by shirt number to perform an action:");
            int shirtNo = getIntInput("Shirt No: ");
            FootballPlayer player = getPlayerByShirtNo(shirtNo);

            if (player != null) {
                System.out.println("\nActions:");
                System.out.println("1. Shoot the ball");
                System.out.println("2. Pass the ball");
                System.out.println("3. Score a goal");
                System.out.println("4. Miss the goal");
                System.out.println("5. Exit");

                int action = getIntInput("Select an action: ");
                performAction(player, action);
                if (action == 5) break;
            } else {
                System.out.println("Player not found! Please try again.");
            }
        }
    }

    private FootballPlayer getPlayerByShirtNo(int shirtNo) {
        for (FootballPlayer player : team) {
            if (player.getShirtNo() == shirtNo) {
                return player;
            }
        }
        return null;
    }

    private void performAction(FootballPlayer player, int action) {
        switch (action) {
            case 1:
                player.shoot();
                break;
            case 2:
                int passToShirtNo = getIntInput("Enter the shirt number of the player to pass to: ");
                FootballPlayer passToPlayer = getPlayerByShirtNo(passToShirtNo);
                if (passToPlayer != null) {
                    System.out.println(player.getName() + " is passing to " + passToPlayer.getName() + ".");
                } else {
                    System.out.println("Player to pass to not found!");
                }
                break;
            case 3:
                System.out.println(player.getName() + " scored a goal!");
                break;
            case 4:
                System.out.println(player.getName() + " missed the goal.");
                break;
            case 5:
                System.out.println("Exiting action menu.");
                break;
            default:
                System.out.println("Invalid action! Please select again.");
        }
    }

    public static void main(String[] args) {
        FootballTeam footballTeam = new FootballTeam();
        footballTeam.createPlayer();
        footballTeam.display();
        footballTeam.actionMenu();
    }
}
