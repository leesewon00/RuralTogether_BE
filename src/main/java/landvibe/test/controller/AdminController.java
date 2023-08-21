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
//@CrossOrigin(origins = "http://localhost:8080")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/members")
    public ResponseEntity list() {
        List<Member> members = adminService.findMembersApproveFalse();
        return ResponseEntity.ok(members);
    }

    @PostMapping("/members/approve/{memberId}") // 승인
    public ResponseEntity approve(@PathVariable Long memberId) {
        adminService.approveMember(memberId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/members/refuse/{memberId}") // 거부
    public ResponseEntity refuse(@PathVariable Long memberId) {
        adminService.refuseMember(memberId);
        return ResponseEntity.ok().build();
    }
}
