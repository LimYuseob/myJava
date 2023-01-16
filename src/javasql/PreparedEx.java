package javasql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * PreparedStatement 객체 : 자바 SQL 을 사용하는 대표적 객체..
 * 이 객체는 Statement 와는 틀리게 위치홀더(?<--얘) 를 사용하는 게 특징입니다.
 * Statement 는 SQL 작업시 단점이 한번에 SQL 구문을 다 작성해야 하고,
 * 무엇보다 '' 처리가 매우 귀찮습니다.
 * 이 대안으로 Prepared... 가 나온겁니다.
 * 
 * 이 객체는 기본 쿼리는 먼저 수행하고, 나중에 위치홀더(?) 를 이용 값을 세팅하고
 * SQL 을 실행하도록 합니다. 매우 편함.
 */
public class PreparedEx {
	
	static Connection conn;
	
	public static void Update(Connection con) {
		conn = con;
		
		//데이터를 수정하는 Update 구문 입니다.
		/*
		 * Update TableName
		 * Set 업데이트 컬렴명 = value,
		 * 업데이트 컬렴명 = value,
		 * 업데이트 컬렴명 = value,
		 * 업데이트 컬렴명 = value,
		 * 업데이트 컬렴명 = value
		 * 아래는 조건절..나중에 봅니다.
		 * 
		 * [where 조건식]
		 */
		String sql = "Update users SET userpassword = ?"
				+ "where userid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "1234");
			pstmt.setString(2, "yuseob");
			System.out.println(pstmt.executeUpdate() + " 개의 행이 변경되었습니다.");
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		
	}
	public static int userDelete(Connection con, String id) {
		int result = 0;
		String sql = "Delete users where userid = ?";
		conn = con;
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	//조회 메서드 정의...Select [*(모든컬럼) or 컬럼명1,컬럼명2,....n]
	//From TableNmae [where 조건절..]
	public static void select(Connection con) {
		conn = con;
		String sql = "Select * from users";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//Select 시에는 executeQuery() 를 이용합니다.
			ResultSet rs = pstmt.executeQuery();
			//while 을 이용, ResultSet 의 마지막 row까지 이동하여 정보 get
			while(rs.next()) {
				System.out.println("-----------------------");
				//getter 를 이용해서 정보를 얻어낸다.
				String id = rs.getString("userid");
				String pass = rs.getString("userpassword");
				String email = rs.getString("useremail");
				String name = rs.getString("username");
				int age = rs.getInt("usergg");
				
				System.out.println(id + " : " + " : " + pass + " : " + email +
						" : " + name + " : " + age);
				System.out.println("-----------------------");
				
				System.out.println();
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void main(String[] args) {
		
		Connection conn = null;
		conn = DJDao.getConnection();
		select(conn);
		/*
		String id = "Ssam";
		int result = userDelete(conn, id);
		if(result == 1) {
			System.out.println("축하합니다ㅏ." + id + " 님의 회원정보가 탈퇴가 완료되었습니다.");
		}
		System.out.println(id + "님은 우리 회원이 아니네요.");
		*/
//		Update(conn);
		
//		String sql = "Insert into Users(USERID,USERNAME,USERPASSWORD,"
//				+ "USERAGE,USEREMAIL) values"
//				+ "(?,?,?,?,?)";
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			
//			//위치홀더의 값을 세팅합니다. 단, 컬럼타입과 같은 setter 를 호출 해야 합니다.
//			//예를 들면 값이 타입(값 타입)이 문자열인 경우 setString(,),
//			//정수인 경우 setInt(), 기타 등등..
//			
//			pstmt.setString(1, "byul");
//			pstmt.setString(2, "별하");
//			pstmt.setString(3, "1234");
//			pstmt.setInt(4, 4);
//			pstmt.setString(5, "byulha@naver.com");
//			
//			//Select 를 제외한 DML 은 executeUpdate() 를 이용해서 수행합니다.
//			//리턴값은 DB에 적용된 Rows 를 리턴합니다.
//			if(pstmt.executeUpdate() == 1) {
//				System.out.println("새로운 데이터가 입력 완료됨.");
//				pstmt.close();
//				conn.close();
//			}
//		} catch (SQLException e) {
//			// TODO 자동 생성된 catch 블록
//			System.out.println("예외 발생 :" + e.getMessage());
//		}
	}

}
