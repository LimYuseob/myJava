package returnBasic;


//부모 클래스가 될 기본 클래스 정의 해봅니다.
class Parent{

	private String myName;//이름멤버변수
	private int age;//나이멤버변수

	public Parent(String myName, int age) {
		super();//Objet 의 기본 생성자 호출..
		this.age = age;
		this.myName = myName;
		
	}
	
	public void myjob() {
		System.out.println("Parent 클래스의 직업은 어부");
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Son extends Parent{
	public String myjob;
	
	public Son() {
		super(null,0);//Parent의 기본 생성자 호출..
	}
	public void myjob() {
		super.myjob();
		System.out.println("Son의 직업은 프로그래머");
	}
}


class UserEmail{
	
	private String email;
	
	public UserEmail(String email) {
		this.email = email;
	}
	//email 값을 리턴하는 getter 만들기.
	public String getEmail() {
		return email;
	}
}
public class ConstructorExam {

	UserEmail email;
	
	public static void main(String[] args) {
		
		Son son = new Son();//Son 기본 인스턴스 생성
		Object object = son;//Ref 를 복사해서 넘겨준다.
		Parent parent =(Parent)object;//Object Ref 하는 참조값을 Parent 에게 넘겨준다.
		Parent p2 = new Son();
		
//		parent =  null;
//		p2 = null;
//		
//		System.out.println(object);
		
		
//		System.out.println(object.equals(son));
//		System.out.println(object.equals(p2));
		
		((Parent)object).myjob();
		
		
		
		
		
//		if(parent == p2) {
//			//rtype 에서 == 연산자를 쓰면, 같은 객체니? 라고 묻는것입니다.
//			//즉 Reference 값이 같니??
//			System.out.println("두 객체는 같은 객체입니다.");
//			System.out.println(object);
//			System.out.println(parent);
//	}
			
		System.out.println("이메일을 입력해주세요.");
		String email = "dladbtjq@naver.com";
		ConstructorExam play = new ConstructorExam();
		play.email = new UserEmail(email);
		System.out.println(play.email.getEmail());
		
	}
 }

