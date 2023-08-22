package landvibe.test.service;

import landvibe.test.domain.Member;
import landvibe.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final MemberRepository memberRepository;

    public List<Member> findMembersApproveFalse() {
        Optional<List<Member>> byApproveFalse = memberRepository.findByApproveFalse();
        if(byApproveFalse.isEmpty()){
            return null;
        }
        return byApproveFalse.get();
    }

    @Transactional
    public void approveMember(Long memberId) throws Exception {
        Optional<Member> byId = memberRepository.findById(memberId);
        if(byId.isEmpty()){
            // 존재하지 않는 회원
            throw new Exception();
        }
        byId.get().setApprove(true);
    }

    @Transactional
    public void refuseMember(Long memberId) throws Exception {
        Optional<Member> byId = memberRepository.findById(memberId);
        if(byId.isEmpty()){
            // 존재하지 않는 회원
            throw new Exception();
        }
        memberRepository.deleteById(memberId);
    }
}
