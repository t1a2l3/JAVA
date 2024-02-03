package EXCEPTIONS;

public class invalid_StringException extends Exception{
    public String message;
    public invalid_StringException(){
        this.message = "Name must not contain an integer";
    }
    public String toString(){
        return message;
    }
}

