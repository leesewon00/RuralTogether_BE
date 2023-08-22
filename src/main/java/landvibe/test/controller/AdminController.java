package landvibe.test.controller;

import landvibe.test.domain.Member;
import landvibe.test.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/members")
    public ResponseEntity list() {
        List<Member> members = adminService.findMembersApproveFalse();
        return ResponseEntity.ok().body(members);
    }

    @PostMapping("/members/approve/{memberId}") // 승인
    public ResponseEntity approve(@PathVariable Long memberId) throws Exception {
        adminService.approveMember(memberId);
        return ResponseEntity.ok().body("승인되었습니다.");
    }

    @PostMapping("/members/refuse/{memberId}") // 거부
    public ResponseEntity refuse(@PathVariable Long memberId) throws Exception {
        adminService.refuseMember(memberId);
        return ResponseEntity.ok().body("거부되었습니다.");
    }
}
