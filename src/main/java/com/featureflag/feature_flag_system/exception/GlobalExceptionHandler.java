package com.featureflag.feature_flag_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.stream.Collectors;
import com.featureflag.feature_flag_system.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {

	        String errorMessage = ex.getBindingResult()
	                .getFieldErrors()
	                .stream()
	                .map(error -> error.getDefaultMessage())
	                .collect(Collectors.joining(", "));

	        return new ResponseEntity<>(
	                new ErrorResponse(errorMessage, 400),
	                HttpStatus.BAD_REQUEST
	        );
	    }
	
	@ExceptionHandler(FeatureNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleFeatureNotFound(FeatureNotFoundException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage(), 404),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(EnvironmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEnvNotFound(EnvironmentNotFoundException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage(), 404),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ConfigNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleConfigNotFound(ConfigNotFoundException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage(), 404),
                HttpStatus.NOT_FOUND
        );
    }

    // fallback (important)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage(), 500),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        
    }
    
}