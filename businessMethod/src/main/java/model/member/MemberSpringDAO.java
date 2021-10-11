package model.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MemberSpringDAO {
	private final String insertSQL = "insert into member(id, pw, name, role) value (?,?,?,?)";
	private final String updateSQL = "update member set pw = ?, name =?, role =? where id = ?";
	private final String deleteSQL = "delete from member where id = ?";
	private final String getOneSQL = "select * from member where id =?";
	private final String getAllSQL = "select * from member";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertBoard(MemberVO vo) {
		//	"insert into member(id, pw, name, role) value (?,?,?,?)";
		jdbcTemplate.update(insertSQL,vo.getId(),vo.getPw(),vo.getName(),vo.getRole());
	}
	public void updateBoard(MemberVO vo) {

		// private final String updateSQL = "update member set pw = ?, name =?, role =? where id = ?";
		jdbcTemplate.update(updateSQL,vo.getPw(),vo.getName(),vo.getRole(),vo.getId());
	}
	public void deleteBoard(MemberVO vo) {
		// 	private final String deleteSQL = "delete from member where id = ?";
		jdbcTemplate.update(deleteSQL,vo.getId());
	}
	public MemberVO getOne(MemberVO vo) {
		//	private final String getOneSQL = "select * from member where id =?";
		Object[] args = {vo.getId()};
		return jdbcTemplate.queryForObject(getOneSQL,args,new MemberRowMapper());
	}
	public List<MemberVO> getAll() {
		//		private final String getAllSQL = "select * from board";
		return jdbcTemplate.query(getAllSQL, new MemberRowMapper());
	}
}

class MemberRowMapper implements RowMapper<MemberVO>{

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data = new MemberVO();
		data.setId(rs.getString("id"));
		data.setPw(rs.getString("pw"));
		data.setName(rs.getString("name"));
		data.setRole(rs.getString("role"));
		return data;
	}
	
}
