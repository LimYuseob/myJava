package oopEx1;

public class StarCraft {

	public static void main(String[] args) throws InterruptedException {

		//마린 클래스를 정의 했기 때문에 객체를 만들고 싶은 만큼 생성할 수 있습니다.
		//객체 생성 코드는 ClassName ref변수 = new Class(); 처럼할 수 있습니다.
		
		//테란 유닛은 실제 없지만, 객체 테스트 용으로 만들어봄..
		//Terran terran = new Terran();//Terran 은 추상이기에 자신의 인스턴스를 생성 못한다.
		/*
	       * 객체지향의 다행성(Polymorphism): 다행성이란, "상속" 관계에서 생성된 인스턴스를
	       * Ref 하는 형태가 다양하게 변경될 수 있다는 의미 입니다.
	       * 
	       * 이 말을 다시 풀어보면, 우리가 Ptype 에 배웠던 프로모션과 케스팅과 같습니다.
	       * 상속관계에서 자식의 인스턴스를 생성 또는 이미 생성된 인스턴스를 Ref 할 때 부모타입으로 가능한데,
	       * 이 때 생성된 인스턴스는 해당 클래스의 생성자를 호출하여 생성되었기에 메모리에서 사라지기 전까지는
	       * 인스턴스 타입은 불변입니다(꼭 기억하세요)
	       * 
	       * 하지만, 해당 인스턴스를 Ref 한 타입 변수는 부모 타입이기에 Ref 타입은 부모타입으로 변경되어지게 됩니다.(이 부분을 많이 헷갈려 합니다 조심)
	       * 
	       * 이렇게 다행성으로 생성된 또는 Ref 된 인스턴스의 메서드 or 변수를 호출할때는 무조건 오버라이드된 애들이 호출 되어집니다.
	       * 
	       * 하지만, 인스턴스에만 정의된 메서드를 호출하게 될 시에는 컴파일 에러가 유발됩니다.
	       * 이유는 Ref 하는 변수 타입에는 해당 내용이 없기 때문입니다.
	       * 
	       * 이렇게 다행성을 구현하는 이유는, 상속 관계에서 자식들이 상속받은 메서드를 자신의 목적에 맞게 오버라이드 했을 경우,
	       * 어떤 타입이건 상관없이 동일하게 부모 타입으로 Ref 해서 오버라이드된 메서드를 호출 할 때, 즉 메서드명은 하나로 통일하되,
	       * 내용부는 인스턴스에 적용된 내용이 나오도록 하는데 목적이 있습니다.
	       * 
	       * 꼭 기억해야 할 것은, 부모타입으로 Ref 하던, 인스턴스를 생성하던, 생성된 인스턴스의 타입은 절대 불변이라는 겁니다.
	       */
		Marine m1 =  new Marine("마링","이등병", 60, 6);  //Instance 화 하는 단계, 즉 객체를 생성하는 코드입니다.
									//해서 정확한 문법적 표현은 Instantiation 이라고 합니다.
									//위에서 Marine() 이 호출된 이후에 Marine 클래스의 인스턴스가 생성되고
									//해당 인스턴스는 JVM 이 관리하는 Heap 메모리 영역에 저장되어집니다.
		FireBet f1 = new FireBet("퐈뺏", "상병", 60, 16);
		Medic md1 = new Medic("간호사", "하사", 60, 0);
		Ghost g1 = new Ghost("고스트","대위",60,100);
		
		
		
//		System.out.println(m1.toString());
//		System.out.println(f1.toString());
//		System.out.println(md1.toString());
//		
//		m1.sound();
//		f1.sound();
//		md1.sound();
//		
//		m1.move(100, 100);
//		
//		md1.healing("마린");
		
		Terran[] allUnit = {m1,f1,md1,g1};
		for(int i=0; i<allUnit.length; i++) {
			Terran theUnit = allUnit[(int)(Math.random()*allUnit.length)];
			//리턴되는 유닛을 모두 300,300 지점으로 도망(이동) 시켜보세요.
			//모든 유닛들이 sound()를 호출해보세요.
			theUnit.sound();
			//만약 리턴되는 인스턴스가 메딕이라면, "마린" 을 치료토록 해보세요..
			//즉 healing("마린") 을 호출하세요.
			if(theUnit instanceof Medic) {
				((Medic)theUnit).healing("마린");
			}
			if(theUnit instanceof Marine) {
				((Marine)theUnit).move(300,300);
			}else if(theUnit instanceof Medic){
				((Medic)theUnit).move(300,300);
			}else if(theUnit instanceof FireBet) {
				((FireBet)theUnit).move(300,300);
			}else if(theUnit instanceof Ghost) {
			((Ghost)theUnit).move(300,300);
		}
		}
		
//private 속성 즉 은닉(hidden) 정보를 직접 접근하여 에러발생됨
//		m1.name = "마링";
//		m1.hp = 40;
//		m2.name = "마리닝";
//		m2.hp = 40;
		
	}

}
