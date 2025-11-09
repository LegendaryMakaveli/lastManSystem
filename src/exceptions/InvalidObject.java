package exceptions;

public class InvalidObject extends RuntimeException {
    public InvalidObject(String message) {
        super(message);
    }
}
