package landvibe.test.service;

import landvibe.test.domain.Board;
import landvibe.test.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long saveBoard(Board board) {
        boardRepository.save(board);
        return board.getBoardId();
    }

    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }

    public List<Board> getBoardsByKeyword(String keyword) {
        return boardRepository.findByTitleContaining(keyword);
    }

    public List<Board> getBoardsByRegion(String region) {
        return boardRepository.findByRegionContaining(region);
    }

    public Optional<Board> getBoardById(Long boardId) {
        return boardRepository.findById(boardId);
    }

}