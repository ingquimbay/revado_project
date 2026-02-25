package org.revature.revado_project.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorException {

	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;

}
