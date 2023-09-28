package com.example.demo;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoRecordFoundException.class)
    public ResponseEntity<Map<String, List<String>>> noRecordFoundException(NoRecordFoundException ex) {
        Map<String, List<String>> errors = new HashMap<>();
        List<String> errorMessages = new ArrayList<>();
        String message = ex.getMessage();
        errorMessages.add(message);
        errors.put("errors", errorMessages);
        return new ResponseEntity<>(errors, new HttpHeaders(), INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, List<String>>> exception(Exception ex) {
        Map<String, List<String>> errors = new HashMap<>();
        List<String> errorMessages = new ArrayList<>();
        String message = ex.getMessage();
        errorMessages.add(message);
        errors.put("errors", errorMessages);
        return new ResponseEntity<>(errors, new HttpHeaders(), INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, List<String>>> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        Map<String, List<String>> errors = new HashMap<>();
        List<String> errorMessages = new ArrayList<>();
        if (ex.getCause().getCause().getMessage().contains("No enum constant")) {
            errorMessages.add("'" + ex.getName() + "'" + " should be one of these " + Arrays.stream(ex.getRequiredType().getEnumConstants()).collect(Collectors.toList()));
        } else {
            String message = ex.getMessage();
            String parameterName = ex.getParameter().getParameterName();
            if (ex.getLocalizedMessage().startsWith("Failed to convert value")) {
                errorMessages.add(parameterName + " should be in yyyy-MM-dd format");
            } else {
                errorMessages.add(message);
            }
        }
        errors.put("errors", errorMessages);
        return new ResponseEntity<>(errors, new HttpHeaders(), BAD_REQUEST);
    }


}
