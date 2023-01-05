package Kwa2;

import javax.swing.JOptionPane;

public class Play {
	String Game;
	JOptionPane input;
	MemberDTO member;
	
	private void start() {
		//이 메서드가 호출되면
		//play() 가 호출되어 게임이 시작됩니다.
		play();
		new GawiBawiBo();
	}
	private void play() {
		//여기서 사용자의 이메일을 입력받는 객체를 생성하고, 입력받는 메서드도 호출 하겠습니다.
		member = new MemberDTO();
	}
	public static void main(String[] args) {
		new Play().start();
		
	}

}
