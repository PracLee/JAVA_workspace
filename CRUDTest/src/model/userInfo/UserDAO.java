package model.userInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;

public class UserDAO {
	public boolean loginCheck(UserVO UVO) { // select all
		Connection conn = JDBC.connect();
		ArrayList<UserVO> datas = new ArrayList<UserVO>();
		PreparedStatement pstmt = null;
		boolean res=false;	// �α��� ���� üũ
		try {
			String sql = "select * from userInfo"; // �ֱ� �Խñ� ��� ��ġ
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("1��");
			while (rs.next()) {
				UserVO data = new UserVO();
				System.out.println("2��");
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
			System.out.println("showlist()���� ���");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return res;
	}
	
	public void JoinUs(UserVO UVO) { // select all
		Connection conn = JDBC.connect();
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into userInfo(ID,PW) values (?,?)"; // �ֱ� �Խñ� ��� ��ġ
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, UVO.getID());
			pstmt.setString(2, UVO.getPW());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("JoinUs()���� ���");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return;
	}
	
}
