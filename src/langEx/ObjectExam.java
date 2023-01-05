package langEx;


class Value{
	
	int vlaue;
	
	public Value(int value) {
		this.vlaue = value;
 }
}
class Person{
	
	long id;//주민번호 또는 사회보장번호 필드.
	
	public Person(long id) {
		this.id = id;
	}
	//상속받은 equals() 오버라이드하기..
	@Override
	public boolean equals(Object obj) {
		//두 객체의 특정 값이 같은지 비교해보자..
		if(obj != null && obj instanceof Person) {
			return id == ((Person)obj).id;
		}else{
			return false;
		}
		
	}
}
	
	

public class ObjectExam {

	//toString() 오버라이드
	public String toString() {
		return "이건 오버라이드된 내용이 나옵니다";
	}
	
	public static void main(String[] args) {
		//equls() : 파라미터의 객체와 같은 객체인지를 판별하여 true/false 를 리턴하는 메서드
		
		Person id1 = new Person(12345678);
		Person id2 = new Person(12345677);
		
		
		
		if(id1 == id2) {
			System.out.println("같은 사람 입니다.");
		}else {
			System.out.println("다른 사람 입니다.");
		}
		
		if(id1.equals(id2)) {
			System.out.println("다른 사람이지만 주민번호는 같음");
		}else {
			System.out.println("다른 사람이고 주민번호는 다름");
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		
		if(v1.equals(v2)) {
			System.out.println("v1 과 v2 는 같습니다.");
		}else {
			System.out.println("v1 과 v2 는 틀립니다.");
		}
		
		v1 = v2;
		
		if(v1.equals(v2)) {
			System.out.println("v1 과 v2 는 같습니다.");
		}else {
			System.out.println("v1 과 v2 는 틀립니다.");
		}
		
		
		
		//Object 의 상속된 toSting() 보기
		ObjectExam objex = new ObjectExam();
		
		System.out.println(objex.toString());
		
		System.out.println(objex.getClass().getName());//상속된 getClass() 호출..
		
		System.out.println(objex.getClass().getName() +  "@" + Integer.toHexString(objex.hashCode()));
		
	}

}
