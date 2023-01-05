package ioex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class FileReaderEx {

	public static void main(String[] args) {

			//PrintWiter 이용해서 파일을 복사해서 ArrayExam.java.back 이라는 파일을
			//생성하세요.
		
			
		
			File file = new File("D:\\full_stack\\eclipse-jee-2020-12-R-win32-x86_64\\workspace\\myJava\\src\\basic\\ArrayExam.java");
			
			FileReader fr = null;
			BufferedReader br = null;
			LineNumberReader lr = null;
			
			String msg = null;
			int readData;
			
//			try {
//				fr = new FileReader(file);
//				
//				//순수하게 read() 만 이용해서 읽기.
//				while((readData = fr.read()) != -1) {
//					System.out.print((char)readData);
//				}
//				fr.close();
//			}catch (Exception e) {
//				// TODO: handle exception
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				lr = new LineNumberReader(br);
				
				
				while((msg = lr.readLine()) != null) {
					System.out.println(lr.getLineNumber()+ " " + msg);
				}
				PrintWriter pw = new PrintWriter(file, "ArrayExam.java.back");
				pw.close();
				
			}catch (Exception e) {
				// TODO: handle exception
			}
	}

}
