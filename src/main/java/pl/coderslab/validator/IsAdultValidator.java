package pl.coderslab.validator;

import java.time.LocalDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsAdultValidator implements ConstraintValidator<IsAdult, Integer>{

	@Override
	public void initialize(IsAdult constraintAnnotation) {
	}

	@Override
	public boolean isValid(Integer year, ConstraintValidatorContext context) {
		return (LocalDateTime.now().getYear()-year)>=18;
		
	}

	
}
