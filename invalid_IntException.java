package EXCEPTIONS;

public class invalid_IntException extends Exception{
    private String message ;
    public invalid_IntException(){
        message = "Error occured You entered a String instead of Integer";
    }
    public String toString(){
        return message ;
    }
}
