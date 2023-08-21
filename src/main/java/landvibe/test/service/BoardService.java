package landvibe.test.service;

import landvibe.test.RegionName;
import landvibe.test.domain.Board;
import landvibe.test.domain.Member;
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
    public Long saveBoard(Member member, Board board) {
        board.setCreator(member); // 없는 맴버면 에러발생 가능, 에러 로직 아직 X
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