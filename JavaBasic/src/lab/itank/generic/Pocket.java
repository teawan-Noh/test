package lab.itank.generic;  

import java.util.ArrayList;
import java.util.HashMap;

public class Pocket<T> { // <T> : generic class , T자리에는 Class 이름이 들어감 (정해지지 않았을땐 T)
	
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public static void main(String[] args) {
		
		Pocket<String> pocket = new Pocket<>();
		pocket.setT("abc");
		System.out.println(pocket.getT());
		
		ArrayList<String> arrayList01 = new ArrayList<>();
		arrayList01.add("aaa");  //<String>이기떄문에 스트링값
		
		ArrayList<Integer> arrayList02 = new ArrayList<>();
		arrayList02.add(34);	//<Integer>이기떄문에 Integer값 //wrapper됨
		
		ArrayList<Dog> arrayList03 = new ArrayList<>();
		arrayList03.add(new Dog());		//<Dog>이기떄문에 Dog값
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("a1", 323);
		
		HashMap<String, Dog> map2 = new HashMap<String, Dog>();
		map2.put("ads", new Dog());
	}
}
