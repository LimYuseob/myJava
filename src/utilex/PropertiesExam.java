package utilex;

import java.io.IOException;
import java.util.Properties;

public class PropertiesExam {

	public static void main(String[] args) throws IOException {					//2. 1먼저 보고 와야됨. throw IOException 원래 없는데 15번 행에서 빨간줄 나오는거 고치면 자동 생성됨
		// TODO Auto-generated method stub
		
		/*
		 * Properties 기본객체 생성.
		 * Properties 파일을 Stream을 통해 access하는거 시작.
		 */
		Properties prop = new Properties();
//1. 	prop.load(Properties.class.getResourceAsStream("db.properties"));
//		방금 만든 db.properties 불러오는 주문. 여기서 properties에서 빨간색 나오는거 throw IOException
//		근데	Instream파라미터 값이 null이라고 얘기한다. 그럼 로드 연결 다시 해줘야함.
//		그게 ClassLoader. 얘를 통해 properties파일에 대한 스트림 생성
		prop.load(ClassLoader.getSystemResourceAsStream("db.properties"));
		
//		url:oracle:thin:@localhost:1521:orcl
//		driver:oracle.jdbc.driver.OracleDriver
//		username:asdf0001
//		password:0000
//		admin:administrator
		
		String url = prop.getProperty("url");
		String driver = prop.getProperty("driver");
		String username = prop.getProperty("username");
		String password = prop.getProperty("passworld");
		String admin = prop.getProperty("admin");
		
		System.out.println(username);
		
	}

}
