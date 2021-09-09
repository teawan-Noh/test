package server;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server{
	
	OutputStream outputStream;
	
	ArrayList<Socket> socketList = new ArrayList<Socket>();
	
	public static void main(String[] args) throws IOException{
		new Server().init();
	}

	public void init() throws IOException{

			//서버 생성
			ServerSocket serverSocket = new ServerSocket(5000);
			System.out.println("SERVER SOCKET OPEN");
			while(true) {
				//클라이언트 요청 승낙
				Socket clientSocket = serverSocket.accept();
				//클라이언트에 쓰는 라인 생성
				outputStream = clientSocket.getOutputStream();
				//연결라인을 자료구조(ArrayList 등)에 추가
				socketList.add(clientSocket);
				//클라이언트당 스레스 하나 생성 및 실행준비
				ClientManager cm = new ClientManager(clientSocket);
				Thread thread1 = new Thread(cm, "Client1");
				thread1.start();
			}
	}
	
	
	//클라이언트들의 내용을 읽고, 
	//모두에게 내용 전달 하는 내부클래스
	public class ClientManager implements Runnable{
		
		Socket clientSocket;
		InputStream inputStream;
		public ClientManager(Socket clientSocket) throws IOException{
			this.clientSocket = clientSocket;
			this.inputStream = clientSocket.getInputStream();
		}

		public void run(){
			
			while(true) {
				System.out.println("CLIENT CONNECT : "+clientSocket.getInetAddress());
				//클라이언트들의 내용을 읽고, 
				//sendAll(String message)를 통해 내용을 전달
				//(즉, sendAll()메소드 호출)
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				String message = null;
				try {
					message =reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					sendAll(message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	
	public void sendAll(String message) throws IOException{
		//자료구조에 저장되어 있는 클라이언트에게
		//읽은 내용(인자로 받은 메세지)을 전달한다.
		for(int i = 0; i < socketList.size(); i++) {
			outputStream = socketList.get(i).getOutputStream();
			PrintWriter writer = new PrintWriter(outputStream, true);
			writer.println(message);
		}
		
	}

}