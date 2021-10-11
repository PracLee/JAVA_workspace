package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//������ OOP ���ü�迡�� AOP�� ���� �Ѱ�
@Service("boardService")	// ���� ��ü�� ȣ�� �� �� �ְ� ���ִ� service ������̼�
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
