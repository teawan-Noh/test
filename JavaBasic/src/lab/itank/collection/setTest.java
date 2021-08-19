package lab.itank.collection;

import java.util.HashSet;

public class setTest {

	public static void main(String[] args) {
		//중복x, 순서 중요하지 않아
		HashSet	<String> set = new HashSet<>();
		set.add("A");
		set.add("10번 토지");
		set.add("C");
		set.add("A");
		set.add("F");
		set.add("F");
		set.add("F");
		
		System.out.println(set.size());
		for (String string : set) {
			System.out.println(string);
		}
	}

}
