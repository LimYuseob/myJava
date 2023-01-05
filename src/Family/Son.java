package Family;

public class Son extends Parent{

		private String name;
		private String age;
		private String addr;
		
		public Son(String name, String age, String addr) {
			super("Ja ");
			this.name = name;
			this.age = age;
			this.addr= addr;
		}
		public void doJob() {
			System.out.println("제 지억은 프로그래머 입니다.");
		}
		
		public String toString() {
			return super.toString() + "이름은 " + this.name + " 나이는 " + this.age + " 주소는 : " +this.addr;
		}
		
	}

