package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import model.JDBC;

@Repository("boardDAO")
public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String insertSQL = "insert into board(id, title, writer, content) value (?,?,?,?)";
	private final String updateSQL = "update board set title = ?, content =? where id = ?";
	private final String deleteSQL = "delete from board where id = ?";
	private final String getOneSQL = "select * from board where id =?";
	private final String getAllSQL = "select * from board";
	
	public void insertBoard(BoardVO vo) {
		//	private final String insertSQL = "insert into board(id, title, writer, content) value (?,?,?,?)";
		conn = JDBC.getConnectinon();
		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setInt(1, vo.getId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getWriter());
			pstmt.setString(4, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
	}
	public void updateBoard(BoardVO vo) {
		//	private final String updateSQL = "update board set title = ?, content =? where id = ?";
		conn = JDBC.getConnectinon();
		try {
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		
	}
	public void deleteBoard(BoardVO vo) {
		// 	private final String deleteSQL = "delete from board where id = ?";
		conn = JDBC.getConnectinon();
		try {
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		
	}
	public BoardVO getOne(BoardVO vo) {
		//	private final String getOneSQL = "select * from board where id =?";
		conn = JDBC.getConnectinon();
		BoardVO data = null;
		try {
			pstmt = conn.prepareStatement(getOneSQL);
			pstmt.setInt(1, vo.getId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				data = new BoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setDate(rs.getDate("wdate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt, rs);
		}

		return data;
		
	}
	public ArrayList<BoardVO> getAll() {
		//		private final String getAllSQL = "select * from board";
		conn = JDBC.getConnectinon();
		BoardVO data = null;
		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
		try {
			pstmt = conn.prepareStatement(getAllSQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				data = new BoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setDate(rs.getDate("wdate"));
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
