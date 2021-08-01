package at.htlwienwest.rezept_tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BewertungNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(BewertungNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String bewertungNotFoundHandler(BewertungNotFoundException ex) {
        return ex.getMessage();
    }
}
