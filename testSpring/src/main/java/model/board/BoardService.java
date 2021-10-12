package model.board;

import java.util.List;


public interface BoardService {
	public BoardVO selectOne(BoardVO vo);
	public List<BoardVO> selectAll(String word);
	public void insert(BoardVO vo);
	public void update(BoardVO vo);
	public void delete(BoardVO vo);

}
