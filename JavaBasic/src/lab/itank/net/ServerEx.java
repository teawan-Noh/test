package lab.itank.net;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerEx {

	public static void main(String[] args) throws IOException{
		
		ServerSocket serverSocket = new ServerSocket(5000);
		
		while(true) {
			
			Socket socket = serverSocket.accept();

			OutputStream os = socket.getOutputStream();
			
			PrintWriter writer = new PrintWriter(os);
			
			String[] message = {"1", "2", "3"};
			
			Random random = new Random();
			int index = random.nextInt(3);
			
			writer.print(message[index]);
			
			writer.close();
			socket.close();
			
		}
		
	}

}
