package landvibe.test.controller;

import jakarta.servlet.http.HttpSession;
import landvibe.test.domain.Member;
import landvibe.test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity login(Member member1, HttpSession session) {
        Optional<Member> member = memberService.login(member1);
        if (member.isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        session.setAttribute("loginMember", member);
        return new ResponseEntity(HttpStatus.OK);
    }

}
