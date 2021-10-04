package model.board;

import java.util.ArrayList;


public interface BoardService {
	// DAO에서 사용하는 메소드명을 다른 서비스에서 사용할 수 있어야 하기 때문에 인터페이스로 강제함!
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO getOne(BoardVO vo);
	public ArrayList<BoardVO> getAll();
	
}
