package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Please choose the method (1 for regex method, 2 for non-regex method, 0 to exit):");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                exit = true;
                continue;
            }

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please choose 1, 2, or 0 to exit.");
                continue;
            }

            System.out.println("Please enter an address (or multiple addresses separated by newline):");
            String input = scanner.nextLine();
            String[] lines = input.split("\n");
            StringBuilder result = new StringBuilder();

            for (String line : lines) {
                String convertedLine = (choice == 1) ? AddressConverterWithRegex.convert(line) : AddressConverterWithoutRegex.convert(line);
                result.append(convertedLine).append("\n");
            }

            System.out.println("Converted Address:");
            System.out.print(result);
        }
        scanner.close();
    }
}