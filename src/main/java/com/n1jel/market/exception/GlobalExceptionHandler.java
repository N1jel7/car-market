package com.n1jel.market.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({CarNotFoundException.class})
    public String handleCarNotFound(CarNotFoundException carNotFoundException) {
        return "exception-page";
    }
}
