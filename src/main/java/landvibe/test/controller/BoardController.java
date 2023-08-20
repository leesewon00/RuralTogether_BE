package landvibe.test.controller;

import landvibe.test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
//@CrossOrigin(origins = "http://localhost:8080")
public class BoardController {
    private final BoardService boardService;
}
