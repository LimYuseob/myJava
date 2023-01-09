package Rock;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;



public class MemberDAO {

	
	private MemberDTO memDT;
	private String id;
	private String pw;
	private static String fName = "members";
	private static File folder = new File(fName);
	FileWriter fw;
	BufferedWriter bw;
	FileReader fr;
	BufferedReader br;
	



	public MemberDAO() {
		memDT = new MemberDTO(this);
	}
	
	
	public void Crmem() {
		memDT.setID(JOptionPane.showInputDialog("Emali을 입력 바랍니다."));
		if(((memDT).getID()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "공백을 빼고 입력하여 주세요");
			Crmem();
		}
			String sev = ((memDT).getID()).substring(((memDT).getID()).indexOf('@')+1);
			id = ((memDT).getID()).substring(0,((memDT).getID()).indexOf('@'));
			JOptionPane.showMessageDialog(null, "입력하신 ID : " +  id + "입니다.\n" + "입력하신 Email : " + id + "@" + sev + "입니다." );
			char idc = id.charAt(0);
			Pattern ptt = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])");
			Matcher mtch = ptt.matcher(id);
			
			
			
		if(id.length() < 8 && id.length() > 12 ) {
				JOptionPane.showMessageDialog(null, "ID를 8~12자리로 입력하여 주세요.");
				Crmem();
			}else if(!Character.isUpperCase(idc)) {
				JOptionPane.showMessageDialog(null, "ID를 첫자리를 대문자로 입력하여 주세요.");
				Crmem();
			}else if(!mtch.find()) {
				JOptionPane.showMessageDialog(null, "ID에 반드시 숫자를 넣어 입력하여 주세요.");
				Crmem();
			}
				CrmeP();
	}//End of Crmem()
	public void CrmeP() {
		memDT.setPW(JOptionPane.showInputDialog("Password를 입력 하여 주십시요"));
		if(((memDT).getPW()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "공백을 빼고 입력하여 주세요");
			CrmeP();
		 }
		fileCr();
	}//End of CrmeP()
	
	public void fileCr() {
		
		
				if(!folder.exists() || !folder.isDirectory()) { 
				//폴더 생성
					folder.mkdir();
				}
				File newFile = new File(folder, id + ".dat");
				if (!newFile.exists()) {	// 파일이 존재하지 않으면 생성
						try {
							if (newFile.createNewFile())
								System.out.println("파일 생성 성공");
							Date nowDate = new Date();
							SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd apm HH:mm:dd");
							String strnowDate = simpleDate.format(nowDate);
							fw = new FileWriter(newFile);
							bw = new BufferedWriter(fw);
							bw.write("ID : " + id + "\n");
							bw.write("Password : " + pw);
							bw.write("생성일자 : " + strnowDate);
							bw.close();
							else
								System.out.println("파일 생성 실패");
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {	// 파일이 존재한다면
						JOptionPane.showMessageDialog(null, "파일이 이미 존재합니다.");
					}
			        
					// 파일 이름 변경: renameTo()
					File nnewFile = new File(folder, id + ".dat");	// 변경할 이름
					if (newFile.exists()) {	// 파일이 존재할 때만 이름 변경
						if(newFile.renameTo(nnewFile))
							System.out.println("파일 이름 변경 성공");
						else
							System.out.println("파일 이름 변경 실패");
					} else {
						System.out.println("변경할 파일이 없습니다.");
					}
					System.out.println();
				if(br == null && fw == null) {
					try {
						Date nowDate = new Date();
						SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd apm HH:mm:dd");
						String strnowDate = simpleDate.format(nowDate);
						fw = new FileWriter(newFile);
						bw = new BufferedWriter(fw);
						bw.write("ID : " + id + "\n");
						bw.write("Password : " + pw);
						bw.write("생성일자 : " + strnowDate);
						bw.close();
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
	
			
	  
	
	public static void main(String[] args) {
		new MemberDAO().Crmem();
	}
}



