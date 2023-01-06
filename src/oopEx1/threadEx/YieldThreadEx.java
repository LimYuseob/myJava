package oopEx1.threadEx;
/*
 * run() 내부의 로직이 의미없는(연산을 하지 않는) 반복 작업을 수행시엔 yeild() 를
 * 호출하여 자신을 대기 상태로 전환 하도록 하고, 타 쓰래드에게 CPU 점유를 양보하도록
 * 제어 하는 메서드 입니다.
 * 
 * join() 과 다른점은 join() 은 외부에서 호출하는 형태로 제어를 하지만,
 * yeild() 는 로직 내부에서 직접 제어하는 형태입니다. 즉 루프등의 조건에 따라서
 * yeild() 를 호출 하도록 하는겁니다.
 */

//아래는 무한 루프를 돌면서 조건에 따라 연산 or 로직없음 을 반복하는 쓰래드를 정의합니다.
class WorkerThread extends Thread{
	public boolean work = true;
	
	public WorkerThread(String name) {
		setName(name);
	}
	@Override
	public void run() {
		while(true) {
			if(work) {//상태값에 따른 루프 분기작업.. 즉 work 가 true 시에만 연산을 한다.
				System.out.println(getName() + "쓰래드가 연산을 수행함..");
			}else {
				//이 조건에서는 아무것도 할게 없으니, 다른 쓰래드에게 CPU 점유를 양보함
				Thread.yield();
			}
		}
	}
}
public class YieldThreadEx {

	public static void main(String[] args) {

		/*
		 * WorkerThread 2개를 생성해서 하나에게는 루프의 flag 값을 false 로 주고
		 * 이후에 경쟁쓰래드가 CPU 를 점유하는 상황을 보세요. 이후 다시 flag 를 true
		 * 로 주면 다시 경쟁 상태로 넘어가게 됩니다. 이렇게 되는 이유는 내부적으로
		 * yield() 를 호출해서 입니다.
		 */
		
		WorkerThread wThread1 = new WorkerThread("워커1");
		WorkerThread wThread2 = new WorkerThread("워커2");
		
		wThread1.start();
		wThread2.start();
		
		try {
			Thread.sleep(5000);
			wThread1.work = false;
		} catch (InterruptedException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		//<-- 쓰래드의 while() 에서 else 절로
		//빠지고, yield() 를 호출하여 실행 대기로 양보하게끔 한다.
		
		try {
			Thread.sleep(10000);
			wThread1.work = true;
		} catch (InterruptedException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}

}
