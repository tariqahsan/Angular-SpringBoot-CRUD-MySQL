package org.mma.training.java.spring.exception;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/*
 * https://stackoverflow.com/questions/39348234/spring-boot-how-to-use-valid-with-listt
 */

@ControllerAdvice(annotations = Validated.class)
public class ValidatedExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Object> handle(ConstraintViolationException exception) {
		List<String> errors = exception.getConstraintViolations()
				.stream()
				.map(this::toString)
				.collect(Collectors.toList());

//		return new ResponseEntity<>(new ErrorResponseBody(exception.getLocalizedMessage(), errors),
//				HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

//	private String toString(ConstraintViolation<?> violation) {
//      // Formatter is from Java 7
//		return Formatter.format("{} {}: {}",
//				violation.getRootBeanClass().getName(),
//				violation.getPropertyPath(),
//				violation.getMessage());
//	}
	
	private String toString(ConstraintViolation<?> violation) {
	return String.format("{} {}: {}",
			violation.getRootBeanClass().getName(),
			violation.getPropertyPath(),
			violation.getMessage());
}

	public static class ErrorResponseBody {
		private String message;
		private List<String> errors;
	}
}
