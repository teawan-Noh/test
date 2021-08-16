package lab.itank;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ExceptionEx {

	int a;

	public static void main(String[] args) {
		
		//예외는 실행할때 발생한다
		//2가지 케이스 (런타임 : 코드수정, 그외 : 예외문 넣어줌)
		//2번 케이스 발생시 try catch사용  
		//예외 여부와 상관없이 실행했으면 하는 코드는 finally에 넣어줌
		//예외문 적을때 자식 예외문 부터 적어준다 
		
		Socket socket = null;

		try {
			socket = new Socket("localhost", 5000);
			
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException 발생하였습니다");
			//e.printStackTrace();

		} catch (IOException e) {
			
		} finally {
			//예외 발생 여부와 상관없이 실행되는 부분 (연결을 끊어주는 코드를 주로 넣음)
			try {
				socket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

}
