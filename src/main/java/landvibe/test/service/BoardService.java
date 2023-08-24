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

import static landvibe.test.exception.ErrorCode.*;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    private Member checkValidMember(Long memberId){
       return memberRepository.findById(memberId)
                .orElseThrow(() -> new RuralException(NOT_FOUND_MEMBER));
    }

    @Transactional
    public void saveBoard(Board board) {
        boardRepository.save(board);
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
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new RuralException(NOT_FOUND_BOARD));
    }
}