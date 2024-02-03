package EXCEPTIONS;

public class invalid_PasswordException extends Exception{
    private String message;
    public invalid_PasswordException(){
        message = "Password must contain an integer ";
    }
    public String toString(){
        return message;
    }
}

