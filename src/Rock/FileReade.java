package Rock;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReade{
	private MemberDTO memDT;
	private Properties properties;
	
	
	public FileReade(MemberDTO memDT) {
		this.memDT = memDT;
		getLine();
	}

	public void getLine() {//파일을 각 줄마다 읽어 문자열 line변수에 담아 문자열a 변수에 저장하는 메서드 
	    // Read properties file.
	    try {
	      properties.load(new FileInputStream("C:\\members\\"+ memDT.getID() + ".properties"));
	    } catch (IOException e) {
	    }

	    String avalue = properties.getProperty("a");
	    System.out.println(avalue);
	    properties.setProperty("a", "properties test");

	    // Write properties file.
	    try {
	      properties.store(new FileOutputStream("C:\\members\\"+ memDT.getID() + ".properties"), null);
	    } catch(IOException e) {
	    	System.out.println("예외발생 : " + e.getMessage());
	    }
	  }
		
		
		
	
    public static void main(String[] args){
    }
}