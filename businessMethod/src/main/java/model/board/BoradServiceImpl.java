package model.board;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.app.common.LogPlusAdvice;
//������ OOP ���ü�迡�� AOP�� ���� �Ѱ�
@Service("boardService")	// ���� ��ü�� ȣ�� �� �� �ְ� ���ִ� service ������̼�
public class BoradServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
	private LogPlusAdvice logPlusAdvice;
	
	public BoradServiceImpl() {
		this.logPlusAdvice = new LogPlusAdvice();
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		logPlusAdvice.printPlusLog();
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		logPlusAdvice.printPlusLog();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		logPlusAdvice.printPlusLog();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getOne(BoardVO vo) {
		logPlusAdvice.printPlusLog();
		return boardDAO.getOne(vo);
	}

	@Override
	public ArrayList<BoardVO> getAll() {
		logPlusAdvice.printPlusLog();
		return boardDAO.getAll();
	}

}
