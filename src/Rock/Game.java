package Rock;

import javax.swing.JOptionPane;

public class Game {
		ID ra=new ID();
	
	 String user ="";
	 boolean isCorrect;
	public Game() {
		play();
	}
	public int play() {
	while(!isCorrect) {
		
	
		//선언
		String msg="";
		
		int result=1000;
		String result1="";
		int com =(int)(Math.random()*3);

		 user = JOptionPane.showInputDialog("(가위 바위 보)중 하나를 입력하세요");
		//System.out.println(com);
		
		
		
		switch (user) {
		case "가위":
			result = 0;
			break;
		case "바위":
			result = 1;
			break;
		case "보":
			result = 2;
			break;
			
		default:
			msg = "";
			break;
		}
		
		switch (com) {
		case 0:
			result1 = "가위";
			break;
		case 1:
			result1 = "바위";
			break;
		case 2:
			result1 = "보";
			break;
		}
		
		
		int re=com-result;
		if(re==0) {JOptionPane.showInternalMessageDialog(null, "컴퓨터  :"+result1+"   user :"+user+"  비겼습니다");
		ra.getCount(); ra.getTie(); 
		}
		
		else if(re==1||re==-2) {JOptionPane.showInternalMessageDialog(null, "컴퓨터 :"+result1+"  user :"+user+"    졌습니다");
		ra.getCount(); ra.getLoss();}
		else if(re==-1||re==2) {JOptionPane.showInternalMessageDialog(null, "컴퓨터 :"+result1+"   user :"+user+"   이겼습니다");
		ra.getCount(); ra.getWin();}
		else {
			JOptionPane.showInternalMessageDialog(null, "잘못 입력하셨습니다 정확히 다시 입력해 주세요");
				 }
		
		
		showMenu();
		}
	
	return 0;
	
	
	}
	public void showMenu(){
		String[] menu = {"1.계속하기","2.전적보기","3.종료"};
		 int sele= JOptionPane.showOptionDialog(null, "메뉴를 골라주세요", "메뉴", 0, 0, null, menu, menu[2]);
				if(sele==0) {
					play();
					
				}else if(sele==1) {
					ra.rate();
					isCorrect=true;
					
			    }else {  JOptionPane.showMessageDialog(null, "즐거웠습니다");  }
				
			
	}
		
		

		

}

	