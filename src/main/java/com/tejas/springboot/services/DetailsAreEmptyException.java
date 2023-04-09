package com.tejas.springboot.services;

public class DetailsAreEmptyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DetailsAreEmptyException(String message)
	{
		super(message);
	}

}
