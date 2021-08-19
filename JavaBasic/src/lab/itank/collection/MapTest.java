package lab.itank.collection;

import java.util.Hashtable;
import java.util.Set;

public class MapTest {
	
	public static void main(String[] args) {
		//데이터형태(key, value)
		//사용 이유: 키 값으로 검색하므로 겁색속도가 빠르다.
		
		Hashtable<String, String> hashtable = new Hashtable<>();
		hashtable.put("naver", "http://www.naver.com");
		hashtable.put("daum", "http://www.daum.net");
		hashtable.put("daum", "http://www.daum2.net");

		Set<String> key = hashtable.keySet();
		
		for (String string : key) {
			System.out.println(hashtable.get(string));
		}
		System.out.println(hashtable.get("naver"));
		System.out.println(hashtable.get("daum"));  //중복되게 넣으면 안된다. 중복될 경우 나중에 put한게 나옴. 덮어쓰기된다.
		
		
		Hashtable<Integer, Book> hashtable2 = new Hashtable<>();
		hashtable2.put(1, new Book("A", 1000));
		hashtable2.put(2, new Book("B", 1000));
		hashtable2.put(3, new Book("C", 1000));
		
		System.out.println(hashtable2.get(1).getName());
	}
}
