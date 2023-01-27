package Project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Menu {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String uid = "yuseob";
	String pwd = "1234";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	
	public Menu() {
		menucoffie();
	}
	public void menucoffie() {
		try {
			String sql = "SELECT * FROM PROD WHERE PNAME = ?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, pwd);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next()) {
				MemberDTO memDT = new MemberDTO();
				memDT.setMPname(rs.getString("pname"));
				memDT.setMNpric(rs.getInt("price"));
				System.out.println(memDT.getMPname());
			}
			
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e.getMessage());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println("닫기 예외 발생 : " + e2.getMessage());
			}
		}
	}
	public void menutea() {
		try {
			String sql = "select pname,price from prod where mcode = 02";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, pwd);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next()) {
				MemberDTO memDT = new MemberDTO();
				memDT.setMPname(rs.getString("pname"));
				memDT.setMNpric(rs.getInt("price"));
			}
			
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e.getMessage());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println("닫기 예외 발생 : " + e2.getMessage());
			}
		}
	}
	public void menuade() {
		try {
			String sql = "select pname,price from prod where mcode = 03";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, pwd);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next()) {
				MemberDTO memDT = new MemberDTO();
				memDT.setMPname(rs.getString("pname"));
				memDT.setMNpric(rs.getInt("price"));
			}
			
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e.getMessage());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println("닫기 예외 발생 : " + e2.getMessage());
			}
		}
	}
	public static void main(String[] args) {
	}

}
