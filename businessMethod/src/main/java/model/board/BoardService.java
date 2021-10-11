package model.board;

import java.util.List;


public interface BoardService {
	// DAO���� ����ϴ� �޼ҵ���� �ٸ� ���񽺿��� ����� �� �־�� �ϱ� ������ �������̽��� ������!
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO getOne(BoardVO vo);
	public List<BoardVO> getAll();
	
}
