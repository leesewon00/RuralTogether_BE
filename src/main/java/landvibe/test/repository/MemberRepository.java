package landvibe.test.repository;

import landvibe.test.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByApproveFalse();

    Optional<Member> findByEmailAndPassword(String email, String password);

    Optional<Member> findByEmail(String email);


}