package oopEx1;

public class Ghost extends Terran implements GhostAbility{
	
	private String name;//마린의 이름
	private String rank;//계급
	private int hp;//피통
	private int damage;//데미지
	
public Ghost(String name, String rank, int hp, int damage) {
		
		/*
		 * 상속관계에서 자식 클래스에는 눈엔 보이지 않지만, 무조건 생성자 첫 머리에
		 * 컴파일러가 super() 를 호출하도록 되어있습니다.
		 */
		super("테란 ");
		this.name = name;
		this.rank = rank;
		this.hp = hp;
		this.damage = damage;
	}


	@Override
	public void sound() {
		System.out.println("Theres NO One here!");
	}
	public String toString() {
		return super.toString() + "이름은 " + this.name + " 계급은 " + this.rank + " HP : " +this.hp
				+ " 공격력 : " + this.damage;
	}
	//이동하는 기능인 move 메서드를 정의 합니다.
//	public void move(int x, int y) {
//		System.out.println(this.name + " 이 " + "[" + x + "," + y  + "]로 이동했습니다.");
//	}
	public void getHealing(int hp) throws InterruptedException {
		while(true) {
		if(this.hp == 40) {
			return;
		}
		Thread.sleep(1000);
		this.hp += hp;
		System.out.println(this.name + this.rank + " 이 치료를 받고 있습니다.");
		System.out.println("+" + hp + " 증가");
		}
	}


	@Override
	public void attack(String target) {
		System.out.println(super.getTheUnit() + " 가" + target + "저격 총으로 공격합니다.");
	}

	@Override
	public void move(int x, int y) {
		
	}


	@Override
	public void nuclearLaumch(int x, int y) {
		System.out.println(this.name + " 가" + "[" + x +","+ y + "]로 핵미사일을 유도합니다.");
		
	}

}
