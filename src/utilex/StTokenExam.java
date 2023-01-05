package utilex;

import java.util.StringTokenizer;

public class StTokenExam {

	public static void main(String[] args) {

		String msg = "Hello,Java,World/jsp*aaa";
		
		StringTokenizer st = new StringTokenizer(msg, ",/*");
		
		System.out.println(st.countTokens());
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			System.out.println(s);
		}
	}

}
