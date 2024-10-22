package com.dev.rest_with_spring_boot_and_java_dev.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dev.rest_with_spring_boot_and_java_dev.exceptions.ExceptionResponse;
import com.dev.rest_with_spring_boot_and_java_dev.exceptions.UnsupportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> handlerAllExceptions(
    Exception ex, WebRequest request){
    ExceptionResponse exceptionResponse = new ExceptionResponse(
      new Date(), ex.getMessage(), request.getDescription(false));
      return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  @ExceptionHandler(UnsupportedMathOperationException.class)
  public final ResponseEntity<ExceptionResponse> handlerBadExceptions(
    Exception ex, WebRequest request){
    ExceptionResponse exceptionResponse = new ExceptionResponse(
      new Date(), ex.getMessage(), request.getDescription(false));
      return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }
}
