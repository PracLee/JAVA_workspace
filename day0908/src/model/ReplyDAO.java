package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReplyDAO {
	String sql_selectAll = "select * from reply where cnum = ? order by rNum";
	String sql_selectOne = "select * from reply where cnum = ? and rid = ? and rom=?";
	String sql_update = "update reply set rom = ? where rNum = ?";
	String sql_delete = "delete from reply where rNum = ?";
	String sql_delete_comment = "delete from reply where cNum = ?";
	String sql_insert = "insert into reply values ((SELECT NVL(MAX(rnum),0) + 1 FROM reply),?,?,?)";
	
	public ReplyVO selectOne(ReplyVO RVO) {
		// String sql_selectOne = "select * from reply where cnum = ? and rid = ? and rom=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ReplyVO data = null;
		ArrayList<ReplyVO> datas = new ArrayList<ReplyVO>();
		try {
			conn = DBCP.connect();
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, RVO.getCnum());
			pstmt.setString(2, RVO.getRid());
			pstmt.setString(3, RVO.getRom());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
			data = new ReplyVO();
			while (rs.next()) {
				data.setCnum(rs.getInt("cnum"));
				data.setRid(rs.getString("rid"));
				data.setRnum(rs.getInt("rnum"));
				data.setRom(rs.getString("rom"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			DBCP.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public ArrayList<ReplyVO> selectAll(int cnum) {
		//		String sql_selectAll = "select * from reply where cnum = ? order by rNum";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<ReplyVO> datas = new ArrayList<ReplyVO>();
		try {
			conn = DBCP.connect();
			pstmt = conn.prepareStatement(sql_selectAll);
			pstmt.setInt(1, cnum);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ReplyVO data = new ReplyVO();
				data.setCnum(rs.getInt("cnum"));
				data.setRid(rs.getString("rid"));
				data.setRnum(rs.getInt("rnum"));
				data.setRom(rs.getString("rom"));
				datas.add(data);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			DBCP.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public void insert(ReplyVO RVO) {
		//insert into reply values ((SELECT NVL(MAX(rNum),0) + 1 FROM re),?,?,?)
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBCP.connect();
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, RVO.getRid());
			pstmt.setInt(2, RVO.getCnum());
			pstmt.setString(3, RVO.getRom());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return;
	}
	public void update(ReplyVO RVO) {
		//	"update reply set rom = ? where rNum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBCP.connect();
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, RVO.getRom());
			pstmt.setInt(2, RVO.getRnum());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return;
	}
	public void delete(ReplyVO RVO) {
		// sql_delete = "delete from reply where rNum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBCP.connect();
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, RVO.getRnum());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return;
	}
	public void deleteComment(CommentVO CVO) {
		// 	String sql_delete_comment = "delete from reply where cNum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBCP.connect();
			pstmt = conn.prepareStatement(sql_delete_comment);
			pstmt.setInt(1, CVO.getcNum());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return;
	}
}
