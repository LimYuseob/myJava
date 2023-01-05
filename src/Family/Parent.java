package Family;

public class Parent {
	private String familyName;
	
	public Parent(String familyName) {
		this.familyName = familyName;
	}
	
	public void doJob() {
		System.out.println("내 직업은 택시 운전 입니다.");
	}
	public String toString() {
		return "저희 가족 familyName은 " + familyName;
	}
}
