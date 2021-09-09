package server;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Client{
	JTextArea in;
	JTextField out;
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;
	InputStream inputStream;
	OutputStream outputStream;

	public static void main(String[] args) throws UnknownHostException, IOException{
		Client client = new Client();
		client.init();
	}
	
	public void init() throws UnknownHostException, IOException{
		JFrame frame = new JFrame("Chat Client");
		JPanel mainPanel = new JPanel();
		in = new JTextArea(15,30);
		in.setLineWrap(true);
		in.setEditable(false);
		JScrollPane qScroller = new JScrollPane(in);
		out= new JTextField(25);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(qScroller);
		mainPanel.add(out);
		mainPanel.add(sendButton);	

		networking();
		Thread readerThread = new Thread(new InDataReader());
		readerThread.start();
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400,350);
		frame.setVisible(true);
	}
	private void networking() throws UnknownHostException, IOException{
		//소켓생성
		sock = new Socket("192.168.35.5", 5000);
		System.out.println("2. CLIENT CONNECTED : "+sock.getInetAddress()+":"+sock.getLocalPort());
		//읽어들이는 라인 생성
		this.inputStream = sock.getInputStream();
		//쓰는 라인 생성
		this.outputStream = sock.getOutputStream();
	}
	public class SendButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			//작성한 내용 보내기
			writer = new PrintWriter(outputStream, true);
			writer.println(out.getText());
			out.setText("");
			out.requestFocus();
		}
	}
	public class InDataReader implements Runnable{
		public void run(){
			//서버가 보낸 내용 읽어
			reader = new BufferedReader(new InputStreamReader(inputStream));
			//화면에 추가하기
			String text;
			try {
				while(true) {
					text = reader.readLine();
					in.append(text + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}