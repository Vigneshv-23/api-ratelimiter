package dev.vignesh.ratelimiter.exception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler
{
         @ExceptionHandler(MethodArgumentNotValidException.class)
         public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex)
         {
          Map<String,String> errors = new HashMap<>();
            for(FieldError error : ex.getBindingResult().getFieldErrors())
            {
                errors.put(
                        error.getField(),
                        error.getDefaultMessage()
                );
            }
             log.warn("Validation failed: {}", ex.getMessage());
            return ResponseEntity.badRequest().body(errors);
         }

}
