package landvibe.test.service;

import landvibe.test.domain.Member;
import landvibe.test.exception.ErrorCode;
import landvibe.test.exception.RuralException;
import landvibe.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class AdminService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<Member> findMembersApproveFalse() {
        Optional<List<Member>> byApproveFalse = memberRepository.findByApproveFalse();
        return byApproveFalse.orElse(null);
    }

    private Member checkValidMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new RuralException(ErrorCode.NOT_FOUND_MEMBER));
    }

    public void approveMember(Long memberId) {
        Member member = checkValidMember(memberId);
        member.setApprove(true);
    }

    public void refuseMember(Long memberId) {
        checkValidMember(memberId);
        memberRepository.deleteById(memberId);
    }
}
