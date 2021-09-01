package model.post;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;

public class PostDAO {
	public ArrayList<PostVO> showlist() { // select all
		Connection conn = JDBC.connect();
		ArrayList<PostVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from post order by postnum desc"; // 최근 게시글 상단 배치
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Date dateOrigin;
			String dateToStr;
			SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
			while (rs.next()) {
				PostVO vo = new PostVO();
				vo.setContent(rs.getString("content"));
				vo.setTitle(rs.getString("title"));
				vo.setId(rs.getString("id"));
				vo.setPostnum(rs.getInt("postnum"));
				dateOrigin = rs.getDate("postdate");
				dateToStr = dateFix.format(dateOrigin);
				vo.setPostdate(dateToStr);
				datas.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("showlist()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return datas;
	}

	public void viewPost() { // select one

	}

	public boolean postPost(PostVO vo) { // insert
		Connection conn = JDBC.connect();
		ArrayList<PostVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		boolean res = false;
		try {
			String sql = "insert into post values((SELECT NVL(MAX(postNum),0) + 1 FROM post),?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			res = true;
		} catch (Exception e) {
			System.out.println("postPost()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return res;
	}

	public void editPost() { // update

	}

	public void deletePost() { // delete

	}

	public void loginCheck() { // loginCheck

	}

	public ArrayList<PostVO> showMyList(PostVO vo) {
		Connection conn = JDBC.connect();
		ArrayList<PostVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from post where ID=? order by postnum desc"; // 최근 게시글 상단 배치
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			ResultSet rs = pstmt.executeQuery();
			Date dateOrigin;
			String dateToStr;
			SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
			while (rs.next()) {
				PostVO data = new PostVO();
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setId(rs.getString("id"));
				data.setPostnum(rs.getInt("postnum"));
				dateOrigin = rs.getDate("postdate");
				dateToStr = dateFix.format(dateOrigin);
				data.setPostdate(dateToStr);
				datas.add(data);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("showMyList()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return datas;
	}

	public ArrayList<PostVO> findPost(String index) {
		Connection conn = JDBC.connect();
		ArrayList<PostVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from post where title like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, index + "%");
			ResultSet rs = pstmt.executeQuery();
			Date dateOrigin;
			String dateToStr;
			SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
			while (rs.next()) {
				PostVO data = new PostVO();
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setId(rs.getString("id"));
				data.setPostnum(rs.getInt("postnum"));
				dateOrigin = rs.getDate("postdate");
				dateToStr = dateFix.format(dateOrigin);
				data.setPostdate(dateToStr);
				datas.add(data);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("showMyList()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return datas;
	}
}
