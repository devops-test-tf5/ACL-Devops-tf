package com.acldigital.unaito.service.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.acldigital.unaito.service.user.dto.ErrorResponse;
import com.acldigital.unaito.service.user.exception.CustomerCreationException;
import com.acldigital.unaito.service.user.exception.CustomerNotFoundException;
import com.acldigital.unaito.service.user.exception.EmailTemplateNotAvailableException;
import com.acldigital.unaito.service.user.exception.EmptyInputException;
import com.acldigital.unaito.service.user.exception.InvalidJwtTokenException;
import com.acldigital.unaito.service.user.exception.InvalidOrExpiredVerificationLinkException;
import com.acldigital.unaito.service.user.exception.InvalidUserException;
import com.acldigital.unaito.service.user.exception.MoreRetryCountException;
import com.acldigital.unaito.service.user.exception.TokenExpiredException;
import com.acldigital.unaito.service.user.exception.TokenMissingException;
import com.acldigital.unaito.service.user.exception.UnaitoSQLException;
import com.acldigital.unaito.service.user.exception.UnaitoSecurityException;
import com.acldigital.unaito.service.user.exception.UserConstraintValidationException;
import com.acldigital.unaito.service.user.exception.UserException;
import com.acldigital.unaito.service.user.exception.UserIdMissingException;
import com.acldigital.unaito.service.user.exception.UserInActiveException;
import com.acldigital.unaito.service.user.exception.UserLoggedInException;
import com.acldigital.unaito.service.user.exception.UserNotFoundException;
import com.acldigital.unaito.service.user.exception.UsersNotMatchingException;

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
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "User not found. Please register the user.");
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

	@ExceptionHandler(value = { UserInActiveException.class })
	public ResponseEntity<ErrorResponse> handleUserInActiveException(UserInActiveException uiae) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.FORBIDDEN.value(), "User is not in active status.");
		return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(value = { MoreRetryCountException.class })
	public ResponseEntity<ErrorResponse> handleMoreRetryCountException(MoreRetryCountException mrce) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.FORBIDDEN.value(),
				"Invalid user. Consider resetting your password by clicking 'Forgot Password' link.");
		return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(value = { EmailTemplateNotAvailableException.class })
	public ResponseEntity<ErrorResponse> handleEmailTemplateNotAvailableException(
			EmailTemplateNotAvailableException mrce) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
				"Email communication template not available.");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { InvalidOrExpiredVerificationLinkException.class })
	public ResponseEntity<ErrorResponse> handleInvalidOrExpiredVerificationLinkException(
			InvalidOrExpiredVerificationLinkException mrce) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.FORBIDDEN.value(),
				"Verification link invalid or expired.");
		return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(value = { UnaitoSQLException.class })
	public ResponseEntity<ErrorResponse> handleUnaitoSQLException(UnaitoSQLException usqle) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
				"Username or Email is already registered.Please use another username or email.");
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { UserIdMissingException.class })
	public ResponseEntity<ErrorResponse> handleUserIdMissingException(UserIdMissingException ume) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(),
				"User id is missing in the token.");
		return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(value = { TokenMissingException.class })
	public ResponseEntity<ErrorResponse> handleTokenMissingException(TokenMissingException ume) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NO_CONTENT.value(),
				"JWT token is missing in the request.");
		return new ResponseEntity<>(errorResponse, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(value = { UsersNotMatchingException.class })
	public ResponseEntity<ErrorResponse> handleUsersNotMatchingException(UsersNotMatchingException ume) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(),
				"JWT token user id and requested user id not matching.");
		return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(value = { TokenExpiredException.class })
	public ResponseEntity<ErrorResponse> handleTokenExpiredException(TokenExpiredException ume) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(),
				"JWT token expired.");
		return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(value = { InvalidJwtTokenException.class })
	public ResponseEntity<ErrorResponse> handleInvalidJwtTokenException(InvalidJwtTokenException ume) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.FORBIDDEN.value(),
				"Invalid JWT token.");
		return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(value = { UserLoggedInException.class })
	public ResponseEntity<ErrorResponse> handleUserLoggedInException(UserLoggedInException ule) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Exception occurred while trying to save user logged in details to db.");
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { CustomerNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException cnf) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Customer not found exception. Please register the customer before creating project.");
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { CustomerCreationException.class })
	public ResponseEntity<ErrorResponse> handleCustomerCreationException(CustomerCreationException cce) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Exception occured while creation of new customer.");
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
