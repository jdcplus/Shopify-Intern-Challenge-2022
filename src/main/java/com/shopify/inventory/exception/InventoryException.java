package com.shopify.inventory.exception;

public class InventoryException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This is a constructor,it receives a string and passes it to Exception class for
	 * setting it as an exception message whenever given exception is thrown.
	 *
	 * @param exception message
	 */
	public InventoryException(String message) {
		super(message);
	}

}
