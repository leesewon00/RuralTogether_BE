package landvibe.test.controller;

import jakarta.servlet.http.HttpSession;
import landvibe.test.domain.Member;
import landvibe.test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static landvibe.test.Message.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
@CrossOrigin(origins = "")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/new")
    public String createMember(@RequestBody Member member) {
        memberService.save(member);
        return VALID_MEMBER_CREATE.getDetail();
    }

    @PostMapping("/login")
    public String login(@RequestBody Member member) {
        memberService.login(member.getEmail(), member.getPassword());
        return LOGIN_SUCCESS.getDetail();
    }

    @PostMapping("/logout")
    public String logout() {
        // no session
        return LOGOUT_SUCCESS.getDetail();
    }
}
