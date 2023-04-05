package exceptionHandling;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StrongPassword {

    public static void strongPassword(String input) {
        int n = input.length();
        boolean hasLower=false, hasUpper = false, hasNumber=false, specialChar = false;
        Set<Character> set = new HashSet<>(Arrays.asList('!','@', '#','$','%','^','&',
                                                                '*','(',')','-','+'));
        for (char i : input.toCharArray()) {
            if(Character.isLowerCase(i)){
                hasLower = true;
            }
            if (Character.isUpperCase(i)) {
                hasUpper = true;
            }
            if (Character.isDigit(i)) {
                hasNumber = true;
            }
            if (set.contains(i)) {
                specialChar = true;
            }
        }
        if(hasLower &&hasNumber &&hasUpper && specialChar && (n >= 8)){
            System.out.println("Password is Strong");
        } else if ((hasNumber || hasLower || hasUpper) && (n < 8)) {
            System.out.println("Password is Moderate");
        } else {
            System.out.println("Password is Weak");
        }
    }

    public static void main(String[] args) {
        String input = "!Q2w3e4r5t";
        strongPassword(input);

    }
}
