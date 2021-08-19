package lab.itank.packageClass;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("책 이름 입력 >>");
		String name = scanner.nextLine();
		System.out.println("입력값 확인 : " + name);
		
		System.out.println("책 가격 입력 >>");
		//int price = scanner.nextInt();  //숫자만 읽고 개행문자(엔터)를 읽지 않기때문에 20번 줄처럼 추가해주거나 String값으로 받아 형변환을 해준다
		int price = Integer.parseInt(scanner.nextLine());
		System.out.println("입력값 확인 : " + price);
		
		//scanner.nextLine();
		
		System.out.println("저자 입력 >>");
		String writer = scanner.nextLine();
		System.out.println("입력값 확인 : " + writer);
		
		System.out.println("입력이 완료되었습니다");
		
		Book book = new Book(name, price, writer);
		
		
		
		//스캐너 닫기
		scanner.close();
		

	}

}
