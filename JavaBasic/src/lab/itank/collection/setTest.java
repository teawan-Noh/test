package lab.itank.collection;

import java.util.HashSet;

public class setTest {

	public static void main(String[] args) {
		//�ߺ�x, ���� �߿����� �ʾ�
		HashSet	<String> set = new HashSet<>();
		set.add("A");
		set.add("10�� ����");
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
