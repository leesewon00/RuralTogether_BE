package landvibe.test.controller;

import jakarta.servlet.http.HttpSession;
import landvibe.test.domain.Member;
import landvibe.test.exception.RuralException;
import landvibe.test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
@CrossOrigin(origins = "")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/new")
    public ResponseEntity createMember(@RequestBody Member member) {
        if (memberService.getByEmail(member.getEmail()).isPresent()) {
            // email 중복 예외처리
            throw new RuralException("이미 등록되어 있는 회원입니다.");
        }
        memberService.save(member);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Member member, HttpSession session) {
        Optional<Member> findMember = memberService.login(member);

        if (findMember.isEmpty()) {
            throw new RuralException("아이디 또는 비밀번호 불일치");
        }
        if (findMember.get().getApprove().equals(false)) {
            throw new RuralException("승인 대기중인 회원");
        }

        session.setAttribute("loginMember", findMember.get());
        return ResponseEntity.ok().body("로그인 성공");
    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok().body("로그아웃 성공");
    }

}
