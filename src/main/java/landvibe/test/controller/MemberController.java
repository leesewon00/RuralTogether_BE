package landvibe.test.controller;

import jakarta.servlet.http.HttpSession;
import landvibe.test.domain.Member;
import landvibe.test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
//@CrossOrigin(origins = "http://localhost:8080")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/new")
    public ResponseEntity createMember(Member member) {
        memberService.save(member);
        return ResponseEntity.ok(memberService.getByEmail(member.getEmail()));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
        Member member = memberService.login(email, password);
        session.setAttribute("member", member);
        return ResponseEntity.ok(memberService.getByEmail(email));
    }

}
