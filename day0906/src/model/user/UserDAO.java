package model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;
import model.user.UserVO;

public class UserDAO {
	public boolean selectOne(UserVO UVO) {
		Connection conn = JDBC.connect();
		ArrayList<UserVO> datas = new ArrayList<UserVO>();
		PreparedStatement pstmt = null;
		boolean res=false;	// 로그인 유무 체크
		try {
			String sql = "select * from userInfo"; // 최근 게시글 상단 배치
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("1번");
			while (rs.next()) {
				UserVO data = new UserVO();
				System.out.println("2번");
				data.setID(rs.getString("ID"));
				data.setPW(rs.getString("PW"));
				datas.add(data);
			}
			rs.close();
			for(int i=0;i<datas.size();i++) {
				System.out.println(datas.get(i));
				if(UVO.getID().equals(datas.get(i).getID())&&UVO.getPW().equals(datas.get(i).getPW())) {
					res=true;
					return res;
				}
			}
		} catch (Exception e) {
			System.out.println("showlist()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return res;
	}
	public void update(UserVO UVO) {
		Connection conn = JDBC.connect();
		PreparedStatement pstmt = null;
		try {
			String sql = "update userInfo ID = ? set PW = ?"; // 최근 게시글 상단 배치
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, UVO.getID());
			pstmt.setString(2, UVO.getPW());		
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("showlist()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return;
	}
	public void delete(UserVO UVO) {
		Connection conn = JDBC.connect();
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from userInfo where ID = ?"; // 최근 게시글 상단 배치
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, UVO.getID());	
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("showlist()에서 출력");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return;
	}
}
