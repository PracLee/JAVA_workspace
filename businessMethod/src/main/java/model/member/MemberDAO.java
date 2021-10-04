package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import model.JDBC;
import model.member.MemberVO;

@Repository("mDAO")
public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String insertSQL = "insert into member(id, pw, name, role) value (?,?,?,?)";
	private final String updateSQL = "update member set pw = ?, name =?, role =? where id = ?";
	private final String deleteSQL = "delete from member where id = ?";
	private final String getOneSQL = "select * from member where id =?";
	private final String getAllSQL = "select * from member";
	
	public void insertBoard(MemberVO vo) {
		//	"insert into member(id, pw, name, role) value (?,?,?,?)";
		conn = JDBC.getConnectinon();
		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
	}
	public void updateBoard(MemberVO vo) {

		// private final String updateSQL = "update member set pw = ?, name =?, role =? where id = ?";
		
		conn = JDBC.getConnectinon();
		try {
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getRole());
			pstmt.setString(4, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		
	}
	public void deleteBoard(MemberVO vo) {
		// 	private final String deleteSQL = "delete from member where id = ?";
		conn = JDBC.getConnectinon();
		try {
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		
	}
	public MemberVO getOne(MemberVO vo) {
		//	private final String getOneSQL = "select * from member where id =?";
		conn = JDBC.getConnectinon();
		MemberVO data = null;
		try {
			pstmt = conn.prepareStatement(getOneSQL);
			pstmt.setString(1, vo.getId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				data = new MemberVO();
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt, rs);
		}

		return data;
		
	}
	public ArrayList<MemberVO> getAll() {
		//		private final String getAllSQL = "select * from board";
		conn = JDBC.getConnectinon();
		MemberVO data = null;
		ArrayList<MemberVO> datas = new ArrayList<MemberVO>();
		try {
			pstmt = conn.prepareStatement(getAllSQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				data = new MemberVO();
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt, rs);
		}

		return datas;
		
	}
}
