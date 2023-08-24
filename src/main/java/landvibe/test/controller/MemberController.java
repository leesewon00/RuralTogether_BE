package landvibe.test.controller;

import jakarta.servlet.http.HttpSession;
import landvibe.test.domain.Member;
import landvibe.test.exception.RuralException;
import landvibe.test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        memberService.save(member);
        return new ResponseEntity("회원가입 성공", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Member member) {
        Member findMember = memberService.login(member);
        return new ResponseEntity("로그인 성공", HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity memberById(@PathVariable("memberId") Long id) {
        Member member = memberService.getById(id);
        return new ResponseEntity(member, HttpStatus.OK);
    }

}
