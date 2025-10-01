import java.util.*;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String symbols = "!@#$%^&*()-_=+[]{};:,.<>?";

        String characterSet = "";

        System.out.println("--------------------------------------------------------------");
        System.out.println("Welcome to Password Generator");
        System.out.println("--------------------------------------------------------------");

        System.out.println("NOTE: Minimum 8 characters required!!");

        System.out.print("Enter password length: ");
        int length = sc.nextInt();

        System.out.println("Choose an option: ");
        System.out.println("1. System Generated Password.");
        System.out.println("2. Customised Password.");

        int passChoice = sc.nextInt();
        sc.nextLine();

        if(length < 8){
            System.out.println("Password length can't be less than 8 characters!!");
        }
        else if(length >= 8 && passChoice == 1){

                characterSet += letters;
                characterSet += digits;
                characterSet += symbols;

            if (characterSet.isEmpty()) {
                System.out.println("No characters selected. Cannot generate password!");
                return;
            }

            Random rand = new Random();
            StringBuilder password = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int index = rand.nextInt(characterSet.length());
                password.append(characterSet.charAt(index));
            }

            String normalPassword = password.toString();


            System.out.println("---------------------------------------------------");
            System.out.println("Generating password....");
            System.out.println("---------------------------------------------------");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("SORRY, PASSWORD COULDN'T BE GENERATED DUE TO SOME ERROR!!!!");
            }

            System.out.println("Generated Password: " + normalPassword);

        }
        else if (length >= 8 && passChoice == 2){

            System.out.print("Include letters? (y/n): ");
            if (sc.next().equalsIgnoreCase("y")) {
                characterSet += letters;
            }

            System.out.print("Include digits? (y/n): ");
            if (sc.next().equalsIgnoreCase("y")) {
                characterSet += digits;
            }

            System.out.print("Include symbols? (y/n): ");
            if (sc.next().equalsIgnoreCase("y")) {
                characterSet += symbols;
            }

            System.out.println("Choose an option: ");
            System.out.println("1. Normal Password with both Lettercase.");
            System.out.println("2. Password with Uppercase letters.");
            System.out.println("3. Password with Lowercase letters.");

            int choice = sc.nextInt();
            sc.nextLine();

            if (characterSet.isEmpty()) {
                System.out.println("No characters selected. Cannot generate password!");
                return;
            }

            Random rand = new Random();
            StringBuilder password = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int index = rand.nextInt(characterSet.length());
                password.append(characterSet.charAt(index));
            }

            String normalPassword = password.toString();


            System.out.println("---------------------------------------------------");
            System.out.println("Generating password....");
            System.out.println("---------------------------------------------------");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("SORRY, PASSWORD COULDN'T BE GENERATED DUE TO SOME ERROR!!!!");
            }

            switch (choice){
                case 1:
                    String normalcasePassword = normalPassword;
                    System.out.println("Generated Password: " + normalcasePassword);
                    break;

                case 2:
                    String uppercasePassword = normalPassword.toUpperCase();
                    System.out.println("Generated Password: " + uppercasePassword);
                    break;

                case 3:
                    String lowercasePassword = normalPassword.toLowerCase();
                    System.out.println("Generated Password: " + lowercasePassword);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        else{
            System.out.println("You didn't choose any option on how you want to generate your password!!!");
        }

        sc.close();
    }
}
