package lab.itank.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientEx {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("192.168.35.5", 5000);
		
		InputStreamReader stream = new InputStreamReader(socket.getInputStream());
		
		BufferedReader reader = new BufferedReader(stream);
		String message = reader.readLine();
		System.out.println(message);
		
		reader.close();
	}

}
