package dunphy.chris.rpncalc.exceptions;

public class InvalidOperationException extends Exception {

    private static final long serialVersionUID = -1927543618308818731L;

    public InvalidOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOperationException(String message) {
        super(message);
    }

    public InvalidOperationException(Throwable cause) {
        super(cause);
    }

}
