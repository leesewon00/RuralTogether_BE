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
    public ResponseEntity createMember(@RequestBody Member member) {
        memberService.save(member);
        return ResponseEntity.ok(memberService.getByEmail(member.getEmail()));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Member member, HttpSession session) {
        Optional<Member> findMember = memberService.login(member);

        if (findMember.isEmpty()) {
            return ResponseEntity.badRequest().body("아이디 또는 비밀번호 불일치");
        }
        if (findMember.get().getApprove().equals(false)) {
            return ResponseEntity.badRequest().body("승인 대기중인 회원");
        }

        session.setAttribute("loginMember", member);
        return new ResponseEntity(HttpStatus.OK);
    }

}
