package langEx;

public class IntegerExam {

	public static void main(String[] args) {

		/*
		 * Wrapper 클래스 : 자바의 모든 Ptype 의 정보를 관리하는 클래스
		 */
		
		int i = Integer.valueOf(10) + 1;
		System.out.println(i);
		
		new Integer("10");
		System.out.println(Integer.compare(10, 11));
		
		String s = "10.0";
		System.out.println(Double.parseDouble(s));
		System.out.println(Integer.toBinaryString(11));
		System.out.println(Integer.toHexString(11));
		System.out.println(Integer.toString(11));
	}

}
