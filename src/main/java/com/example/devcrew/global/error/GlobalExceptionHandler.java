package com.example.devcrew.global.error;

import com.example.devcrew.domain.contest.exception.AcceptancePeriodInvalidException;
import com.example.devcrew.domain.contest.exception.ContestNotFoundException;
import com.example.devcrew.global.error.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleRuntimeException(BusinessException e) {
        final ErrorCode errorCode = e.getErrorCode();
        log.warn(e.getMessage());

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(new ErrorResponse(errorCode.getStatus(),
                        errorCode.getErrorMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
        log.warn(e.getMessage());
        return ResponseEntity
                .status(e.getStatusCode())
                .body(new ErrorResponse(400, e.getMessage()));
    }

    @ExceptionHandler(AcceptancePeriodInvalidException.class)
    public ResponseEntity<ErrorResponse> handleAcceptancePeriodInvalidException(AcceptancePeriodInvalidException ex) {
        ErrorResponse response = new ErrorResponse(ex.getErrorCode().getStatus(), ex.getErrorCode().getErrorMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ContestNotFoundException.class)
    public ResponseEntity<ErrorResponse> ContestNotFoundException(ContestNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(ex.getErrorCode().getStatus(), ex.getErrorCode().getErrorMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}