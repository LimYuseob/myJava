package utilex;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "조기제");
		map.put(2, "임진우");
		map.put(3, "김동환");
		map.put(4, "박동원");
		map.put(5, "정주호");

		for (int i = 1; i < map.size(); i++) {
			System.out.println(map.get(i));

		}
		getMap(map);
	}

	static void getMap(Map map) {
		// map타입으로 데이터를 받아서 전체 키를 찾고, value 찾고, collection타입으로 변경해 출력해보자.    <<<<<set에 문제 있어서 Object[] keys로 했음.
		
		if (map != null) {
			Set<Integer> set = map.entrySet();
			Object[] keys = set.toArray();
			if (set.isEmpty()) {
				for (int i = 0; i < keys.length; i++) {
					System.out.println(keys[i]);
				}
			}
		}
	}
}
