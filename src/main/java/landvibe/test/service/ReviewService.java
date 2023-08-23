package landvibe.test.service;

import landvibe.test.domain.Board;
import landvibe.test.domain.Member;
import landvibe.test.domain.Reviews;
import landvibe.test.exception.RuralException;
import landvibe.test.repository.BoardRepository;
import landvibe.test.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final BoardRepository boardRepository;

    public List<Reviews> findReviewsByBoardId(Long boardId) {
        Optional<List<Reviews>> reviews = reviewRepository.findAllByTargetBoard_BoardId(boardId);
        return reviews.orElse(null);
    }

    @Transactional
    public void saveReview(Long boardId, Member creator, Reviews review) {
        Optional<Board> byId = boardRepository.findById(boardId);
        if (byId.isEmpty()) {
            throw new RuralException("리뷰는 존재하는 공고에만 작성할 수 있습니다.");
        }
        review.setTargetBoard(byId.get());
        review.setCreator(creator);
        reviewRepository.save(review);
    }
}
