package api.rest.diccionario.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import api.rest.diccionario.exception.ResourceAccessException;
import api.rest.diccionario.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceAccessException.class)
	public ResponseEntity<?> globalResourceAccessException(ResourceAccessException ex, WebRequest request) {
	
		ApiError errorDetalle = new ApiError(HttpStatus.NOT_FOUND, new Date(), ex.getMessage(), request.getDescription(false), request.getSessionId());	
		return new ResponseEntity<ApiError>(errorDetalle, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> globalNotFoundException(ResourceNotFoundException ex, WebRequest request) {
	
		ApiError errorDetalle = new ApiError(HttpStatus.NOT_FOUND, new Date(), ex.getMessage(), request.getDescription(false), request.getSessionId());	
		return new ResponseEntity<ApiError>(errorDetalle, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
		
		ApiError errorDetalle = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, new Date(), ex.getMessage(), request.getDescription(false), request.getSessionId());	
		return new ResponseEntity<>(errorDetalle, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
