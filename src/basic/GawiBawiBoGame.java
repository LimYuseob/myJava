package basic;
import javax.swing.JOptionPane;

/*
 * 가위바위보게임을 만드세요.
 * 조건은 아래와 같습니다.
 * 
 * 1.프로그램 시작하면 게임 하실래요(y,n)? 라고 묻고 y 입력시 게임 시작됩니다.
 * 2.시작되면 사용자에게 값을 입력토록 하세요(가위,바위,보중 하나)
 * 2.1만약 위 값이 아닌 다른 값이 들어오면 "틀린 값 입니다."출력후 프로그램 종료.
 * 3.만약 올바른 값이 입력되면, Math.random() 을 이용해서 1 ~ 3 까지 생성하세요
 * 4. 생성된 값을 이용해서 사용자와 컴퓨터간의 게임을 진행후 아래처럼 출력 시키세요.
 * 5. 축 당신 승(컴 : 보, 당신 : 가위) or ㅠㅠ컴 승(컴 : 주먹, 당신 : 가위)
 * 6.위 메세지가 출력된후 프로그램을 종료 하세요.
 */
public class GawiBawiBoGame {

	public static void main(String[] args) {
	
	int strt = JOptionPane.showConfirmDialog(null, "Are you play the game?",
			"쯱쏘가 묻습니다.",JOptionPane.YES_NO_OPTION);
	outer:while(true) {
	if(strt == JOptionPane.NO_OPTION) {
		System.out.println("운이 좋았군...");
		return;
	
	}else {
		System.out.println("게임을 시작하지");
	}
	int ran = (int)(Math.random()*3);
	String user = JOptionPane.showInputDialog("가위,바위,보 중 하나를 입력하여주세요");
	if(!user.equals("가위")&&!user.equals("바위")&&!user.equals("보")){
		JOptionPane.showMessageDialog(null,"가위,바위,보를 정확히 입력해 주세요");
		return;
	}
	if(user.equals("가위")) {
		if(ran == 0) {
			System.out.println("축하한다. 네가 이겼다");
		}else if(ran == 1) {
			System.out.println("아쉽네. 비겼군");
		}else {
			System.out.println("생대가 안되는군. 너는 내게 졌다");
			}
		}
	if(user.equals("바위")) {
		if(ran == 0) {
			System.out.println("축하한다. 네가 이겼다");
		}else if(ran == 1) {
			System.out.println("아쉽네. 비겼군");
		}else {
			System.out.println("생대가 안되는군. 너는 내게 졌다");
			}
		}
	if(user.equals("보")) {
		if(ran == 0) {
			System.out.println("축하한다. 네가 이겼다");
		}else if(ran == 1) {
			System.out.println("아쉽네. 비겼군");
		}else {
			System.out.println("생대가 안되는군. 너는 내게 졌다");
			}
		}			
		strt = JOptionPane.showConfirmDialog(null, "Try again??",
			"쯱쏘가가 묻습니다.",JOptionPane.YES_NO_OPTION);
		if(strt == JOptionPane.NO_OPTION) {
		System.out.println("아쉽군...");
		return;
	}else {
		
		continue outer;					
						
					
				
			
		}
	}
 }
}

