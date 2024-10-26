package com.micro.accounts.exception;

import com.micro.accounts.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();

        // Get all validation errors
        for (ObjectError error : allErrors) {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            validationErrors.put(fieldName, errorMessage);
        }

        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }



    /**
     * Handles generic exceptions and returns a standardized error response.
     *
     * This method is invoked when an unhandled exception is thrown during the processing
     * of a web request. It constructs an ErrorResponseDto containing details about the
     * error, such as the description of the web request, the error message, and a timestamp.
     * The response is returned with an HTTP status code of INTERNAL_SERVER_ERROR.
     *
     * @param exception the exception that was thrown
     * @param webRequest the web request that resulted in the exception
     * @return a ResponseEntity containing an ErrorResponseDto with error details
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception, WebRequest webRequest) {

        // Create an error response DTO with relevant error information
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),  // The description of the web request
                HttpStatus.INTERNAL_SERVER_ERROR,            // HTTP status code for the error
                exception.getMessage(),            // Error message from the exception
                LocalDateTime.now()                // Timestamp of when the error occurred
        );

        // Return the error response wrapped in a ResponseEntity with a BAD_REQUEST status
        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    /**
     * Handles CustomerAlreadyExistException and returns an appropriate error response.
     *
     * @param exception the exception thrown when a customer already exists
     * @param webRequest the web request that resulted in the exception
     * @return a ResponseEntity containing an ErrorResponseDto with error details
     */
    @ExceptionHandler(CustomerAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistException(CustomerAlreadyExistException exception, WebRequest webRequest) {

        // Create an error response DTO with relevant error information
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
            webRequest.getDescription(false),  // The description of the web request
            HttpStatus.BAD_REQUEST,            // HTTP status code for the error
            exception.getMessage(),            // Error message from the exception
            LocalDateTime.now()                // Timestamp of when the error occurred
        );

        // Return the error response wrapped in a ResponseEntity with a BAD_REQUEST status
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }


    /**
     * Handles ResourceNotFoundException and returns an appropriate error response.
     *
     * @param exception the exception thrown when a resource is not found
     * @param webRequest the web request that resulted in the exception
     * @return a ResponseEntity containing an ErrorResponseDto with error details
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNameNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {

        // Create an error response DTO with relevant error information
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),  // The description of the web request
                HttpStatus.NOT_FOUND,            // HTTP status code for the error
                exception.getMessage(),            // Error message from the exception
                LocalDateTime.now()                // Timestamp of when the error occurred
        );

        // Return the error response wrapped in a ResponseEntity with a BAD_REQUEST status
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }


}
