package Family;

public class Sister extends Parent{

		private String name;
		private String age;
		private String addr;
		
		public Sister(String name, String age, String addr) {
			super("Ja ");
			this.name = name;
			this.age = age;
			this.addr= addr;
		}
		public void doJob() {
			System.out.println("제 지억은 웹디자이너 입니다.");
		}
		public String toString() {
			return super.toString() + "이름은 " + this.name + " 나이는 " + this.age + " 주소는 : " +this.addr;
		}
		
	}
