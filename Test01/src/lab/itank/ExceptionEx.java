package lab.itank;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ExceptionEx {

	int a;

	public static void main(String[] args) {
		
		//���ܴ� �����Ҷ� �߻��Ѵ�
		//2���� ���̽� (��Ÿ�� : �ڵ����, �׿� : ���ܹ� �־���)
		//2�� ���̽� �߻��� try catch���  
		//���� ���ο� ������� ���������� �ϴ� �ڵ�� finally�� �־���
		//���ܹ� ������ �ڽ� ���ܹ� ���� �����ش� 
		
		Socket socket = null;

		try {
			socket = new Socket("localhost", 5000);
			
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException �߻��Ͽ����ϴ�");
			//e.printStackTrace();

		} catch (IOException e) {
			
		} finally {
			//���� �߻� ���ο� ������� ����Ǵ� �κ� (������ �����ִ� �ڵ带 �ַ� ����)
			try {
				socket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

}
