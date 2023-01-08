package Rock;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;



public class MemberDAO {

	
	private MemberDTO memDT;



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
			String id = ((memDT).getID()).substring(0,((memDT).getID()).indexOf('@'));
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
		
		//폴더명 projectT
		String fName = "projectT";
		//폴더 및 파일 생성
		File folder = new File(fName);
		//파일명 ID.dat
		File file = new File("ID.dat");
		
		
			try {
				if(!folder.exists()) {
				//폴더 생성
				folder.mkdir();
				System.out.println("폴더가 생성되었습니다.");
				}else {
					File newFile = new File(folder, file.getName());
					System.out.println(newFile.createNewFile() == true ? "파일이 생성됨" : "뭔가 오류가 있음.");
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		
	}
	
	public static void main(String[] args) {
		new MemberDAO().CrmeP();
	}
}



