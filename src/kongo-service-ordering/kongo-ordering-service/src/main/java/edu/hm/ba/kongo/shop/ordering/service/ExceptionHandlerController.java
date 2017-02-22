package edu.hm.ba.kongo.shop.ordering.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fabian on 20.02.2017.
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseBody
    public ResponseEntity handleUnsupportedOperationException(Throwable ex) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 500);
        responseBody.put("error", "Unsupported Operation Exception");
        responseBody.put("message", ex.getMessage());

        return new ResponseEntity<Map>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity handleIllegalArgumentException(Throwable ex) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 422);
        responseBody.put("error", "Illegal Argument Exception");
        responseBody.put("message", ex.getMessage());

        return new ResponseEntity<Map>(responseBody, HttpStatus.UNPROCESSABLE_ENTITY);
    }


}
