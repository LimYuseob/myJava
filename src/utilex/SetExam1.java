package utilex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/*
	 *  Set 타입.
	 *  Set타입은 Collection의 자식타입으로 기본적으로는 List와 메서드가 동일한게 많다.
	 *  특징으로는 중복을 허용하지 않는게 있고 또 다른 하나는 검색기능을 추가한 형태의 API들이 Set타입에 있다.
	 *  또한 정렬 기능을 적용한 TreeSet등도 있다.
	 *  
	 *  먼저 간단한 API사용법.
	 *  HashSet은 대표적 클래스로 일반적인 Set을 구현할 때 사용하는 클래스.
	 */
public class SetExam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		set.add("1");
		set.add("5");

		System.out.println(set);

		// 로또 만들기 , 오름차순
		HashSet<Integer> set2 = new HashSet<Integer>(); // 1. String으로 문자열 로또생성하면 13, 24, 34, 37, 8, 9처럼 정렬되니,
														// <Integer>로 시작

		for (int i = 0; set2.size() < 6; i++) { // '< 6'인 이유는 중복된 값을 우선 뽑아서 내고 HashSet에서 삭제시키기 위함.
			int num = (int)(Math.random() * 45) + 1;
			set2.add(num);

		}
		System.out.println(set2); // 2. 혹시몰라 랜덤값 잘 나오는지 확인해본거.

		List<Integer> fir = new LinkedList<Integer>(set2);
		Collections.sort(fir); // 3. 정렬 선생님이 하신거
		System.out.println(fir);

//		fir.sort(Comparator.naturalOrder());									//4. 얘도 가능     내가 한거
//		System.out.println(fir);

		// TreeSet이라는 Class 자체에 정렬 기능이 있으나, 구 버전이어서 꼭 필요치는 않음. 연습하고싶으면 해도 된다.
		// 자동으로 정렬을 하기 때문에 코딩이 간결하다는 장점이 있기는 함. navigable도 거의 유사한 기능을 해냄.

		TreeSet<Integer> tset = new TreeSet<Integer>(set2); // 걍 혼자 해본거. 혹시 도움 될까싶어서
		System.out.println(tset);

	}
}
