package main;
import java.util.*;

// Creating a custom plate method for the user to input their own plate
public class ChickenDMV100 {

    // Method to validate the custom plate format
    public static boolean validCustomPlate(String plate) {
        // If plate length isnt long enough, returns false
    if (plate.length() < 2 || plate.length() > 8) {
        return false;
    }
    // Check each character in the plate to ensure it is a letter, digit, or hyphen
    int counter = 0;
    while (counter < plate.length()) {
        char currentCharacter = plate.charAt(counter);
        if (!Character.isLetter(currentCharacter) &&
            !Character.isDigit(currentCharacter) &&
            currentCharacter != '-') {
            return false;
        }
        counter++;
    }

    return true;
}
    public static void customplate(Scanner scanner) {
        System.out.println("Enter your custom plate:");
         // Converting the custom plate to uppercase for consistency
        String plate = scanner.nextLine().toUpperCase();
        // Creating a validation for the custom plate length. Will loop until valid
         while (!validCustomPlate(plate)) {
            // Display an error message and prompt the user to re-enter the plate
        System.out.println("\u001B[31mInvalid plate format. Plate must be between 2 and 8 characters and can only contain letters, digits, and hyphens.\u001B[0m");
        System.out.print("Enter your custom plate: ");
        plate = scanner.nextLine().toUpperCase();

    }

    // Creating variables to calculate price
    int letterCount = 0;
    int numberCount = 0;
    int counter = 0;
    // Loop through each character in the plate to count letters and numbers
    while (counter < plate.length()) {

        char currentCharacter = plate.charAt(counter);

    if (Character.isLetter(currentCharacter)) {
        letterCount++;
    } else if (Character.isDigit(currentCharacter)) {
        numberCount++;
    }

    counter++;
}

    // Calculating the price based on the number of letters and numbers
    double cost = 45.00 + (letterCount * 1.25) + (numberCount * 1.00);

    // Will print plate and price when valid input is received
    System.out.println("Your custom plate is: " + plate);
    System.out.printf("Plate cost: $%.2f%n", cost);


    }

    // creating a method for plate renewal
    public static void plateRenewal(Scanner scanner) {

        // Menu for plate renewal
        System.out.println("============================\n");
        System.out.println("        PLATE RENEWAL");
        System.out.println("============================\n");
        System.out.println("1. Standard Plate Renewal");
        System.out.println("2. Custom Plate Renewal");
        System.out.println("Please select an option: ");
        
        int renewalChoice = scanner.nextInt();
        switch (renewalChoice) {
            case 1:
                // Standard Plate Renewal logic here
                double renewalFee = 45.00 * 0.50;
                System.out.printf("Standard renewal fee: $%.2f%n", renewalFee);
                break;
            case 2:
                // Custom Plate Renewal
                scanner.nextLine();

                System.out.print("Enter your custom plate: ");
                // Reading the custom plate input from the user
                String plate = scanner.nextLine().toUpperCase();
                double customRenewalFee = 22.50 + plate.length();

                // Makes sure the custom plate is valid
                while (!validCustomPlate(plate)) {
                    System.out.println("\u001B[31m Plate must be 2-8 characters and contain only letters, numbers, or dashes.\u001B[0m");

                    System.out.print("Enter your custom plate: ");
                    plate = scanner.nextLine().toUpperCase();
}
                // Printing the plate and renewal fee
                System.out.println("Plate: " + plate);
                // Calculating and printing the custom renewal fee
                System.out.printf("Custom renewal fee: $%.2f%n", customRenewalFee);
                break;
            default:
                // Error catching
                System.out.println("\u001B[31mInvalid option selected.\u001B[0m");
        }
        
    }
    public static void main(String[] args) {

        // Creating a main menu with options for the user to select
        System.out.println("================================\n");
        System.out.println("  Welcome to Chicken DMV 100\n");
        System.out.println("================================");
        System.out.print("SELECT AN OPTION:\n");
        System.out.print("1. Random Plate\n");
        System.out.println("2. Custom Plate\n");
        System.out.print("3. Plate Renewal \n");
        System.out.print("0. Exit\n");
        System.out.println("================================");

        // Prompting the user to enter their choice
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Random Plate option
                System.out.println("Generating a random plate...");
                // Creating a random plate using the characters string
                String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                // Chooses random int values with Math.random()
                int randomIndex = (int) (Math.random() * characters.length());
                // Creating a blank plate value
                String plate = "";
                // Creating blank int value
                int counter = 0;
                // Creating a loop to generate 6 random characters for the plate
                while (counter < 6) {
                    // Generating a random character and appending it to the plate
                    randomIndex = (int) (Math.random() * characters.length());
                    plate += characters.charAt(randomIndex);
                    counter++;
                }
                // Loop ends after generating 6 random characters
                // Formatting the plate with a hyphen after the third character
                plate = plate.substring(0, 3) + "-" + plate.substring(3);
                System.out.println("Your random plate is: " + plate);
                break;
            case 2:
                // Consume the newline character left in the buffer
                scanner.nextLine();
                // Calls on the custom plate method
                customplate(scanner);
                break;
            case 3:
                // Calls plate renewal method
                plateRenewal(scanner);
                break;
            case 0:
                // Exit option
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
            break;
        }
    }
}