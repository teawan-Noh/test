package lab.itank2;

import java.util.Scanner;

public class Player {

	private int number;

	// scanner로 입력 받아 객체 변수에 값을 셋팅한다.
	Scanner sc = new Scanner(System.in);

	public void guess() {
		int num = sc.nextInt();
		setNumber(num);
	}

	// set,get 메소드
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
