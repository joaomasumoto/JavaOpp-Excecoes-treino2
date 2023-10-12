package model.exceptions;

/**
 * Custom exception class for handling domain-specific errors.
 */

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DomainException(String msg) {
		super(msg);
	}
}