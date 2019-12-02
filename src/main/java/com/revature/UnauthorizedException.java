package com.revature;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UnauthorizedException() {
		super("User is not authorized");
	}
	
	public UnauthorizedException(String e) {
		super(e);
	}
}
