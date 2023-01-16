package D20;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import javax.swing.JOptionPane;
import java.io.IOException;


public class Intro extends Stat {
	MemberDTO memDT;
   String userId;
   String id = "";
   int i = 0;
   String ID="";
   String pw;
   String pw1;
   
   private Properties prop;


   public static Intro inst = new Intro();

      public static Intro getInst() {                                             //34~39 기제가 추가한 영역
            return  inst;
            
         }
   public Intro() {
	   memDT = new MemberDTO();
  //    first();
   }

   public void first() {
      
   

      String[] firButton = { "로그인하기", "사용자 계정 생성", "기타 메뉴" };

      int selected = JOptionPane.showOptionDialog(null, "원하는 항목을 누르시오", "게임 실행하기", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, firButton, firButton[0]);
      MemberDAO dao = MemberDAO.getInstance();
      if (selected == 0) {
         butt1();
      }else if(selected  == 1) {
         dao.Crmem();
      }else if(selected == 2) {
         
      }
      return;
      
   }
      public void butt1() {
         Properties prop = new Properties();
            // 아이디 입력하는 부분. 아이디 비번 파일에서 땡겨온 후, 일치한다면 아랫 줄 비밀번호 실행
            id = JOptionPane.showInputDialog("아이디를 입력하세요");
            userId = id.substring(0,id.indexOf('@'));
            try {
               prop.load(new BufferedReader(new FileReader("C:\\members\\" + userId + ".properties")));
            } catch (IOException e) {
               // TODO Auto-generated catch block
               System.out.println("아이디를 불러오지 못했습니다." + e.getMessage());
            }

            if (userId.equals(prop.getProperty("ID"))) {
               System.out.println(id);
            }else if(!userId.equals(prop.getProperty("ID"))){
               JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다. \n 다시 시작하시기 바랍니다.");
               butt1();
            }passch(prop);
      }
         public void passch(Properties prop) {
            this.prop = prop;
            pw = JOptionPane.showInputDialog("비밀번호를 입력하세요");
            pw1 = prop.getProperty("Password");
            if(pw.equals(pw1)) {
               JOptionPane.showMessageDialog(null, id + "님 로그인을 환영합니다.");
               setintro();
               secMenu();
               // logInTime 넣어주기.
               // 비밀번호 틀릴 경우
            } else if (!pw.equals(pw1)) {
               // 틀릴 시 3회 반복분
                  JOptionPane.showInputDialog("비밀번호를 " + (i + 1) + "회 잘못 입력하셨습니다.\n");
                  i++;
            }else if (pw.equals(pw1)) {
                     JOptionPane.showMessageDialog(null, "로그인 성공");
                     setintro();
                     
                  } else if (!pw.equals(pw1)) {
                     JOptionPane.showInputDialog("비밀번호를 " + (i + 1) + "회 잘못 입력하셨습니다.\n");
                     i++;
                  }else if (pw.equals(pw1)) {
                     JOptionPane.showMessageDialog(null, "로그인 성공");
                     setintro();
                     
                     secMenu();

                  }else if (!pw.equals(pw1)) {
                        JOptionPane.showMessageDialog(null, "비밀번호 입력 횟수가 초과되었습니다.\n 프로그램을 종료합니다.");
                        System.exit(0);
                     }
                     }// 비밀번호 확인 파트
         
 	public void secMenu() {
 		dao.memDT.setEmail(ID);
 		String[] menu = {"게임하기", "전적보기", "마지막 로그인 날짜 확인",  "비밀번호 변경","종료"};
 		MemberDAO dao = MemberDAO.getInstance();
 		Stat stat = new Stat();
 		int menuChoice = JOptionPane.showOptionDialog(null, "menu를 선택하세요", "가위바위보", 0, 0, null, menu, menu[4]);
 		if(menuChoice == 0) {
 			new Game();
 		}else if(menuChoice == 1) {
			rate();
			try {
				PlayScroWrite();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    }else if(menuChoice == 2) {
			//진우거
	    }else if(menuChoice == 3) {
//			new ChangePass().changePass();
	    	MemberDAO.getInstance().changePass();
	    }else if(menuChoice == 4) {
			try {
				JOptionPane.showMessageDialog(null, "잘 가세요 즐거웠습니다~");
				PlayScroWrite();
				System.exit(0);
				
			}catch (Exception e) {
				// TODO: handle exception
			}
	    }
 	}
  
         
   public static void main(String[] args) throws IOException {
      new Intro().first();
      
   }


}

// 회원 아이디, 비밀번호 찾기가 필요할 것 같은데....?

