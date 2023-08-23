package landvibe.test.repository;

import landvibe.test.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<List<Board>> findByTitleContaining(String keyword);

    Optional<List<Board>> findByRegionContaining(String region);
}