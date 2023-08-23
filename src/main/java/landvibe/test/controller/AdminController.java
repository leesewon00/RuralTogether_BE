package landvibe.test.controller;

import landvibe.test.Message;
import landvibe.test.domain.Member;
import landvibe.test.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static landvibe.test.Message.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/members")
    public ResponseEntity<List<Member>> list() {
        List<Member> members = adminService.findMembersApproveFalse();
        return ResponseEntity.ok(members);
    }

    @PostMapping("/members/approve/{memberId}") // 승인
    public String approve(@PathVariable Long memberId) {
        adminService.approveMember(memberId);
        return APPROVE_SUCCESS.getDetail();
    }

    @PostMapping("/members/refuse/{memberId}") // 거부
    public String refuse(@PathVariable Long memberId) {
        adminService.refuseMember(memberId);
        return REFUSE_SUCCESS.getDetail();
    }
}
