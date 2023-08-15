//Clayton Johnson
//CS 145 Final project
//8/10/23
//Java program for generating strong passwords and checking password strength
import java.util.Scanner;

public class SecurePasswordsMain {
    
    public static void main(String[] args) {
		  Scanner input = new Scanner(System.in);
        printArt();
        intro();
        boolean run = true;
        //While loop that lets the user pick options until they choose to quit
        while (run) {
            System.out.println("Pick an option");
            System.out.println("1. Generate Strong password");
            System.out.println("2. Check password strength");
            System.out.println("3. Quit program");
            int option = input.nextInt();
            //Handles user options
            switch (option) {
                case 1:
                    getPassword(input);
                    break;
                case 2:
                    getStrength(input);
                    break;
                case 3:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
	}
    
    //Prints the strength of a given password
    public static void getStrength(Scanner input) {
        System.out.println("Password: ");
        String password = input.next();
        int passStrength = SecurePasswords.calculateStrength(password);
        String strengthLevel = SecurePasswords.getStrengthLabel(passStrength);
        System.out.println(strengthLevel);
    }
    
    //Prints a strong password by calling the generatePassword method
    public static void getPassword(Scanner input) {
        String goodPassword;
        System.out.println("Would you like special characters in this password?(y/n)");
        String answer = input.next();
        if (answer.equals("y")) {
            goodPassword = SecurePasswords.generatePassword(true);
        } else {
            goodPassword = SecurePasswords.generatePassword(false);
        }
       System.out.println("Strong password:" + goodPassword);
    }
    
    //Introduction to program
    public static void intro() {
      System.out.println("Welcome to my password security tookit.");
      System.out.println("This simple java program allows you to improve");
      System.out.println("your password security by generating a strong");
      System.out.println("password, and checking the strength of a given password.");
    }
    
    //Prints out ASCII art of some mountains
    public static void printArt() {
      System.out.println("     /\\");
      System.out.println("    // \\_    /\\");
      System.out.println("   ///   \\  // \\");
      System.out.println("  ///     \\///  \\");
      System.out.println(" ////     ////   \\");
      System.out.println("//////   /////    \\");
    }
}