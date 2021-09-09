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

			//���� ����
			ServerSocket serverSocket = new ServerSocket(5000);
			System.out.println("SERVER SOCKET OPEN");
			while(true) {
				//Ŭ���̾�Ʈ ��û �³�
				Socket clientSocket = serverSocket.accept();
				//Ŭ���̾�Ʈ�� ���� ���� ����
				outputStream = clientSocket.getOutputStream();
				//��������� �ڷᱸ��(ArrayList ��)�� �߰�
				socketList.add(clientSocket);
				//Ŭ���̾�Ʈ�� ������ �ϳ� ���� �� �����غ�
				ClientManager cm = new ClientManager(clientSocket);
				Thread thread1 = new Thread(cm, "Client1");
				thread1.start();
			}
	}
	
	
	//Ŭ���̾�Ʈ���� ������ �а�, 
	//��ο��� ���� ���� �ϴ� ����Ŭ����
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
				//Ŭ���̾�Ʈ���� ������ �а�, 
				//sendAll(String message)�� ���� ������ ����
				//(��, sendAll()�޼ҵ� ȣ��)
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
		//�ڷᱸ���� ����Ǿ� �ִ� Ŭ���̾�Ʈ����
		//���� ����(���ڷ� ���� �޼���)�� �����Ѵ�.
		for(int i = 0; i < socketList.size(); i++) {
			outputStream = socketList.get(i).getOutputStream();
			PrintWriter writer = new PrintWriter(outputStream, true);
			writer.println(message);
		}
		
	}

}