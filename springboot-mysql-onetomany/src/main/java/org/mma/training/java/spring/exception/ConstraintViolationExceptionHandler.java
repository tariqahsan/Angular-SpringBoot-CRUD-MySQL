package org.mma.training.java.spring.exception;

import java.util.ArrayList;

/*
 * https://github.com/eugenp/tutorials/blob/master/spring-mvc-basics-3/src/main/java/com/baeldung/validation/listvalidation/controller/MovieController.java
 */

import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ConstraintViolationExceptionHandler {
    
    private final Logger logger = LoggerFactory.getLogger(ConstraintViolationExceptionHandler.class);

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handle(ConstraintViolationException constraintViolationException) {
        Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
        String errorMessage = "";
        if (!violations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            violations.forEach(violation -> builder.append("\n" + violation.getMessage()));
            errorMessage = builder.toString();
        } else {
            errorMessage = "ConstraintViolationException occured.";
        }

        logger.error(errorMessage);
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    
    /*
     * List<String> errorList = new ArrayList<>();
		List<ErrorMessage> errorMessages = new ArrayList<>();
		if (bindingResult.hasErrors()) {
			 bindingResult.getFieldErrors().forEach(fieldError ->
	            errorList.add(fieldError.getField() + ": " + messageSource.getMessage(fieldError, Locale.US))
	        );
			 bindingResult
	            .getFieldErrors()
	            .stream()
	            .forEach(fieldError -> {            
	            	ErrorMessage errorMessage = new ErrorMessage(messageSource.getMessage(fieldError, Locale.US), fieldError.getField());           	
	            	System.out.println(errorMessage.getMessage());
	            	System.out.println(errorMessage.getFieldName());
	            	errorMessages.add(errorMessage);
	            });
			 return new ResponseEntity<>(errorMessages, HttpStatus.NOT_ACCEPTABLE);
     */

}