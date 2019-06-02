package ihor.makarchuk.exceptions;

public class EmptyTextException extends RuntimeException {

    public EmptyTextException() {
        super();
    }

    public EmptyTextException(String message) {
        super(message);
    }

    public EmptyTextException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyTextException(Throwable cause) {
        super(cause);
    }
}
