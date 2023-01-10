package netex;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 * JSON 데이터 형식 : JSON 은 네트웍 상에서 데이터를 주고 받는 형식중에
 * 가장 유명하고 많이 쓰이는 형식이다.
 * 형태는 Map 과 유사하며, key:value 형태로 데이터를 저장 관리한다.
 * 그런데, 이렇게 key:value 로만 생성하면 데이터의 한계가 있기에
 * 여기에 객체와, 배열까지 추가하여 실질적으론 모든 데이터를 표기 가능한 형식이다.
 * 
 * 형식1 : {}--> 중괄호는 JSON 의 데이터 기본 형식 구문이다.
 * 형식2 : 위 괄호내에 다음처럼 key:value 를 추가하고 분류기호로는 ","
 * 2_1 : "속성명":속성값, "속성명:속성값..... N....
 * 2_2 : 2_1의 규칙 --> 속성명은 반드시 ""로 감싸야 한다.
 * 값으로 가능한것은 "문자열(반드시더블쿼트로)", number, boolean, 객체{}(내부적으로
 * 값이 객체 형태인 것은 {} 를 이용해서 정의해야함. [] --> 배열
 * 2_3 : 배열은 각각의 값을 "," 로 구분하여 정의 할 수 있다.
 * 값으로 가능한 타입은 "문자열",Number,boolean,{객체},[배열]
 * 
 * 참고로 객체를 사용해야 할 필요가 있는 경우는 아래와 같다.
 * 예를 들어 이름 : 값 은 1 key 에 1 value 가 일반적이지만,
 * 전화번호 tel 같은 경우엔, 하나의 속성에 값으론 home_tel, Cell_tell 등으로
 * 나뉘어 질 수 있다. 이때 객체를 이용한다.
 * 
 * 배열은 알다시피 하나의 속성에 값이 다양할 때 사용된다.
 * 
 * https//github.com/stleary/JSON-java
 */

public class JSONExam1 {

	public static void main(String[] args) {
		//JSON 객체 생성해 보기.
		JSONObject root = new JSONObject();
		//속성추가해보기.
		root.put("id", "Yuseob");
		root.put("name", "임유섭");
		root.put("age", "35");
		root.put("isStu", true);
		//여기까지가 일반 속성 준것임.
		
		//이번엔 속성중(tel)에 전화 모든 전화번호를 담고 싶은데, 집전화, 핸드폰, 비상시연락망
		//등으로 다시 속성들이 나열이 될 경우엔, 새로운 JSONObject 를 생성해서 값을 추가합니다.
		JSONObject telNumber = new JSONObject();
		telNumber.put("home", 112);
		telNumber.put("cell", 114);
		telNumber.put("Emehency", 119);
		
		//위에서 생성된 telNumber 객체는 임유섭에 관련된 정보이니, root에 다시 추가합니다.
		root.put("telNumber",telNumber);
		
		//이번엔 취미를 추가 합니다. hobby 라는 속성엔 하나 이상의 값만이 존재하니
		//객체 보다는 배열이 맞겠습니다..하지만 JSON 에선 배열도 객체로 표기해야 하니
		//JOSONOArry 를 생성, put만 이용해서 값을 넣습니다.
		JSONArray hobby = new JSONArray();
		hobby.put("스포츠");
		hobby.put("볼링");
		hobby.put("드라마시청");
		
		//hobby 또한 임유섭에 관련된 객체 정보이니깐, 다시 put 합니다.
		root.put("hobby", hobby);
		
		String objString = root.toString();
		
		System.out.println(objString);
		
		try {
			FileWriter fw = new FileWriter("info.Yuseob");
			fw.write(objString);
			
			fw.flush();
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
