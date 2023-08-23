package landvibe.test.repository;

import landvibe.test.domain.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Long> {
    Optional<List<Reviews>> findAllByTargetBoard_BoardId(Long boardId);
}