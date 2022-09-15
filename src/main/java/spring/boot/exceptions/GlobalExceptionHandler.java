package spring.boot.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
    ErrorDetail errorDetail = new ErrorDetail();
    errorDetail.setMessage(exception.getMessage());
    return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(APIException.class)
  public ResponseEntity<?> handleAPIException(APIException exception, WebRequest request) {
    ErrorDetail errorDetail = new ErrorDetail(
        new Date(),
        exception.getMessage(),
        request.getDescription(false));
    return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleException(Exception exception, WebRequest request) {
    ErrorDetail errorDetail = new ErrorDetail();
    errorDetail.setMessage(exception.getMessage());
    return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
