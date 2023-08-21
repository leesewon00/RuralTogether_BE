package landvibe.test.service;

import landvibe.test.domain.Member;
import landvibe.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void save(Member member) {
        memberRepository.save(member);
    }

    public Optional<Member> getByMemberId(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public Optional<Member> login(Member member) {
        return memberRepository.findByEmailAndPassword(member.getEmail(), member.getPassword());
    }

    public Optional<Member> getByEmail(String name) {
        return memberRepository.findByEmail(name);
    }
}
