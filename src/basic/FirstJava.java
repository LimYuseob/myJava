package basic;
//이건 라인 주석입니다.
/*
 * 이건 블락 주석 입니다. 컴파일시 모두 무시되며, 메모리도 차지하지 않습니다.
 */
/*
 * 코딩시 보라색은 모두 키워드 입니다. 따라서 변수나, 메서드명으로 절대 사용 불가입니다.
 * 아래 클래스옆에 pubilc 은 option 입니다. 넣거나 빼거나 문제는 없지만, 나중에 패키지란걸
 * 배우면 어떤 의미인지 알게 될겁니다.
 * 
 * 클래스 이름 명명법 : 아래의 클래스 class 옆에 있는 이름을 클래스명 이라고 합니다.
 * 이름은 반드시 * 10000000 첫자는 대문자로 시작 해야 하고, 한단어 이상 연결시
 * 새단어의 첫단어는 기본적으로 대문자입니다. "-"(언더바)와 $ 를 사용할 수 있지만
 * 아무도 사용하지 않습니다.
 * 
 * 모든 변수, 클래스, 메서드 이름에는 첫문자는 숫자가 올수 없습니다.
 * 
 * 아래의 클래스 이름이 소스코드의 파일명과 반드시 일치해야 합니다.(대소문자까지)
 */
class FirstJava {//클래스 바디

	public static void main(String[] args) {//메서드 body
		
		
		/*
		 * 자바에서는 지역변수를 사용할 때 반드시 값이 초기화 되어 있어야 합니다.아니면 에러남
		 * 위에서 초기화란 초기화 또는 값이 존재해야 한다는 말입니다.
		 * 변수를 처음 선언할 때는 반드시 변수명 옆에 타입이 선언되어야 합니다.
		 * 이렇게 선언된 변수는 해당 타입만 값을 넣을 수 있습니다.
		 */
		
		//리터럴데이터 : 값 자체가 어떤 타입인지를 내포하고 있는 데이터.
		
		byte a,b;//a 지역(메서드내에서 처음 선언된 변수를 지역변수라 함)
		a = 1;//Assign
		b = 1;
		byte c = 1;
		
		System.out.println(a+b+c);
		
		//short 타입은 자바에서 사장된 데이터 타입입니다.
		short s = 1000;
		a = 10;
		int in = 1;
		//연산자를 만났을 경우엔 두 타입을 비교해서 default 보다 작으면 default
		//타입으로 변환후 연산 한다.. 당연히 결과 타입도 default 타입이다.
		//default 보다 큰 타입의 연산인 경우 무조건 큰 타입으로 리턴된다.
		
		in = a + b;

		long lo = 1L;
		
		long it = lo + 1;
		
		float f = 3.14F;
		
		//같은 또는 더 큰 크기의 데이터 타입을 서로 대입해 봅니다.
		
		f = lo;
		
		//타입 프로모션 : 작은 타입을 큰 타입에 대입하는 형태..무조건 된다.
		//타입 캐스팅(Casting) : 큰 타입을 작은 타입에 대입할 때 사용되는 연산자를
		//이용해서 대입하는 형태를 말한다.
		
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		
		
		/*
		 * Java Data Type :
		 * 
		 * 1.수치형(정수) : byte(1byte) --> short -> int(default) --> long(8byte)
		 * 2.수치형(실수) : float(4byte) --> double(8byte, default)
		 * 3.문자형(cahr)	: char(2byte)
		 * 4.논리형(boolean) : true  or false
		 * 
		 * 위 네개의 자료형을 자바에서는 원시자료형(Primitive Type) 이라고 합니다.
		 * 
		 * 5.객체형(Reference Type)
		 */
	}
	
}
