package org.mma.training.java.spring.util;

import javax.validation.Payload;
import org.apache.commons.lang3.Validate;


public enum Severity {
	
	// For every new enum, please add a static class implementing Payload.
	// This is required to support JSR annotations.
	HARD, SOFT;
	
	public static class Hard implements Payload {}
	public static class Soft implements Payload {}
	
	public static Severity transform(Class<? extends Payload> payload) {
		Validate.notNull(payload);
		return Severity.valueOf(String.valueOf(payload.getSimpleName()).toUpperCase());
	}
	

}
