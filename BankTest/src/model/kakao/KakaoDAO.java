package model.kakao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;
import model.sinhan.SinhanVO;
public class KakaoDAO {
	String sql_selectAll = "select * from KAKAO";
	public ArrayList<KakaoVO> selectAll() {
		//	String sql_selectAll = "select * from KAKAO";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<KakaoVO> datas = new ArrayList<KakaoVO>();
		try {
			conn = JDBC.connect();
			pstmt = conn.prepareStatement(sql_selectAll);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				KakaoVO data = new KakaoVO();
				data.setAccount(rs.getInt("account"));
				data.setBalance(rs.getInt("balance"));
				data.setName(rs.getString("name"));
				datas.add(data);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			JDBC.disconnect(pstmt, conn);
		}
		return datas;
	}
	
}
