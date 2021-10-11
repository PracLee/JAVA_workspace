package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//기존의 OOP 언어체계에서 AOP가 갖는 한계
@Service("boardService")	// 서비스 객체를 호출 할 수 있게 해주는 service 어노테이션
public class BoradServiceImpl implements BoardService{
	
	@Autowired
	private SpringBoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getOne(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getAll() {
		return boardDAO.getBoardList();
	}

}
