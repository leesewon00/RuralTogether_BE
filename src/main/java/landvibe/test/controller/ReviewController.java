package landvibe.test.controller;

import jakarta.servlet.http.HttpServletRequest;
import landvibe.test.domain.Member;
import landvibe.test.domain.Reviews;
import landvibe.test.exception.RuralException;
import landvibe.test.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{boardId}")
    public ResponseEntity getReviews(@PathVariable("boardId") Long boardId) {
        List<Reviews> reviews = reviewService.findReviewsByBoardId(boardId);
        return ResponseEntity.ok().body(reviews);
    }

    @PostMapping("/new/{boardId}")
    public ResponseEntity create(@PathVariable("boardId") Long boardId,
                                 @RequestBody Reviews review, HttpServletRequest request) {
        reviewService.saveReview(boardId, review);
        return ResponseEntity.ok().body("리뷰 등록 성공");
    }

}
