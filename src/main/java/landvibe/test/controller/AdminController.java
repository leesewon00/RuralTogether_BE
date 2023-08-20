package landvibe.test.controller;

import landvibe.test.domain.Member;
import landvibe.test.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
//@CrossOrigin(origins = "http://localhost:8080")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/members")
    public List<Member> list() {
        List<Member> members = adminService.findMembersApproveFalse();
        return members;
    }

    @PostMapping("/members/approve/{memberId}") // 승인
    public void approve(@PathVariable Long memberId) {
        adminService.approveMember(memberId);
    }

    @PostMapping("/members/refuse/{memberId}") // 거부
    public void refuse(@PathVariable Long memberId) {
        adminService.refuseMember(memberId);
    }
}
