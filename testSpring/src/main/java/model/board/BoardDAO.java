package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	private final String insertSQL="insert into board (id,title,writer,content) values((select nvl(max(id),0)+1 from board),?,?,?)";
	private final String updateSQL="update board set title=?,content=? where id=?";
	private final String deleteSQL="delete board where id=?";
	private final String getBoardSQL="SELECT * FROM board WHERE id = ? ";
	private final String getBoardListSQL="SELECT * FROM board WHERE content LIKE ? ";
	@Autowired
	private JdbcTemplate jt;
	
	public void insertBoard(BoardVO vo) {
	      System.out.println("jdbcTemplate으로 insert");
	      jt.update(insertSQL,vo.getTitle(),vo.getWriter(),vo.getContent());
	   }
	   
	   public void updateBoard(BoardVO vo) {
	      System.out.println("jdbcTemplate으로 update");
	      jt.update(updateSQL,vo.getTitle(),vo.getWriter(),vo.getContent());
	   }
	   
	   public void deleteBoard(BoardVO vo) {
	      System.out.println("jdbcTemplate으로 delete");
	      jt.update(deleteSQL,vo.getId());
	   }
	   
	   public List<BoardVO> getBoardList() {
	      System.out.println("jdbcTemplate으로 getBoardList");
	      return jt.query(getBoardListSQL,new BoardRowMapper());
	   }
	   
	   public BoardVO getBoard(BoardVO vo) {
	      System.out.println("jdbcTemplate으로 getBoard");
	      Object[] args= { vo.getId() };
	      return jt.queryForObject(getBoardSQL,args,new BoardRowMapper());
	   }

}
class BoardRowMapper implements RowMapper<BoardVO> {

	   @Override
	   public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	      BoardVO data=new BoardVO();
	      data.setId(rs.getInt("id"));
	      data.setTitle(rs.getString("title"));
	      data.setWriter(rs.getString("writer"));
	      data.setContent(rs.getString("content"));
	      data.setWdate(rs.getDate("wdate"));
	      return data;
	   }
	   
	}
