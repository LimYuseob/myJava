package langEx_nestcls;
/*
 * 외부 클래스의 멤버필드 선언위치에 선언되며, 외부 클래스의 static 멤버처럼 호출 및 객체 생성가능함
 * 주로 외부 클래스의 static 멤버, 특히 static 메서드를 사용할 목적으로 주로 정의함
 * 만약 내부 클래스에서 static 필드(상수 아님) 을 선언해야 할 경우엔 무조건
 * static inner 클래스로 선언되어야 함.(JDK 17 이전 버전까지..)
 */
public class StaticInnerEx {

	int a = 10;
	private int b = 100;
	static int c = 200;
	
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	static int getC() {
		return c;
	}
	
	public static class StaticInner{
		int d = 300;
		static final int e = 400;
		static int f = 500;
		
		public static void printA() {
			//non static 필드 호출 불가..
			//System.out.println("a = " + a);
			System.out.println("c = " + c);
			//non static 메서드 호출 불가.
			//System.out.println("getB()" + getB());
			System.out.println("getC()" + getC());
		}
		
		public void printB() {
			//멤버메소드인 printB()의 class 가 이미 static이기 때문에 먼저 초기화되서
			//outer에 멤버 메소드 및 필드를 호출 할수 없습니다.
			//단 static 멤버 필드 및 메소드는 가능(outer 멤버 메소드와 필드가 먼저 초기화 되기때문에 호출가능)
			//System.out.println("a = " + a);
			//System.out.println("b = " + b);
			System.out.println("c = " + c);
			System.out.println("getC()" + getC());
		}
	}
	
	public static void main(String[] args) {
		
		StaticInnerEx.StaticInner.printA();
		StaticInnerEx.StaticInner inner = new StaticInner();
		inner.printB();
		inner.printA();
		
	}

}
