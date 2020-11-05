package com.thoughtworks.capacity.gtb.mvc.excception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

//  @ExceptionHandler(WrongPasswordException.class)
//  @ResponseStatus(HttpStatus.NOT_FOUND)
//  @ResponseBody
//  public ErrorResult handle() {
//    return handle();
//  }

  @ExceptionHandler(WrongPasswordException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public ErrorResult handle(WrongPasswordException ex) {
    return new ErrorResult(ex.getMessage());
  }
}
