package org.esudarshan.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CityValidator implements ConstraintValidator<IsValidCity, String> {

	private String aValidCity;

	@Override
	public void initialize(IsValidCity constraintAnnotation) {
		aValidCity = constraintAnnotation.aValidCity();
	}

	@Override
	public boolean isValid(String city, ConstraintValidatorContext cvx) {
		if (city == null || city.isEmpty()) {
			return false;
		}
		if (city.equalsIgnoreCase(aValidCity)) {
			return true;
		}
		return false;
	}

}
