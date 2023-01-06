package oopEx1.threadEx;
/*
 * 쓰래드를 생성하는 방법
 * 1. 내 자신이 쓰래드를 상속받는 방법
 * 2. 그냥 쓰래드 객체를 생성해서 run()을 구현하는 방법(익명클래스 정의법)
 * 3. Runnable type 으로 생성해서 Thread(Runnable) 에 탑재하는 방법
 * 
 * 위 3개중 뭐가 됬든, 반드시 run() 을 오버라이드 해야 하고, Runnable 상태로 전이 되기
 * 위해서 반드시 start() 를 호출해야한다.
 */

class ThreadEx1_1 extends Thread{//쓰래드를 상속했기에 이 클래스자체가 쓰레드다.
	//수행 로직을 run() 을 통해 구현한다.
	@Override
	public void run() {
		System.out.println("--------Thread 1_1---------");
		for(int i = 0; i<5; i++) {
			System.out.println(i);
		}
	}
}

class ThreadEx1_2 extends Thread{//쓰래드를 상속했기에 이 클래스자체가 쓰레드다.
	//수행 로직을 run() 을 통해 구현한다.
	@Override
	public void run() {
		System.out.println("--------Thread 1_2---------");
		for(int i = 0; i<5; i++) {
			System.out.println("쓰래드 이름 : " + getName());
		}
	}
}
class MyThread implements Runnable{
	@Override
	public void run() {
		System.out.println("--------MyThread---------");
		for(int i=0; i<5; i++) {
			
			System.out.println("이건 Runnable 타입의 쓰래드 내용 입니다.");
		}
	}
}
public class ThreadEx1 {

	public static void main(String[] args) {
		System.out.println("--------mainThread 시작---------");
		System.out.println(Thread.currentThread().getName()+" 이 수행시작.");
		//쓰레드 객체생성
		ThreadEx1_1 t1 = new ThreadEx1_1();
		ThreadEx1_2 t2 = new ThreadEx1_2();
		Thread t3 = new Thread(new Thread(new MyThread()));
		
		//익명클래스를 이용한 쓰래드 작성
		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("--------익명클래스Thread 시작---------");
				for(int i = 0; i<5; i++) {
					System.out.println("여긴 main() 에서 수행된 쓰래드의 내용"
							+ Thread.currentThread().getName() + " 입니다.");
				}
			}
		});
		t4.setName("T4 쓰래드");
		
		Thread t5 = new Thread() {
			public void run() {
				System.out.println("--------T5 Thread 시작---------");
				System.out.println("이건 T5 쓰래드 입니다."+getName());
			}
		};
		
		
		//쓰레드 시작
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		//이 아래는 main 쓰래드의 수행 작업내용.
		System.out.println("--------ㅡmainThread---------");
		for(int i = 0; i<5; i++) {
			System.out.println("main " + i);
		}
	}

}
