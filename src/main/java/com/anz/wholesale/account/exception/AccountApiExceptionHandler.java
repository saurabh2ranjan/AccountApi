package com.anz.wholesale.account.exception;

import com.anz.wholesale.account.jsonbean.AccountErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class AccountApiExceptionHandler extends ResponseEntityExceptionHandler {

    /** Handler method for any validation error for request parameters. e.g max value check.
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        logger.error("Validation failed for the request parameters." +ex.getMessage());
        return buildResponseEntity(AccountErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build());
    }

    /**
     * Handler method for invalid request fields. e.g. null-check, format-check
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        log.error("Invalid request field.Error:" + ex.getMessage());
        return buildResponseEntity(AccountErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build());
    }

    /**
     * Handler method for mismatch in argument type. e.g. string if required type is integer
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentMismatch(MethodArgumentTypeMismatchException ex) {
        logger.error("Method argument type is not valid::" + ex.getMessage() );
        return buildResponseEntity(AccountErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build());
    }

    /**
     * Handler method for generic error
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<Object> handleException(Exception ex) {
        ex.printStackTrace();
        logger.error("Generic Exception!!!." + ex.getMessage());
        return buildResponseEntity(AccountErrorResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build());
    }

    private ResponseEntity<Object> buildResponseEntity(AccountErrorResponse accountEnquiryError) {
        return new ResponseEntity<>(accountEnquiryError, accountEnquiryError.getStatus());
    }
}