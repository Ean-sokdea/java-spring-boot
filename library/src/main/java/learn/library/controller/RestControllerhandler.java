package learn.library.controller;

import learn.library.excentionhandler.AlreadyExcention;
import learn.library.model.error.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerhandler{
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex){
        ErrorResponse errorResponse=new ErrorResponse().builder()
                .message(ex.getMessage())
                .status((short) 500)
                .build();
        return ResponseEntity.status(500).body(errorResponse);
    }
    @ExceptionHandler(AlreadyExcention.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExcention(AlreadyExcention ex){
        ErrorResponse errorResponse=new ErrorResponse().builder()
                .message(ex.getMessage())
                .status((short) 409)
                .build();
        return ResponseEntity.status(409).body(errorResponse);
    }
}
