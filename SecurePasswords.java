//Clayton Johnson
//CS 145 Final project
//8/10/23
//Provides utility for password security operations
import java.util.Random;

public class SecurePasswords {
       
    //Calculates strength of a given password based on several factors
    public static int calculateStrength(String password) {
        int length = password.length();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        //Checks for numbers and special characters
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }
        
        int passStrength = 0;
        //Calculates password strength
        if (length > 8) {
            passStrength += 2;
        }
        if (hasUppercase && hasLowercase) {
            passStrength += 2;
        }
        if (hasDigit) {
            passStrength += 1;
        }
        if (hasSpecialChar) {
            passStrength += 1;
        }       
        return passStrength;
    }
    
    //Returns a label indicating the passwords strength
    public static String getStrengthLabel(int passStrength) {
        if (passStrength > 5) {
            return "Strong password";
        } else if (passStrength > 3) {
            return "Could be stronger";
        } else {
            return "Weak password";
        }
    }

   //Generates a strong random password
   public static String generatePassword(boolean yesToSpecialChar) {
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChar = "!@#$%^&*()-_=+";
        
        Random random = new Random();
        StringBuilder password = new StringBuilder(15);
        String characters = uppercase + lowercase + numbers;
        //Include special characters if needed
        if (yesToSpecialChar) {
            characters += specialChar;
        }
        //Generates password based on charater set
        for (int i = 0; i < 15; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }       
        return password.toString();
    }
}