package telran.multithreading;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String WINNERS_FILE = "winners.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. New Race");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            if (option == 2) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            if (option == 1) {
                System.out.print("Enter the number of racers: ");
                int numRacers = scanner.nextInt();

                System.out.print("Enter the race distance (number of iterations): ");
                int distance = scanner.nextInt();

                Race race = new Race(distance, 10, 100);
                Racer[] racers = new Racer[numRacers];

                for (int i = 0; i < numRacers; i++) {
                    racers[i] = new Racer(race, i + 1);
                    racers[i].start();
                }

                for (Racer racer : racers) {
                    try {
                        racer.join();
                    } catch (InterruptedException e) {
                        System.out.println("Error waiting for racer to finish.");
                    }
                }

                int winner = race.getWinner();
                System.out.printf("Congratulations to Racer #%d - the winner!%n", winner);

                writeWinnerToFile(winner, numRacers, distance);
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void writeWinnerToFile(int winner, int numRacers, int distance) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(WINNERS_FILE, true))) {
            writer.write(
                    String.format("Winner: Racer #%d, Total racers: %d, Distance: %d%n", winner, numRacers, distance));
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
