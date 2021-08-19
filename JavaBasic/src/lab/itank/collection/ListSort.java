package lab.itank.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSort { //sort : �빮��, �ҹ���, �ѱ� ������ ��迭 �ȴ�.

	public static void main(String[] args) {

		List<String> stringList = new ArrayList<String>(); // List �� ArrayList�� �θ� //�θ��ּҷ� �ڽİ�ü ���� �� �ִ�

		stringList.add("B");
		stringList.add("��");
		stringList.add("A");
		stringList.add("D");
		stringList.add("d");
		stringList.add("C");
		stringList.add("��");
		stringList.add("a");

		Collections.sort(stringList);

		for (String string : stringList) {
			System.out.println(string);
		}

		List<Integer> integerlist = new ArrayList<Integer>(); // List �� ArrayList�� �θ� //�θ��ּҷ� �ڽİ�ü ���� �� �ִ�

		integerlist.add(5);
		integerlist.add(3);
		integerlist.add(7);
		integerlist.add(2);

		Collections.sort(integerlist);  //�����޼ҵ�: Ŭ�����̸�.sort

		for (Integer integer : integerlist) {
			System.out.println(integer);
		}

		List<Book> bookList = new ArrayList<Book>();

		bookList.add(new Book("Java", 3000));
		bookList.add(new Book("Spring", 5000));
		bookList.add(new Book("�˰���", 1000));
		bookList.add(new Book("������", 3500));
		bookList.add(new Book("java2", 5500));
		
		//static <T extends Comparable<? super T>> void sort(List<T> list) {}
		//static <Book extends Comparable<Book>> void sort(List<Book> list) {}
		
		Collections.sort(bookList);   
		//array�� sort�� �Ϸ��� bookŬ������ implements Comparable <Book> ���ְ�
		//@Override �߰������ �Ѵ�
//		public int compareTo(Book book) {
//			
//			return this.name.compareTo(book.getName());
//		}
		for (Book book : bookList) {
			System.out.println("å�̸� : " + book.getName() + "å���� : " + book.getPrice());
		}
		System.out.println("===============================================");
		
		
		//static <T> void sort(List<T> list, Comparator<? super T> c) {}
		Collections.sort(bookList, new PriceComparator()); 
		
		for (Book book : bookList) {
			System.out.println("å�̸� : " + book.getName() + "å���� : " + book.getPrice());
		}
		System.out.println("===============================================");
		
		
		Collections.sort(bookList, new BookNameComparator()); 
		
		for (Book book : bookList) {
			System.out.println("å�̸� : " + book.getName() + "å���� : " + book.getPrice());
		}
	}
}
