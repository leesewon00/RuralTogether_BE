package landvibe.test.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RuralException extends RuntimeException {
    private final ErrorCode errorCode;
}
