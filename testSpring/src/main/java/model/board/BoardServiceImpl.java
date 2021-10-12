package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO bdao;
	
	@Override
	public BoardVO selectOne(BoardVO vo) {
		return bdao.getBoard(vo);
	}

	@Override
	public List<BoardVO> selectAll(String word) {
		return bdao.getBoardList(word);
	}

	@Override
	public void insert(BoardVO vo) {
		bdao.insertBoard(vo);
	}

	@Override
	public void update(BoardVO vo) {
		bdao.updateBoard(vo);
	}

	@Override
	public void delete(BoardVO vo) {
		bdao.deleteBoard(vo);
	}

}
