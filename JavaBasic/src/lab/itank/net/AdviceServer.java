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
			
			//연결 승락
			Socket socket = serverSocket.accept(); //5000번으로 누가 접속하려하면 연결하는걸 허락해
			
			//통로 생성 
			OutputStream os = socket.getOutputStream(); //socket한테 뭘 보낼건데 전송할 수 있는 통로를 만들어
			
			//실제로 작성
			PrintWriter writer = new PrintWriter(os);
			
			String[] message = {"힘내!", "할수있어!", "끝까지 고고"};
			
			//스트링 배열에서 랜덤으로 받는애들 가져와
			Random random = new Random();
			int index = random.nextInt(3);
			
			writer.print(message[index]);
			
			//서버 닫음
			writer.close(); 
			socket.close();
		}

	}

}
