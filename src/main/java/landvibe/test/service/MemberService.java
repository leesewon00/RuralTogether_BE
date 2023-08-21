package landvibe.test.service;

import landvibe.test.domain.Member;
import landvibe.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(Member member) {
        memberRepository.save(member);
    }

    public Optional<Member> getByMemberId(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public Optional<Member> login(Member member) {
        return memberRepository.findByEmailAndPasswordAndApprove(member.getEmail(), member.getPassword(), true);
    }

    public Optional<Member> getByEmail(String name) {
        return memberRepository.findByEmail(name);
    }
}
