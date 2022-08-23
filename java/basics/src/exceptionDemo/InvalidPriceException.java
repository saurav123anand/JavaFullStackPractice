package exceptionDemo;

public class InvalidPriceException extends Exception{
    public InvalidPriceException(String msg) {
        super(msg);
    }
}
