package com.revature.exceptions;




/**
 * Representation of an exception if the profile does not exist
 * 
 * [TODO] If you are adding on to this or incorporating Spring Data, please add your name to the author list.
 * @author Adriana Long
 * @author 
 */
public class ProfileException extends RuntimeException {

	
	
	
	public ProfileException(String message) {
		super(message);
	}
	
	
	public ProfileException(String message, Throwable cause) {
		super (message, cause);
	}
	
	public ProfileException(Throwable cause) {
		super (cause);
	}
}
