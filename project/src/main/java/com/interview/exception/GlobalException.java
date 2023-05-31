package com.interview.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(NoLevelFoundException.class) 
	public ResponseEntity<MyErrorDetails> noLevelFoundExceptionHandler(NoLevelFoundException n,WebRequest w){
		MyErrorDetails err=new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(n.getMessage());
		err.setDetails(w.getDescription(false));
	return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);	
	}
}
