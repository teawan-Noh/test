package lab.itank.collection;

import java.util.ArrayList;

public class ArrayListTest { //가변길이 배열
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("A"); //0번방에 A
		list.add("B"); //1번방에 B
		list.add("C"); //2번방에 C
		
		for (int i = 0; i < list.size(); i++) { //배열의 크기를 가져옴
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		list.set(1, "BB");  //배열의 1번방에 있는 B를 BB로 바꿔준다
		
		for (String string : list) {
			System.out.print(string + " ");
		}
		System.out.println();
		
		list.remove(1); //배열의 1번방을 지움
		
		for (String string : list) {
			System.out.print(string + " ");
		}
		System.out.println();
		
		//Book객체를 넣는 ArrayList를 선언하세요
		//책 3권을 넣으세요.
		//모든 책의 정보(이름, 가격) 출력하세요 (for문 2가지 다 사용)
		//알고리즘의 책의 가격을 1500으로 변경해주세요
		//딥러닝 3500, java2 5500 2권을 추가해주세요
		//java 책을 검색해서 출력해주세요
		//구버전인 Java 책을 삭제해주세요
		
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		bookList.add(new Book("Java", 3000));
		bookList.add(new Book("Spring", 5000));
		bookList.add(new Book("알고리즘", 1000));
		
		
		
		for(int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			System.out.println(book.getName() + ", " + book.getPrice());
			//System.out.println(bookList.get(i).getName() + ", " + bookList.get(i).getPrice());
		}
		System.out.println("=========================================");
		
		for(Book string : bookList) {
			System.out.println(string.getName() + ", " + string.getPrice());
		}
		System.out.println("=========================================");
		
		bookList.get(2).setPrice(1500);
		//bookList.set(2, new Book("알고리즘", 1500)); //새책사서 넣으면 이렇게
		
		//for(Book item : bookList) {            //알고리즘 검색해서 가격 변경
		//	if(item.getName().equals("알고리즘"))
		//		item.setPrice(1500);
		//}
		
		bookList.add(new Book("딥러닝", 3500));
		bookList.add(new Book("java2", 5500));
		
		//검색해서 출력
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getName().toLowerCase().contains("java")) {
				System.out.println(bookList.get(i).getName() + bookList.get(i).getPrice());
			}
		}
		System.out.println("=========================================");
		
		//검색해서 삭제
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getName().contains("Java")) {
				bookList.remove(i);
			}
		}
		//2번 쨰 for문 사용시 //지워지면 배열의 크기가 줄어들어서 문제가 생긴다 //break; 사용해서 지워지면 멈춰지도록 
		
		//확인
//		System.out.println("=========================================");
//		for(int i = 0; i < bookList.size(); i++) {
//			System.out.print(bookList.get(i).getName() + ", ");
//			System.out.println(bookList.get(i).getPrice());
//		}
		
	}
}
