package basic;
import javax.swing.JOptionPane;

public class QuizUseMethod {

	static int max() {
		int a = Integer.parseInt(JOptionPane.showInputDialog("첫번째수를 입력하세요"));
		int b = Integer.parseInt(JOptionPane.showInputDialog("두번째수를 입력하세요"));
		if( a > b)
			return a;
				return b;
	}
	static void sum2Values() {
		int a = Integer.parseInt(JOptionPane.showInputDialog("첫번째수를 입력하세요"));
		int b = Integer.parseInt(JOptionPane.showInputDialog("두번째수를 입력하세요"));
	      long sum = 0;
	      if(a<=b) {
	      for(int i = a; i<=b; i++) {
	         sum += i;
	      }
	      }else{
	    	for(int i = b; i<=a; i++) {
	 	       sum += i;
	      }
	     }
	      System.out.println(sum);
	   }
	static String printNumSequence(int fir, int sec, int thd) {
		String str = null;
		
		int temp;
		if(sec >= fir && sec >= thd) {
			temp = fir;
			fir = sec;
			sec = temp;
		}
		str = fir + " >= " + sec + " >= " + thd;
		
		return ""+ str;
	}
	
	public static void main(String[] args) {
		/*
		 * 아래 정의된 내용대로 수행 되도록 메서드를 정의 하여
		 * 코드를 완성하세요.
		 */
		
		 int x =0;
		 
		 while(true) {
			 String choice =
					 JOptionPane.showInputDialog(null, "1.최대값 2.사이합 3.수나열 4.종료");
			 x =Integer.parseInt(choice);
			 
			 if(x == 1) {
				 //결과를 return 해주는 메서드를 호출 하여 값 출력 할 수 있도록
				 //아래의 메서드 정의 하세요.
				 int res = max();
				 System.out.println("두 수중 최대수는  : " + res);
			 }else if(x == 2){
				 sum2Values();//정의하세요//
				 	
			 }else if(x == 3){
				 System.out.println("첫번째 수 = ");
				 int firsu = Integer.parseInt(JOptionPane.showInputDialog("첫수 입력"));
				 int secsu = Integer.parseInt(JOptionPane.showInputDialog("두수 입력"));
				 int thdsu = Integer.parseInt(JOptionPane.showInputDialog("세수 입력"));
				 
				 String str = printNumSequence(firsu,secsu,thdsu);
				 
				 JOptionPane.showConfirmDialog(null, "큰 순으로 나열은 \n" + str);
				 
			 }else if(x == 4) {
				 break;
			 }else {
				 JOptionPane.showConfirmDialog(null, "잘못입력 했습니다.");
			 }
			 System.out.println();
		 }
   }




