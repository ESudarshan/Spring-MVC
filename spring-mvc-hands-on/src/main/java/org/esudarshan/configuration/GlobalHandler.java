package org.esudarshan.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
// Specialization of @Component for classes that declare @ExceptionHandler,
// @InitBinder, or @ModelAttribute methods to be shared across multiple
// @Controller classes.
public class GlobalHandler {

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandler() {
		return "exception";
	}
}
