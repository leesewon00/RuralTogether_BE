package landvibe.test.controller;

import jakarta.servlet.http.HttpServletRequest;
import landvibe.test.RegionName;
import landvibe.test.domain.Board;
import landvibe.test.domain.Member;
import landvibe.test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static landvibe.test.Message.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
@CrossOrigin(origins = "")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/new")
    public String createBoard(@RequestBody Board board, HttpServletRequest request) {
        Object creator = request.getSession().getAttribute("loginMember");
        boardService.saveBoard((Member) creator, board);
        return VALID_BOARD_CREATE.getDetail();
    }

    @GetMapping("")
    public ResponseEntity<List<Board>> getBoards() {
        List<Board> boards = boardService.getAllBoard();
        return ResponseEntity.ok(boards);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<Board> getBoard(@PathVariable("boardId") Long boardId) {
        Board board = boardService.getBoardById(boardId);
        return ResponseEntity.ok(board);
    }

    @GetMapping("/keyword")
    public ResponseEntity<List<Board>> getBoardsByKeyword(@RequestParam String keyword) {
        List<Board> boards = boardService.getBoardsByKeyword(keyword);
        return ResponseEntity.ok(boards);
    }

    /**
     * @param region enum, 에러 발생가능. 클라이언트에서 반드시 enum 데이터와 호환 가능한 string 을 쏴야함
     */

    @GetMapping("/region")
    public ResponseEntity<List<Board>> getBoardsByRegion(@RequestParam RegionName region) {
        List<Board> boards = boardService.getBoardsByRegion(region.message);
        return ResponseEntity.ok(boards);
    }

}





