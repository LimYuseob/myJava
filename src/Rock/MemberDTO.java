package Rock;

import javax.swing.JOptionPane;

public class MemberDTO{
	
	private String mem_Email;

	public MemberDTO() {
		inputEmail();
//		inputId();
	}
	
	//메서드 리턴을 void 로 했는데, 예시 끝난후 로직상 변경해야 할겁니다.
	private void inputEmail() {
		this.mem_Email = JOptionPane.showInputDialog("Emali을 입력 바랍니다.");
		if(getMem_Email().isEmpty()) {
			JOptionPane.showMessageDialog(null, "공백을 빼고 입력하여 주세요");
			inputEmail();
		}
			String sev = getMem_Email().substring(getMem_Email().indexOf('@')+1);
			String id = getMem_Email().substring(0,getMem_Email().indexOf('@'));
			System.out.println(id);
			System.out.println(sev);
			char[] idrr = id.toCharArray();
			char idc = id.charAt(0);
		if(id.length() < 8 && id.length() > 12 ) {
				JOptionPane.showMessageDialog(null, "ID를 8~12자리로 입력하여 주세요.");
				inputEmail();
			}else if(!Character.isUpperCase(idc)) {
				JOptionPane.showMessageDialog(null, "ID를 첫자리를 대문자로 입력하여 주세요.");
				inputEmail();
			}else if(Character.isDigit(idrr.length)) {
				JOptionPane.showMessageDialog(null, "ID에 반드시 숫자를 넣어 입력하여 주세요.");
				inputEmail();
			}
	}
//	private void inputId() {
//		this.Id = JOptionPane.showInputDialog("ID를 입력 해주세요.");
//		JOptionPane.showMessageDialog(null,"입력하신 ID는 : " + Id + " 입니다.");
//		
//	}
	public String getMem_Email() {
		return mem_Email;
	}
//	public String getId() {
//		return Id;
//	}
		public static void main(String[] args) {
			new MemberDTO();
		}
		
}
