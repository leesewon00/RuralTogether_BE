package landvibe.test.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // Member
    DUPLICATED_MEMBER_EMAIL(CONFLICT, "DUPLICATE EMAIL"),
    INVALID_ID_PASSWORD(UNAUTHORIZED, "INVALID ID OR PASSWORD"),
    UNAUTHORIZED_USER(UNAUTHORIZED, "NOT APPROVED MEMBER"),

    // Board & Admin
    NOT_FOUND_BOARD(NOT_FOUND, "NOT FOUND BOARD"),
    NOT_FOUND_MEMBER(NOT_FOUND, "NOT FOUND MEMBER"),

    // Session
    SESSION_EXPIRATION_STATUS(UNAUTHORIZED, "SESSION_EXPIRATION");


    private final HttpStatus httpStatus;
    private final String detail;
}


