package lab.itank.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyBoardInputTest {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("�̸��� ������?==>");
		String name = in.readLine();
		
		System.out.println("��ȭ��ȣ ������?==>");
		String tel = in.readLine();
		
		System.out.println(name + "���� ��ȭ��ȣ��  " + tel + "�Դϴ�.");
		
		in.close();
	}

}
