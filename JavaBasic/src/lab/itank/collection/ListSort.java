package lab.itank.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSort { //sort : 대문자, 소문자, 한글 순서로 재배열 된다.

	public static void main(String[] args) {

		List<String> stringList = new ArrayList<String>(); // List 는 ArrayList의 부모 //부모주소로 자식객체 받을 수 있다

		stringList.add("B");
		stringList.add("나");
		stringList.add("A");
		stringList.add("D");
		stringList.add("d");
		stringList.add("C");
		stringList.add("가");
		stringList.add("a");

		Collections.sort(stringList);

		for (String string : stringList) {
			System.out.println(string);
		}

		List<Integer> integerlist = new ArrayList<Integer>(); // List 는 ArrayList의 부모 //부모주소로 자식객체 받을 수 있다

		integerlist.add(5);
		integerlist.add(3);
		integerlist.add(7);
		integerlist.add(2);

		Collections.sort(integerlist);  //정적메소드: 클레스이름.sort

		for (Integer integer : integerlist) {
			System.out.println(integer);
		}

		List<Book> bookList = new ArrayList<Book>();

		bookList.add(new Book("Java", 3000));
		bookList.add(new Book("Spring", 5000));
		bookList.add(new Book("알고리즘", 1000));
		bookList.add(new Book("딥러닝", 3500));
		bookList.add(new Book("java2", 5500));
		
		//static <T extends Comparable<? super T>> void sort(List<T> list) {}
		//static <Book extends Comparable<Book>> void sort(List<Book> list) {}
		
		Collections.sort(bookList);   
		//array를 sort를 하려면 book클레스에 implements Comparable <Book> 해주고
		//@Override 추가해줘야 한다
//		public int compareTo(Book book) {
//			
//			return this.name.compareTo(book.getName());
//		}
		for (Book book : bookList) {
			System.out.println("책이름 : " + book.getName() + "책가격 : " + book.getPrice());
		}
		System.out.println("===============================================");
		
		
		//static <T> void sort(List<T> list, Comparator<? super T> c) {}
		Collections.sort(bookList, new PriceComparator()); 
		
		for (Book book : bookList) {
			System.out.println("책이름 : " + book.getName() + "책가격 : " + book.getPrice());
		}
		System.out.println("===============================================");
		
		
		Collections.sort(bookList, new BookNameComparator()); 
		
		for (Book book : bookList) {
			System.out.println("책이름 : " + book.getName() + "책가격 : " + book.getPrice());
		}
	}
}
