package landvibe.test.service;

import landvibe.test.domain.Board;
import landvibe.test.domain.Member;
import landvibe.test.exception.RuralException;
import landvibe.test.repository.BoardRepository;
import landvibe.test.repository.MemberRepository;
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
    private final MemberRepository memberRepository;

    @Transactional
    public Long saveBoard(Board board) {
        Board saved = boardRepository.save(board);
        return saved.getBoardId();
    }

    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }

    public List<Board> getBoardsByKeyword(String keyword) {
        Optional<List<Board>> byTitleContaining = boardRepository.findByTitleContaining(keyword);
        return byTitleContaining.orElse(null);
    }

    public List<Board> getBoardsByRegion(String region) {
        Optional<List<Board>> byRegionContaining = boardRepository.findByRegionContaining(region);
        return byRegionContaining.orElse(null);
    }

    public Board getBoardById(Long boardId) {
        Optional<Board> byId = boardRepository.findById(boardId);
        if (byId.isEmpty()) {
            // 없는 게시글이면 에러발생 가능
            throw new RuralException("존재하지 않는 게시글");
        }
        return boardRepository.findById(boardId).get();
    }

}