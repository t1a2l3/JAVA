package EXCEPTIONS;

import java.util.Scanner;
import java.util.regex.Pattern;
public class OwnExceptions {
    public static int integerinput() throws invalid_IntException{
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        }catch (Exception e){
            throw new invalid_IntException();
        }
    }
    public static String stringinput() throws invalid_StringException{
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        if(!containsInteger(value)){
            return value;
        }else{
            throw new invalid_StringException();
        }
    }
    public static String passwordinput() throws invalid_PasswordException{
        Scanner sc = new Scanner(System.in);
        String password = sc.next();
        if(containsInteger(password)){
            return password;
        }else{
            throw new invalid_PasswordException();
        }
    }
    private static boolean containsInteger(String value) {
        Pattern pattern = Pattern.compile(".*\\d.*");
        // Return true if the pattern matches (i.e., if the string contains a digit)
        return pattern.matcher(value).matches();
    }
    public static String gmailinput() throws invalid_GmailException{
        Scanner sc = new Scanner(System.in);
        String gmail = sc.next();
        if(gmail.contains("@gmail.com") || gmail.contains("@cuilahore.edu.pk")){
            return gmail;
        }else {
            throw new invalid_GmailException();
        }
    }
}


