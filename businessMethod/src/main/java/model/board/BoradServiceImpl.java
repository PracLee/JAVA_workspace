package model.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("boardService")	// ���� ��ü�� ȣ�� �� �� �ְ� ���ִ� service ������̼�
public class BoradServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getOne(BoardVO vo) {
		return boardDAO.getOne(vo);
	}

	@Override
	public ArrayList<BoardVO> getAll() {
		// TODO Auto-generated method stub
		return boardDAO.getAll();
	}

}
