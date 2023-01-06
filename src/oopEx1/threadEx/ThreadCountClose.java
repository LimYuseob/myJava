package oopEx1.threadEx;
/*
 * 쓰래드 2개를 각각 정의해서 하나는 카운트를 수행 하도록 하고
 * 하나는 값을 입력 받도록 정의 합니다.
 * 메인쓰래드는 두개의 쓰래드를 시작만 시키는 일을 합니다.
 */


import javax.swing.JOptionPane;

class UserInThread extends Thread{
	public void run(){
		System.out.println("10초 안에 값을 입력하세요...");
		//아래의 코드는 사용자의 입력을 기다리는데, 입력을 하지 않으면, 다음 구문으로
		//실행이 넘어 가지 않습니다. 따라서 이를 이용, 다음구문이 실행된다는 말은
		//입력되었다는 의미 이므로, ThreadCountClose 클래스의 flag 을
		//변경하고, Counter 쓰래드는 이 값을 가져다가 사용자의 입력 여부를 판별하는
		//변수로 사용, 로직에 적용합니다.
		String input = JOptionPane.showInputDialog("아무 값이나 입력 ");
		ThreadCountClose.inputCheck = true;//사용자의 입력값 체크 flag
		System.out.println("입력한 값은 : " + input);
	}
}

//아래는 Runnable 을 구현한 Counter 클래스 입니다.
class Counter implements Runnable{
	public void run() {
		for(int i = 9; i>0; i--) {
			if(ThreadCountClose.inputCheck)return;
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
public class ThreadCountClose {
	static boolean inputCheck = false;
	public static void main(String[] args) {

		UserInThread t1 = new UserInThread();
		Thread counter = new Thread(new Counter());
		
		t1.start();
		counter.start();
	}

}
