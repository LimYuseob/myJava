package Rock;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;


public class Intro {
	
	private MemberDTO memDT;
	private MemberDAO memDA;
	
	
	public Intro(){
		memDT = new MemberDTO();
		memDA = new MemberDAO();
		first();
	}

	public void first()  {
		
		Properties prop = new Properties();
	
		int i = 0;

		String[] firButton = { "로그인하기", "사용자 계정 생성", "기타 메뉴" };

		int selected = JOptionPane.showOptionDialog(null, "원하는 항목을 누르시오", "게임 실행하기", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, firButton, firButton[0]);
		if (selected == 0) {
			// 아이디 입력하는 부분. 아이디 비번 파일에서 땡겨온 후, 일치한다면 아랫 줄 비밀번호 실행
			memDT.setEmail(JOptionPane.showInputDialog("아이디를 입력하세요"));
//			BufferedReader reader = new BufferedReader(new FileReader("C:\\members\\" + userId + ".properties" ));
			try {
				prop.load(new BufferedInputStream(new FileInputStream("C:\\members\\" + memDT.getID()  + ".properties")));
			} catch (IOException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}

			
//			  try{
//		            BufferedReader reader = new BufferedReader(new FileReader("C:\\.properties"));
//		            } catch (Exception e) {
//						e.getLocalizedMessage();// TODO: handle exception
//					}
			
			if (memDT.getID().equals(prop.getProperty("ID"))/* 땡겨와야할 영역. 아이디가 맞다면~ 아래 구문 시작 logininfo.get(id) */) {
				System.out.println(memDT.getID());
				memDT.setPW(JOptionPane.showInputDialog("비밀번호를 입력하세요"));
				// 비밀번호 확인 파트
				if (memDT.getPW().equals(/* 땡겨와야할 영역. 비밀번호가 맞다면~ */"")) {
					JOptionPane.showMessageDialog(null, memDT.getID() + "님 로그인을 환영합니다.");

					// logInTime 넣어주기.
					// 비밀번호 틀릴 경우
				} else if (!memDT.getPW().equals(/* 땡겨올 부분 */"")) {
					// 틀릴 시 3회 반복분

					while (i < 3) {
						i++;
						if (memDT.getPW().equals("")) {
							JOptionPane.showMessageDialog(null, "로그인 성공");

							break;
						} else if (!memDT.getPW().equals("")) {
							System.out.println("로그인 실패!");
							if (i == 3)
								JOptionPane.showMessageDialog(null, "비밀번호 입력 횟수가 초과되었습니다.\n 프로그램을 종료합니다.");
							continue;
						}
					}
				}
			} else {
				/* System.out.println("아이디가 존재하지 않습니다."); */
				JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다. \n 다시 시작하시기 바랍니다.");
			}
		}else if(selected  == 1) {
			memDA.Crmem();
		}
	}

//	private static void propRead() {
//		// TODO Auto-generated method stub
//		String resource = "C:\\Beautea37.properties";
//		Properties properties = new Properties();
//
//		try {
//			Buffer 
//			System.out.println(properties.getProperty("ID"));
//			System.out.println(properties.getProperty("Password"));
//		} catch (IOException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
//			class sdfkljaslkjewr {}

//	class EntryMain {
//	
//
//		try
//		{
//			Reader reader = Resources.getResourceAsReader(resource);
//			properties.load(reader);
//			System.out.println(properties.getProperty("driver"));
//			System.out.println(properties.getProperty("username"));
//			System.out.println(properties.getProperty("password"));
//			System.out.println(properties.getProperty("url"));
//		}catch(
//		IOException e)
//		{
//			e.printStackTrace();
//		}
//	}
	public static void main(String[] args){
		new Intro();
	}

//private static void propRead() {
//	propRead();
//	}
}

// 회원 아이디, 비밀번호 찾기가 필요할 것 같은데....?
