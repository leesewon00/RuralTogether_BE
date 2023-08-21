package landvibe.test;


import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity controllerIllegalStateException() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
