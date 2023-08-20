package landvibe.test.controller;

import landvibe.test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
//@CrossOrigin(origins = "http://localhost:8080")
public class MemberController {
    private final MemberService memberService;

}
