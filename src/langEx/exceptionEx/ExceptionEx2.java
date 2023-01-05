package langEx.exceptionEx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionEx2 {
	static void c() {
		FileInputStream fis = null;
		File f = null;
		
		f = new File("text2.txt");
		
		try {
		fis =  new FileInputStream(f);
		int data;
		
		while((data = fis.read()) != -1) {
			System.out.println((char)data);
		}
			
		}catch(Exception io) {
			System.out.println("파일을 찾을수 없음.." + io.getMessage());
			io.printStackTrace();
		
		}finally {
			//이 블락은 예외 발생 여부와 상관없이 무조건 수행되는 블락입니다.
			if(fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO 자동 생성된 catch 블록
					e.printStackTrace();
				}
		}
	}
	static void b() {
		c();
	}
	static void a() {
		b();
	}
	
		//생성된 파일에 접근, 파일의 내용을 읽어오는 API 사용함.
	public static void main(String[] args)  {
		
		a();

}
}
