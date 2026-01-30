package com.crud.app.exception.handler;

import java.time.Instant;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<?> handleIllegalstate(IllegalStateException ex){
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(Map.of("timestamp", Instant.now(), "status", "400", "error", "IllegalStateException"
						, "message", ex.getMessage()));
	}

}
