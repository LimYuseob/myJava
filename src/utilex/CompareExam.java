package utilex;

import java.util.TreeSet;

//성적입력 관련
class Person implements Comparable<Person> {
	int score;
	String name;

	public Person(int score, String name) {
		this.score = score;
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		if (this.score < o.score)
			return -1;
		else if (this.score == o.score)
			return 0;
		else
			return 1;
	}
}

public class CompareExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person 기제 = new Person(98, "기제");
		Person 진우 = new Person(99, "진우");
		Person 동환 = new Person(100, "동환");

		TreeSet<Person> tSet = new TreeSet<Person>();
		tSet.add(기제);
		tSet.add(진우);
		tSet.add(동환);

		for (Person p : tSet) {
			System.out.println(p.name + " : " + p.score); //
		} //
		
	}//End main

}
