package lab.itank2;

import java.util.Scanner;

public class Player {

	private int number;

	// scanner�� �Է� �޾� ��ü ������ ���� �����Ѵ�.
	Scanner sc = new Scanner(System.in);

	public void guess() {
		int num = sc.nextInt();
		setNumber(num);
	}

	// set,get �޼ҵ�
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
