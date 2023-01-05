package Kwa2;


public class TheEnd{
	
	GawiBawiBo game;
	
	public TheEnd(GawiBawiBo game) {
		this.game = game;
		show();
	}
	
		public void showstat() {
			
		game.getwin();
		game.getdraw();
		game.getloss();
		game.getplayc();
		
		}
		public void show() {
		System.out.println( "플레이어의 전적은 \n 승리 : " + game.getwin() + "\n 패배 : " + game.getloss()
				+ "\n 비김 : " + game.getdraw() + "\n 총 플레이 횟수 : " + game.getplayc() + "\n 승률 : " 
				+ ((double)game.getwin() / (double)game.getplayc()) * 100 + "%");
	}

	

}
