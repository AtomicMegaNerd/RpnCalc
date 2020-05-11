package dunphy.chris.rpncalc.exceptions;

public class MemoryFullException extends Exception {

	private static final long serialVersionUID = -4946542540812204369L;

	public MemoryFullException(String message, Throwable cause) {
		super(message, cause);
	}

	public MemoryFullException(String message) {
		super(message);
	}

	public MemoryFullException(Throwable cause) {
		super(cause);
	}
}
