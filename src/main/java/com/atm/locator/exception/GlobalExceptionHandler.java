package com.atm.locator.exception;

import com.atm.locator.exception.custom.MandatoryFieldException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({Exception.class})
    public void handleException(Exception e) {
        log.error("Error while processing request: " + e.getMessage());
        e.printStackTrace();
    }

    @ExceptionHandler({MandatoryFieldException.class})
    public void handleMandatoryFieldException(Exception e) {
        log.error("Missing Mandatory Parameters: " + e.getMessage());
        e.printStackTrace();
    }

}
