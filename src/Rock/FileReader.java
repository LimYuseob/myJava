package Rock;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
	private MemberDTO memDT;
	private String fName = "C:\\members";
	private File folder = new File(fName);
	private File newFile = null;
	String id;
	FileWriter fw = null;
	BufferedWriter bw = null;
	FileReader fr = null;
	BufferedReader br = null;
	public FileReader(MemberDTO memDT) {
		this.memDT = memDT;
	}
	public void  Filereda() {
		id = ((memDT).getID()).substring(0,((memDT).getID()).indexOf('@'));
		Path path = Paths.get("C:\\members" + ".dat");
		
		try {
			fr = new FileInputStream(newFile)
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁

	}

}
