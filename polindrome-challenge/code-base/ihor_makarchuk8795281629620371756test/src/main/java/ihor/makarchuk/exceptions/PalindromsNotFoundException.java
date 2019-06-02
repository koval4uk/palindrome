package ihor.makarchuk.exceptions;

public class PalindromsNotFoundException extends RuntimeException {

    public PalindromsNotFoundException() {
        super();
    }

    public PalindromsNotFoundException(String message) {
        super(message);
    }

    public PalindromsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PalindromsNotFoundException(Throwable cause) {
        super(cause);
    }
}
