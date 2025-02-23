package br.com.dessafio_cdc.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ValidationErroHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalAccessException.class)
    public String handleIllegalAccessException(IllegalAccessException exception) {
//        List<ObjectError> globalErro = exception.getBindingResult().getGlobalErrors();
//        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
//        return buildValidationErrors(globalErro, fieldErrors);

        return exception.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleMethodNotValidaException(MethodArgumentNotValidException exception) {
        List<ObjectError> globalErro = exception.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        return buildValidationErrors(globalErro, fieldErrors);
    }

    private String buildValidationErrors(List<ObjectError> globalErro, List<FieldError> fieldErrors) {
        // ta simplificado
        return globalErro.toString() + fieldErrors.toString();
    }


}
