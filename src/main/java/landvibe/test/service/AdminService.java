package landvibe.test.service;

import landvibe.test.domain.Member;
import landvibe.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final MemberRepository memberRepository;

    public List<Member> findMembersApproveFalse() {
        List<Member> members = memberRepository.findByApproveFalse();
        return members;
    }

    public void approveMember(Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        member.setApprove(true);
    }
    public void refuseMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
