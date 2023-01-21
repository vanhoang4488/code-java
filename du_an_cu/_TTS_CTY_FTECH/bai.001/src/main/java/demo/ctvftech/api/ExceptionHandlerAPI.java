package demo.ctvftech.api;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandlerAPI {

	private static Logger logger = Logger.getLogger(ExceptionHandlerAPI.class);
	
	@ExceptionHandler(value = {NoHandlerFoundException.class})
	public String _404Handler(Exception ex) {
		
		logger.error(ex);
		
		return "404";
	}
	
	@ExceptionHandler(value = {Exception.class})
	public String ExceptionHandler(Exception ex) {
		
		logger.error(ex);
		
		return "error";
	}
}
