package dunphy.chris.rpncalc.exceptions;

public class MemoryEmptyException extends Exception {

	private static final long serialVersionUID = 1011156610869706917L;

	public MemoryEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public MemoryEmptyException(String message) {
		super(message);
	}

	public MemoryEmptyException(Throwable cause) {
		super(cause);
	}
}
