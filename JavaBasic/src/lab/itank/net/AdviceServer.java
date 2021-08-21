package lab.itank.net;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class AdviceServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(5000);
		
		while(true) {
			
			//���� �¶�
			Socket socket = serverSocket.accept(); //5000������ ���� �����Ϸ��ϸ� �����ϴ°� �����
			
			//��� ���� 
			OutputStream os = socket.getOutputStream(); //socket���� �� �����ǵ� ������ �� �ִ� ��θ� �����
			
			//������ �ۼ�
			PrintWriter writer = new PrintWriter(os);
			
			String[] message = {"����!", "�Ҽ��־�!", "������ ���"};
			
			//��Ʈ�� �迭���� �������� �޴¾ֵ� ������
			Random random = new Random();
			int index = random.nextInt(3);
			
			writer.print(message[index]);
			
			//���� ����
			writer.close(); 
			socket.close();
		}

	}

}
