package com.kn.apim.restfulldemo.exception;

import com.kn.apim.restfulldemo.model.Problem;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
    private ResponseEntity<Problem> handleException(
            String type, String title, HttpStatus status, String detail, HttpServletRequest request) {
        Problem problem = new Problem();
        problem.setType(type);
        problem.setTitle(title);
        problem.setStatus(status.value());
        problem.setDetail(detail);
        problem.setInstance(request.getRequestURI());
        return ResponseEntity.status(status).body(problem);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Problem> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        return handleException("/problem/resource-not-found", "Resource Not Found", HttpStatus.NOT_FOUND, ex.getMessage(), request);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Problem> handleHttpMessageNotReadableException(HttpServletRequest request) {
        return handleException("/problem/validation-error", "Validation Error", HttpStatus.BAD_REQUEST, "Your request parameters didn't validate.", request);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Problem> handleHttpMediaTypeNotSupportedException(HttpServletRequest request) {
        return handleException("/problem/media-type-not-supported", "Media Type Not Supported", HttpStatus.UNSUPPORTED_MEDIA_TYPE, "The media type requested is not supported.", request);
    }


}