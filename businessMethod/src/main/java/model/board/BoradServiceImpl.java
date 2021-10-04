package model.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("boardService")	// 서비스 객체를 호출 할 수 있게 해주는 service 어노테이션
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
