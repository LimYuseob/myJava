package Kwa2;

import javax.swing.JOptionPane;

public class GawiBawiBo{
	TheEnd thed;
	int playc;
	int win;
	int draw;
	int loss;
	int rate;
	String viewin;
	String user;
	String[] viewmsg;
	int ques;
	
	public GawiBawiBo() {
		ques = JOptionPane.showConfirmDialog(null, "Are you play the game?",
				"쯱쏘가 묻습니다.",JOptionPane.YES_NO_OPTION);
		if(ques == JOptionPane.NO_OPTION) {
			System.out.println("운이 좋았군...");
			return;
		
		}else {
			System.out.println("게임을 시작하지");
		}startGame();
		}
	private void startGame() {
		user = JOptionPane.showInputDialog("가위,바위,보 중 하나를 입력하여주세요");
		if(!this.user.equals("가위")&&!this.user.equals("바위")&&!this.user.equals("보")){
			JOptionPane.showMessageDialog(null,"가위,바위,보를 정확히 입력해 주세요");
			startGame();
		}else {
		playGame();
		}
	}
	private void playGame() {
		int ran = (int)(Math.random()*3);
		if(this.user.equals("가위")) {
			if(ran == 0) {
				JOptionPane.showMessageDialog(null,"축하합니다. 당신이 이겼습니다.");
				playc++;
				win++;
			}else if(ran == 1) {
				JOptionPane.showMessageDialog(null,"아쉽네. 비겼군");
				playc++;
				draw++;
			}else {
				JOptionPane.showMessageDialog(null,"생대가 안되는군. 당신의 패배입니다.");
				playc++;
				loss++;
			}
		}
		if(this.user.equals("바위")) {
			if(ran == 0) {
				JOptionPane.showMessageDialog(null,"축하합니다. 당신이 이겼습니다.");
				playc++;
				win++;
			}else if(ran == 1) {
				JOptionPane.showMessageDialog(null,"아쉽네. 비겼군");
				playc++;
				draw++;
			}else {
				JOptionPane.showMessageDialog(null,"생대가 안되는군. 당신의 패배입니다.");
				playc++;
				loss++;
				}
			}
		if(this.user.equals("보")) {
			if(ran == 0) {
				JOptionPane.showMessageDialog(null,"축하합니다. 당신이 이겼습니다.");
				playc++;
				win++;
			}else if(ran == 1) {
				JOptionPane.showMessageDialog(null,"아쉽네. 비겼군");
				playc++;
				draw++;
			}else {
				JOptionPane.showMessageDialog(null,"생대가 안되는군. 당신의 패배입니다.");
				playc++;
				loss++;
				}
		}view();
   }
		public void view() {
			viewmsg = new String[] {"(1)뉴게임, (2)전적보기, (3)게임종료"};
			viewin = JOptionPane.showInputDialog(viewmsg[0]);
			if(!this.viewin.equals("1")&&!this.viewin.equals("뉴게임")&&!this.viewin.equals("2")&&
				!this.viewin.equals("전적보기")&&!this.viewin.equals("3")&&!this.viewin.equals("게임종료")){
				JOptionPane.showMessageDialog(null,"메뉴를 올바르게 입력하여 주세요.");
				view();
			}else if(this.viewin.equals("1") || this.viewin.equals("뉴게임")){
				startGame();
			}else if(this.viewin.equals("2") || this.viewin.equals("전적보기")){
				thed = new TheEnd(this);
			}else if(this.viewin.equals("3") || this.viewin.equals("게임종료")){
					System.out.println("게임을 이용해주셔서 감사합니다.");
						System.exit(0);
					}
				}
		public void setPlayc(int playc) {
			this.playc = playc;
		}
		public void setWin(int win) {
			this.win = win;
		}
		public void setDraw(int draw) {
			this.draw = draw;
		}
		public void setLoss(int loss) {
			this.loss = loss;
		}
		
		public int getwin() {
			return win;
		}
		public int getdraw() {
			return draw;
		}
		public int getloss() {
			return loss;
		}
		public int getplayc() {
			return playc;
		}
}

		

