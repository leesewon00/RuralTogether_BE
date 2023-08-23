package landvibe.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Message {

    // Member
    VALID_MEMBER_CREATE("SIGN UP SUCCESS"),
    LOGIN_SUCCESS("LOGIN SUCCESS"),
    LOGOUT_SUCCESS("LOGOUT SUCCESS"),

    // Board
    VALID_BOARD_CREATE("CREATE BOARD SUCCESS"),

    // Admin
    APPROVE_SUCCESS("APPROVE SUCCESS"),
    REFUSE_SUCCESS("REFUSE SUCCESS");

    private final String detail;
}
