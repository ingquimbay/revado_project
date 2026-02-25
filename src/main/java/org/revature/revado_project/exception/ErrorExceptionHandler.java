package org.revature.revado_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorExceptionHandler {

	@ExceptionHandler(value = { UserNotFoundException.class })
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException uNFE) {
		ErrorException exception = new ErrorException(uNFE.getMessage(), uNFE.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { UsernameAlreadyExistsException.class })
	public ResponseEntity<Object> handleUsernameExistsException(UsernameAlreadyExistsException uAEE) {
		ErrorException exception = new ErrorException(uAEE.getMessage(), uAEE.getCause(), HttpStatus.CONFLICT);
		return new ResponseEntity<>(exception, HttpStatus.CONFLICT);
	}
}
