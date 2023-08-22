package landvibe.test.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RuralExceptionHandler {
    @ExceptionHandler(RuralException.class)
    public ResponseEntity blogExceptionHandler(RuralException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
