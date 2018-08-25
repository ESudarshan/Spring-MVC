package org.esudarshan.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = CityValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidCity {

	String message() default "Invalid City";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String aValidCity() default "LATUR";
}
