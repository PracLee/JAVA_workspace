package model.sinhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;
import model.kakao.KakaoVO;

public class SinhanDAO {
	String sql_selectAll = "select * from sinhan";
	public ArrayList<SinhanVO> selectAll() {
		//	String sql_selectAll = "select * from sinhan";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<SinhanVO> datas = new ArrayList<SinhanVO>();
		try {
			conn = JDBC.connect();
			pstmt = conn.prepareStatement(sql_selectAll);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SinhanVO data = new SinhanVO();
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
	public boolean transfer(SinhanVO SVO, KakaoVO KVO, int money, String frombank, String tobank) {	// 주는거 받는거 주고받는 돈 신한에서는 신한돈을 줌
		boolean res = false;
		// String sql_update = "update sinhan set balance = ? where account = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JDBC.connect();
			conn.setAutoCommit(false);
			String sql1 = "update "+frombank+" set balance=balance-? where account = ?";
			String sql2 = "update "+tobank+" set balance=balance+? where account = ?";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, money);
			pstmt.setInt(2, SVO.getAccount());
			pstmt.executeUpdate();
			System.out.println("sql1 은 잘들어감");
			pstmt.executeQuery(sql2);
			pstmt.setInt(1, money);
			pstmt.setInt(2, KVO.getAccount());
			pstmt.executeUpdate();
			System.out.println("sql2 은 잘들어감");
			String sql = "select balance from "+frombank+" where account = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, SVO.getAccount());
			ResultSet rs = pstmt.executeQuery();
			System.out.println("sql3 은 잘들어감");
			rs.next();
			if(rs.getInt("balance")<0) {
				conn.rollback();
				return res;
			}else {
				conn.commit();
				res=true;
			}
			conn.setAutoCommit(true);

		} catch (Exception e) {
			System.out.println(e);
		}finally {
			JDBC.disconnect(pstmt, conn);
		}
		return res;
	}
}
