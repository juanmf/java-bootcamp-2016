package ejer2_Factory;

public class InvalidDBConnectionTypeException extends Exception {

	public InvalidDBConnectionTypeException() {
		super();
	}

	public InvalidDBConnectionTypeException(String message) {
		super(message);
	}

}