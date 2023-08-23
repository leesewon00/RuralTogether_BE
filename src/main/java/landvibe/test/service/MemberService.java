package landvibe.test.service;

import landvibe.test.domain.Member;
import landvibe.test.exception.RuralException;
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
        if(memberRepository.findByEmail(member.getEmail()).isPresent()){
            throw new RuralException("이미 등록되어 있는 회원");
        }
        memberRepository.save(member);
    }

    public Member login(Member member) {
        Optional<Member> optionalMember=memberRepository.findByEmailAndPassword(member.getEmail(), member.getPassword());
        if(optionalMember.isEmpty()){
            throw new RuralException("아이디 또는 비밀번호 불일치");
        }
        if(optionalMember.get().getApprove().equals(false)){
            throw new RuralException("승인 대기중인 회원");
        }
        return optionalMember.get();
    }

    public Optional<Member> getByEmail(String name) {
        return memberRepository.findByEmail(name);
    }
}
