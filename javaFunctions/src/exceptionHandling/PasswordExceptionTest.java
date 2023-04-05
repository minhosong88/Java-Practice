package exceptionHandling;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PasswordExceptionTest{
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws NullPointerException, PasswordException{
        boolean hasLower = false, hasUpper = false, hasDigit = false, speChar = false;
        Set<Character> set = new HashSet<>(Arrays.asList('!','@','#','$','%','^','&','*','(',')','_','+'));
        for(char i: password.toCharArray()){
            if(Character.isLowerCase(i)) hasLower = true;
            if(Character.isUpperCase(i)) hasUpper = true;
            if(Character.isDigit(i)) hasDigit = true;
            if(set.contains(i)) speChar = true;
        }
/*        System.out.println(hasUpper);
        System.out.println(hasLower);
        System.out.println(hasDigit);
        System.out.println(speChar);*/

        if (password == null) {
            throw new PasswordException("Password cannot be null.");
        } else if (password.length() < 8) {
            throw new PasswordException("The length of Password has to be over 8 characters.");
        } else if (password.matches("[a-zA-Z]+")) {
            throw new PasswordException("Password must contain at least 1 number and special character.");
        } if ((speChar&&!hasDigit)||(!speChar&&hasDigit)) {
            throw new PasswordException("Password must contain at least 1 number and special character.");
        }

        this.password = password;

    }

    public static void main(String[] args) {
        PasswordExceptionTest test = new PasswordExceptionTest();
        String password = null;

        try {
            test.setPassword(password);
            System.out.println("No Errors 1");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        password = "asdf";
        try {
            test.setPassword(password);
            System.out.println("No Errors 2");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

        password = "qwerasdf";
        try {
            test.setPassword(password);
            System.out.println("No Errors 3");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

        password = "qwerasf!";
        try {
            test.setPassword(password);

            System.out.println("No Errors 4");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }
        password = "qwerasf1!";
        try {
            test.setPassword(password);

            System.out.println("No Errors 5");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}
