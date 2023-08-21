package landvibe.test.controller;

import landvibe.test.domain.Board;
import landvibe.test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
//@CrossOrigin(origins = "http://localhost:8080")
public class BoardController {
    private final BoardService boardService;

    /**
     * -boards
     * <p>
     * 게시글 등록 [post]  /boards/new
     * (@RequestBody Blog blog 사용)
     * <p>
     * 게시글 상세 조회 [get]  /boards/{boardId}
     * (@PathVariable long boardId 사용)
     * <p>
     * 게시글 키워드(제목)로 리스팅 [get]  /boards?keyword=${keyword}
     * (@RequestParam string keyword 사용)
     * <p>
     * 게시글 카테고리(지역)으로 리스팅 [get]  /boards?region=${region}
     * (@RequestParam string region 사용)
     */

    @PostMapping("/new")
    public ResponseEntity<Board> create(@RequestBody Board board) {
        Long id = boardService.saveBoard(board);
        Board boardById = boardService.getBoardById(id).get(); // optional , 에러 발생 가능
        return ResponseEntity.ok(boardById);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<Board> getBoard(@PathVariable Long boardId) {
        Board boardById = boardService.getBoardById(boardId).get(); // optional, 에러 발생 가능
        return ResponseEntity.ok(boardById);
    }

    @GetMapping("/boards/keyword")
    public ResponseEntity<List<Board>> getBoardsByKeyword(@RequestParam String keyword) {
        List<Board> boards = boardService.getBoardsByKeyword(keyword);
        return ResponseEntity.ok(boards); // 비어있는 리스트 반환 가능
    }

    @GetMapping("/boards/region")
    public ResponseEntity<List<Board>> getBoardsByRegion(@RequestParam String region) {
        List<Board> boards = boardService.getBoardsByKeyword(region);
        return ResponseEntity.ok(boards); // 비어있는 리스트 반환 가능
    }

}





