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

	public void postPost() { // insert

	}

	public void editPost() { // update

	}

	public void deletePost() { // delete

	}

	public void loginCheck() { // loginCheck

	}

}
