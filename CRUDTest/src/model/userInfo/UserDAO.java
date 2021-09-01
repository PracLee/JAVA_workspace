package model.userInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;

public class UserDAO {
	public boolean loginCheck(UserVO UVO) { // select all
		Connection conn = JDBC.connect();
		UserVO data = new UserVO();
		ArrayList<UserVO> datas = new ArrayList<UserVO>();
		PreparedStatement pstmt = null;
		boolean res=false;	// �α��� ���� üũ
		try {
			String sql = "select * from userInfo"; // �ֱ� �Խñ� ��� ��ġ
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				data.setID(rs.getString("ID"));
				data.setPW(rs.getString("PW"));
				datas.add(data);
			}
			rs.close();
			for(int i=0;i<datas.size();i++) {
				if(datas.get(i).getID().equals(UVO.getID())&&datas.get(i).getPW().equals(UVO.getPW())) {
					res=true;
					break;
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
		} catch (Exception e) {
			System.out.println("JoinUs()���� ���");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return;
	}
	
}
