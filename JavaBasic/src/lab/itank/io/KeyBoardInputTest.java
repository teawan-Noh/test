package lab.itank.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyBoardInputTest {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("이름이 뭐예여?==>");
		String name = in.readLine();
		
		System.out.println("전화번호 뭐예여?==>");
		String tel = in.readLine();
		
		System.out.println(name + "님의 전화번호는  " + tel + "입니다.");
		
		in.close();
	}

}
