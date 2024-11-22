package lect4;

// Create an exception for the date
public class IllegalDateException extends RuntimeException {

	public IllegalDateException(String message) {
		super(message);
	}
}
