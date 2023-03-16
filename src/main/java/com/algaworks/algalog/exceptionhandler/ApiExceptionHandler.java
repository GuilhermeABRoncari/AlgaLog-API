package com.algaworks.algalog.exceptionhandler;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    private MessageSource messageSource;
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ErrorProblem.thisFields> errorField = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) error).getField();
            String fieldMessage = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            errorField.add(new ErrorProblem.thisFields(fieldName, fieldMessage));
        }

        ErrorProblem error = new ErrorProblem();
        error.setStatus(status.value());
        error.setDateTime(LocalDateTime.now());
        error.setTitle("One or more mandatory fields are invalids. Try again.");
        error.setFields(errorField);

        return handleExceptionInternal(ex, error, headers, status, request);
    }
}