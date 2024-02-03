package EXCEPTIONS;

public class invalid_GmailException extends Exception{
    private String message ;
    public invalid_GmailException(){
        message = "Gmail you entered is not correct.";
    }
    public String toString(){
        return message;
    }
}

