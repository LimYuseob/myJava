package oopEx1.threadEx;


/*
 * join() 호출한 쓰래드는 호출된 쓰래드에게 CPU 점유권을 양보 하고 끝날때 까지 기다린다.
 * 쓰래드 자체의 메서드로 쓰래드를 제어하는데 사용되는 대표적 메서드이다.
 * 
 * 참고로 쓰래드 자체의 메서드로 제어를 시키는데 사용되는 메서드는 아래와 같다.
 * 
 * sleep(), join(), yield()... 나머지 메서드는resume() 등.. 모두 deprecated
 * 되었기 때문에 사용되지 않는다.
 */

class ThreadB extends Thread{

	//연산 결과값 변수 선언..
	private long sum;

	public long getSum() {
		return sum;
	}
	
	public void setSum(long sum) {
		this.sum = sum;
	}
	@Override
	public void run() {
		for(int i = 0; i<=100; i++) {
			sum += i;
		}
	}
	
}
public class ThreadJoinExam {

	public static void main(String[] args) {
		/*
		 * 이 메인 쓰래드 에서는 위의 join 쓰래드를 start() 시킨후
		 * 1 ~ 100 까지의 연산 합을 리턴받을 예정입니다.
		 * join() 을 호출 하기 전에는 연산이 완료 되기 전에 호출이 되어서
		 * 완전한 값을 get 하지 못합니다.
		 * 이후 join 호출, 완전한 값을 얻게될텐데, 그 차이점을 이해 하시면 됩니다.
		 */
		
		/*
		 * 현재 CPU 에 탑재된 즉 연산중인 Thread 객체를 리턴받는 메서드
		 * Thread.currentThread
		 */
		System.out.println(Thread.currentThread().getName());
		System.out.println("메인의 우선순위 값 : " + Thread.currentThread().getPriority());
		
		ThreadB threadB = new ThreadB();
		//threadB.setPriority(10);
		threadB.start();
		
		try {
			//join() 을 호출한 애는 main 쓰래드이고, 호출당한 에는 threadB 입니다.
			//따라서 threadB가 run()을 모두 완료할때 main 쓰래드는 기다리는 상태가 됩니다.
			//정확히는 sleep()을 호출한 것과 같습니다.
			//이 때 main 쓰래드는 누가 깨워주지 않으면, 계속 실행대기 영역에서
			//머무리게 되기 때문에 문제가 발생합니다. 따라서 내부적으로 InterruptedException
			//을 발생시켜 main 쓰래드를 깨워, Runnable 상태로 다시 갈 수 있도록
			//만드는 겁니다.
			
			threadB.join();
		} catch (InterruptedException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		
		System.out.println("ThreadB 가 연산한 1 ~ 100 까지의 합 : " + threadB.getSum());
	
	}

}
