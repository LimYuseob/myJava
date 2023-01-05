package utilex;

import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExam {
	/*
	 * 검색기능을 강화한 컬렉션. 각 노드를 부모노드를 좌(작음)우(큼)로 찢어서 검색을 빠르게하는 장점이 있음. 이 검색기능을 이용하기 위해서는
	 * 반드시 TreeSet객체로 생성해야한다. 이유는 검색 메서드는 TreeSet에서만 정의했기 때문이다. 기본적 정렬 방식은
	 * ascending(오름차순).
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add((int) (Math.random() * 100) + 1);
		scores.add((int) (Math.random() * 100) + 1);
		scores.add((int) (Math.random() * 100) + 1);
		scores.add((int) (Math.random() * 100) + 1);
		scores.add((int) (Math.random() * 100) + 1);
		scores.add((int) (Math.random() * 100) + 1);
		scores.add((int) (Math.random() * 100) + 1);
		scores.add((int) (Math.random() * 100) + 1);
		scores.add((int) (Math.random() * 100) + 1);
		scores.add((int) (Math.random() * 100) + 1);												//랜덤값 뽑아낼 것들.

		// 지정된 Element 출력하기
		for (Integer i : scores) {																				//위에 열게 출력문
			System.out.println(i + "  ");
		}
		System.out.println("------------------");														//구분선

		System.out.println("가장 낮은 수 : " + scores.first());										//first, last 문법 테스트
		System.out.println("가장 높은 수 : " + scores.last());

		System.out.println("50점 아래 : " + scores.lower(50)); // 50 아래 값 하나만 나온다.
		System.out.println("50점 이거나 바로 위. (없으면 그 윗값?) : " + scores.higher(50)); // 윗값 하나
		System.out.println("80점 이상 중 최대값. (없으면 null 추출) : " + scores.ceiling(50)); // higher, ceiling 차이 잘 몰름...

		System.out.println("------------------");

		NavigableSet<Integer> descSco = scores.descendingSet();		// TreeSet기본값이 오름차순이라 내림차순으로 바꾼거.
		System.out.println(descSco);
		for (int i : descSco) {
			System.out.println(i);																		//역순 테스트 출력
		}
		System.out.println("------------------");
		
		NavigableSet<Integer> rangeSet = descSco.tailSet(50, true);					//tailset. 50 아래값 출력
		for(int i : rangeSet) {
			System.out.println(i);
		}
		
		//sebSet
		System.out.print(scores.subSet(20, true, 40, true));;		//이상 이하
		System.out.print(scores.subSet(20, true, 40, false));;		// 이상 미만
		System.out.print(scores.subSet(20, false, 40, true));;		//초과 이하
		System.out.print(scores.subSet(20, false, 40, false));;		//초과 미만
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
