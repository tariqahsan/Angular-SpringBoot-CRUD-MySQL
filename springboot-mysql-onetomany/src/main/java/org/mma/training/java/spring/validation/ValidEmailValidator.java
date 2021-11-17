package org.mma.training.java.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;

public class ValidEmailValidator implements ConstraintValidator<ValidEmail, String> {

	private int min;

	@Override
	public void initialize(ValidEmail validEmail) {
		min = validEmail.min();
		System.out.println("ValidEmailValidator : min -> " + min);
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		System.out.println("email -> " + email);
		if (email.length() < min) {
			return false;
		}

		if (!EmailValidator.getInstance(false).isValid(email)) {
			return false;
		}

		return true;
	}

}
