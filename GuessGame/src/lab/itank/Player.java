package lab.itank;

import java.util.Scanner;

public class Player {
	
	private int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	//scanner�� �Է� �޾� ��ü ������ ���� �����Ѵ�.
	Scanner sc = new Scanner(System.in);
	public void guess() {
		int guessNum = Integer.parseInt(sc.nextLine());
		setNumber(guessNum);
	}
	
	//set,get �޼ҵ� 
	
}
