package landvibe.test.controller;

import jakarta.servlet.http.HttpServletRequest;
import landvibe.test.RegionName;
import landvibe.test.domain.Board;
import landvibe.test.domain.Member;
import landvibe.test.exception.RuralException;
import landvibe.test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
@CrossOrigin(origins = "")
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
    public ResponseEntity create(@RequestBody Board board) {
        Long boardId = boardService.saveBoard(board);
        return ResponseEntity.ok().body("게시글 등록 성공");
    }

    @GetMapping("")
    public ResponseEntity<List<Board>> getBoards() {
        List<Board> boards = boardService.getAllBoard();
        return ResponseEntity.ok(boards); // 비어있는 리스트 반환 가능
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<Board> getBoard(@PathVariable("boardId") Long boardId) {
        Board boardById = boardService.getBoardById(boardId);
        return ResponseEntity.ok(boardById);
    }

    @GetMapping("/keyword")
    public ResponseEntity<List<Board>> getBoardsByKeyword(@RequestParam String keyword) {
        List<Board> boards = boardService.getBoardsByKeyword(keyword);
        return ResponseEntity.ok(boards); // 비어있는 리스트 반환 가능
    }

    /**
     * @param region enum, 에러 발생가능. 클라이언트에서 반드시 enum 데이터와 같은 string 을 쏴야함
     */

    @GetMapping("/region")
    public ResponseEntity<List<Board>> getBoardsByRegion(@RequestParam RegionName region) {
        List<Board> boards = boardService.getBoardsByRegion(region.message);
        return ResponseEntity.ok(boards);
    }

}





