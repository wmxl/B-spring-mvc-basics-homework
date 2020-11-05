package com.thoughtworks.capacity.gtb.mvc.excception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {

  //自定义异常处理
  @ExceptionHandler(WrongPasswordException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public ErrorResult handle(WrongPasswordException ex) {
    return new ErrorResult(ex.getMessage());
  }

  @ExceptionHandler(UserExistException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public ErrorResult handle(UserExistException ex) {
    return new ErrorResult(ex.getMessage());
  }

  //参数校验 (Model 里属性上的@NotNull @Email @Length...) + @Valid [body里的参数]
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex) {
    String message = ex.getBindingResult().getFieldError().getDefaultMessage();
    ErrorResult errorResult = new ErrorResult(message);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
  }

  //参数校验 @Validated + （get请求上的url上的参数 @Min，@Length...)
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResult> handle(ConstraintViolationException ex) {
    Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();

    String message = "";
    for (ConstraintViolation<?> constraint : ex.getConstraintViolations()) {
      message += constraint.getMessage();
      break;
    }
    ErrorResult errorResult = new ErrorResult(message);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
  }
}
