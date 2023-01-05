package Rock;

import javax.swing.JOptionPane;

public class ID {
	Main m =new Main();
	private String name="";
	private static int win =0;
	private static int loss = 0;
	private static int tie = 0;
	private static int count = 0;
	
	
	
	public void getWin() {
		this.win++;
	}
	public void getLoss() {
		this.loss++;
	}
	public void getTie() {
		this.tie++;
	}
	public void getCount() {
		this.count++;
	}
	
	
	public ID(){
		
		
	}
	public void rate() {
	
	
		int rate1 =(((win)*100/count));
		int rate2 =(((loss)*100/count));
		int rate3 =(((tie)*100/count));	
	
		JOptionPane.showMessageDialog(null,m.getId()+"님 \n"+"승 :"+win+" 승 률 :"+rate1+"%\n 패 :"+loss+" 패 률 :"
				+rate2+"% \n무 :"+tie+"무승부률 :"+rate3+"%");
	
}
	
}
