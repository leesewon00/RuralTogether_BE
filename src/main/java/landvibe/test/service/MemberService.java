package landvibe.test.service;

import landvibe.test.domain.Member;
import landvibe.test.exception.RuralException;
import landvibe.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static landvibe.test.exception.ErrorCode.*;

import static landvibe.test.exception.ErrorCode.*;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    private void checkDuplicatedEmail(String email) {
        memberRepository.findByEmail(email).ifPresent(value -> {
            throw new RuralException(DUPLICATED_MEMBER_EMAIL);
        });
    }

    private Member checkValidMember(String email, String password) {
        Member member = memberRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new RuralException(INVALID_ID_PASSWORD));

        if (member.getApprove().equals(false)) {
            throw new RuralException(UNAUTHORIZED_USER);
        }
        return member;
    }

    public void save(Member member) {
        checkDuplicatedEmail(member.getEmail());
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Member login(String email, String password) {
        return checkValidMember(email, password);
    }

}
