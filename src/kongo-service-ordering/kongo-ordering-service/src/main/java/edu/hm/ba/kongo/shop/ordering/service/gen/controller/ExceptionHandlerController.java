package edu.hm.ba.kongo.shop.ordering.service.gen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Fabian on 20.02.2017.
 */
@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleException(Throwable ex) {
        return ex.getMessage();
    }
}
