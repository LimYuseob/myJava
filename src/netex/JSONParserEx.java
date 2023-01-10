package netex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;

public class JSONParserEx {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("info.Yuseob"));
		String Yuseob = br.readLine();
		br.close();
		
		//JSON 파싱..
		JSONObject root = new JSONObject(Yuseob);
		System.out.println("id : " + root.getString("id"));
		System.out.println("name : " + root.getString("name"));
		System.out.println("학생여부 : " + (root.getBoolean("isStu") == false? "N":"Y"));
		System.out.println("나이 : " + root.getInt("age"));
		
		//객체 내부의 객체 얻어내기.
		JSONObject tel = root.getJSONObject("telNumber");
		System.out.println(tel.getInt("home"));
		System.out.println(tel.getInt("Cell"));
		System.out.println(tel.getInt("Emergency"));

	}

}
