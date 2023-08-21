package landvibe.test.service;

import landvibe.test.domain.Member;
import landvibe.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(Member member) {
        member.setApprove(false);
        memberRepository.save(member);
    }

    public Member getByMemberId(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 회원을 찾을 수 없습니다."));
    }

    public Member login(String email, String password) {
        return memberRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 회원을 찾을 수 없습니다."));
    }

    public Member getByEmail(String name) {
        return memberRepository.findByEmail(name)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 회원을 찾을 수 없습니다."));
    }
}
