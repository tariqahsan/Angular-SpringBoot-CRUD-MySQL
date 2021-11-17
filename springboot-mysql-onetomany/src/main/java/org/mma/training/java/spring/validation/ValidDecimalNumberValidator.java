package org.mma.training.java.spring.validation;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidDecimalNumberValidator implements ConstraintValidator<ValidDecimalNumber, BigDecimal> {
	
	private int min;
	
	@Override
	public void initialize(ValidDecimalNumber decimalNumber) {
		min = decimalNumber.min();
	}

	@Override
	public boolean isValid(BigDecimal decimalNumber, ConstraintValidatorContext context) {
		if (decimalNumber != null && getNumberOfDecimalPlaces(decimalNumber) != 3) {
		return false;
		}
		return true;
	}
	
	private int getNumberOfDecimalPlaces(BigDecimal bigDecimal) {
	    String string = bigDecimal.stripTrailingZeros().toPlainString();
	    int index = string.indexOf(".");
	    return index < 0 ? 0 : string.length() - index - 1;
	}

}
