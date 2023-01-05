package Rock;

import javax.swing.JOptionPane;

class Main {
	Game game;
	static String ID;
	private void start() {
		play();
	}
	
	private void play() {
		this.ID=JOptionPane.showInputDialog("이메일을 입력하세요");
		
		 game =new Game();
	}

	public static void main(String[] args) {
		
		new Main().start();
//		this.id=JOptionPane.showInputDialog("이메일을 입력하세요");
	}

	public String getId() {
		return ID;
	}

	public void setId(String id) {
		this.ID = ID;
	}

}

