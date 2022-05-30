package com.acldigital.unaito.service.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.acldigital.unaito.service.user.dto.ErrorResponse;
import com.acldigital.unaito.service.user.exception.EmptyInputException;
import com.acldigital.unaito.service.user.exception.InvalidUserException;
import com.acldigital.unaito.service.user.exception.UnaitoSecurityException;
import com.acldigital.unaito.service.user.exception.UserConstraintValidationException;
import com.acldigital.unaito.service.user.exception.UserException;
import com.acldigital.unaito.service.user.exception.UserNotFoundException;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(value = { UserException.class })
	public ResponseEntity<Object> handleUserException(UserException e) {
		// UserException userException = new UserException(e.getMessage(), e,
		// HttpStatus.BAD_REQUEST);
		UserException userException = new UserException("BAD REQUEST", 401);
		return new ResponseEntity<>(userException, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { UserNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException re) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "User not found.");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { EmptyInputException.class })
	public ResponseEntity<ErrorResponse> handleEmptyInputException(EmptyInputException re) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NO_CONTENT.value(), "Please check your request.");
		return new ResponseEntity<>(errorResponse, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(value = { InvalidUserException.class })
	public ResponseEntity<ErrorResponse> handleInvalidUserException(InvalidUserException iv) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.FORBIDDEN.value(), "Invalid user.");
		return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(value = { UserConstraintValidationException.class })
	public ResponseEntity<ErrorResponse> handleUserConstraintValidationException(UserConstraintValidationException iv) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Constraints violated.");
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { UnaitoSecurityException.class })
	public ResponseEntity<ErrorResponse> handleUnaitoSecurityException(UnaitoSecurityException se) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "API Key invalid.");
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
