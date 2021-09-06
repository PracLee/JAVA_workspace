package model.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.common.JDBC;

public class PostDAO {
	public ArrayList<PostVO> showPostList(){
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
				vo.setID((rs.getString("id")));
				vo.setPostNum(rs.getInt("postnum"));
				dateOrigin = rs.getDate("postdate");
				dateToStr = dateFix.format(dateOrigin);
				vo.setPostDate(dateToStr);
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

	public void insertPost(PostVO PVO) {
		Connection conn = JDBC.connect();
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into post values((SELECT NVL(MAX(postNum),0) + 1 FROM post),?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, PVO.getTitle());
			pstmt.setString(2, PVO.getContent());
			pstmt.setString(3, PVO.getID());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insertPost()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return;
	}

	public void deletePost(PostVO PVO) {
		Connection conn = JDBC.connect();
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from Post where postnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, PVO.getPostNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("deletePost()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return;
	}
	public void updatePost(PostVO PVO) {
		Connection conn = JDBC.connect();
		PreparedStatement pstmt = null;
		try {
			String sql = "update post set title = ?, content = ? where postNum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, PVO.getTitle());
			pstmt.setString(2, PVO.getContent());
			pstmt.setInt(3, PVO.getPostNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("updatePost()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return;
	}
	public ArrayList<PostVO> whoWriter(PostVO PVO){
		Connection conn = JDBC.connect();
		ArrayList<PostVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from post where ID=? order by postnum desc"; // 최근 게시글 상단 배치
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, PVO.getID());
			ResultSet rs = pstmt.executeQuery();
			Date dateOrigin;
			String dateToStr;
			SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
			while (rs.next()) {
				PostVO data = new PostVO();
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setID(rs.getString("id"));
				data.setPostNum(rs.getInt("postnum"));
				dateOrigin = rs.getDate("postdate");
				dateToStr = dateFix.format(dateOrigin);
				data.setPostDate(dateToStr);
				System.out.println(data);
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
