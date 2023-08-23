package landvibe.test.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RuralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuralException.class)
    public ResponseEntity<ErrorResponse> ruralExceptionHandler(RuralException e) {
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }
}

