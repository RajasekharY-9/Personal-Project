package com.infymemobileuser.utility;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infymemobileuser.service.InfyMeMobileException;


@RestControllerAdvice
public class InfyMeMobileGlobalExceptionHandler {
   private final Environment environment;

 

    @Autowired
    public InfyMeMobileGlobalExceptionHandler(Environment environment) {
        this.environment = environment;
    }

 

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInformation> exceptionHandler(Exception ex) {
        ErrorInformation errorInformation = new ErrorInformation();
        errorInformation.setErrorMessage("Internal Server Error");
        errorInformation.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorInformation.setErrorTimeStamp(LocalDateTime.now());

 

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInformation);
    }

 

    @ExceptionHandler(InfyMeMobileException.class)
    public ResponseEntity<ErrorInformation> exceptionHandler(InfyMeMobileException e) {
        ErrorInformation errorInformation = new ErrorInformation();
        errorInformation.setErrorMessage(e.getMessage());
        errorInformation.setErrorCode(HttpStatus.OK.value());
        errorInformation.setErrorTimeStamp(LocalDateTime.now());

 

        return ResponseEntity.ok(errorInformation);
    }

 

    @ExceptionHandler({MethodArgumentNotValidException.class,ConstraintViolationException.class})
    public ResponseEntity<ErrorInformation> handleValidationExceptions(Exception ex) {
        ErrorInformation errorInformation = new ErrorInformation();
        errorInformation.setErrorMessage("Validation Error");
        errorInformation.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorInformation.setErrorTimeStamp(LocalDateTime.now());

 

        return ResponseEntity.badRequest().body(errorInformation);
    }


}
