package utilex;

public class UseRecord {

		// TODO 자동 생성된 메소드 스텁
		public static void main(String[] args) {
			Member member = new Member("yuseob", "임유섭", 34);
			Member member2 = new Member("byul", "임별하", 4);
			
			System.out.println(member.age());
			System.out.println(member.id());
			System.out.println(member.name());
			
			System.out.println(member2.age());
			System.out.println(member2.id());
			System.out.println(member2.name());
			
			System.out.println(member.toString());
			System.out.println(member.hashCode());
			System.out.println(member.equals(member));
			
			System.out.println(member2.toString());
			System.out.println(member2.hashCode());
			System.out.println(member2.equals(member2));
		}

}
