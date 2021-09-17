package model;

import java.sql.Connection;
import model.DBCP;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CommentDAO {
	String sql_selectOne = "select * from ctable where ID = ? order by cNum";
	String sql_update = "update ctable set com = ? where cNum = ?";
	String sql_delete = "delete from ctable where cNum = ?";
	String sql_insert = "insert into ctable(cnum, com, id, pw) values ((SELECT NVL(MAX(cNum),0) + 1 FROM ctable),?,?,?)";

	public static ArrayList<CommentVO> selectAll(int cnt) {
		//	String sql_selectAll = "select * from ctable where rownum <= ?  order by cNum";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<CommentVO> datas = new ArrayList<CommentVO>();
		try {
			conn = DBCP.connect();
			String sql_selectAll = "select * from (select * from ctable order by cNum DESC) where rownum <= ?";
			pstmt = conn.prepareStatement(sql_selectAll);
			pstmt.setInt(1, cnt);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CommentVO data = new CommentVO();
				data.setcNum(rs.getInt("cNum"));
				data.setCom(rs.getString("com"));
				data.setID(rs.getString("ID"));
				data.setPW(rs.getString("PW"));
				data.setLikeCnt(rs.getInt("likeCnt"));
				data.setReplyCnt(rs.getInt("replyCnt"));
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
	public ArrayList<CommentVO> selectOne(CommentVO CVO) {
		// String sql_selectOne = "select * from ctable where ID = ? order by cNum";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<CommentVO> datas = new ArrayList<CommentVO>();
		try {
			conn = DBCP.connect();
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setString(1, CVO.getID());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CommentVO data = new CommentVO();
				data.setcNum(rs.getInt("cNum"));
				data.setCom(rs.getString("com"));
				data.setID(rs.getString("ID"));
				data.setPW(rs.getString("PW"));
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
	public void insert(CommentVO CVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBCP.connect();
			if(CVO.getID()!=null) {
				pstmt = conn.prepareStatement(sql_insert);
				pstmt.setString(1, CVO.getCom());
				pstmt.setString(2, CVO.getID());
				pstmt.setString(3, CVO.getPW());
			}else {
				String sql_replyCnt_up = "update ctable set replyCnt = replyCnt + 1 where cNum = ?";
				pstmt = conn.prepareStatement(sql_replyCnt_up);
				pstmt.setInt(1, CVO.getcNum());
			}
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return;
	}
	public void update(CommentVO CVO, String action) {
		//	String sql_update = "update ctable set com = ? where cNum = ?";
		//	String sql_updateLike = "update ctable set likecnt = likecnt+1 where cNum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBCP.connect();
			if(action.equals("likeUp")) {
				String sql_updateLike = "update ctable set likecnt = likecnt+1 where cNum = ?";
				pstmt = conn.prepareStatement(sql_updateLike);
				pstmt.setInt(1, CVO.getcNum());
				pstmt.executeUpdate();
			}else {
				pstmt = conn.prepareStatement(sql_update);
				pstmt.setString(1, CVO.getCom());
				pstmt.setInt(2, CVO.getcNum());
				pstmt.executeUpdate();
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return;
	}
	public void delete(CommentVO CVO) {
		// String sql_delete = "delete from ctable where cNum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBCP.connect();
			pstmt = conn.prepareStatement(sql_delete);
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
