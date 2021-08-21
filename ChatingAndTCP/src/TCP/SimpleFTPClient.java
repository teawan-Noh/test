package TPC;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FTP_Client extends JFrame{
	JTextArea incoming;
	JTextField dirfield, filenamefield;
	BufferedReader reader;
	Socket sock;
	JFileChooser fc = new JFileChooser("D:\ftp");

	final static int BUFFER_SIZE=256;
	byte[] buffer = new byte[BUFFER_SIZE];

	public static void main(String[] args){
	
		FTP_Client client = new FTP_Client();
		client.init();
	}
	public void init(){
		JFrame frame = new JFrame("Simple FTP Client");
		JPanel mainPanel = new JPanel();
		incoming = new JTextArea(15,30);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		JScrollPane qScroller = new JScrollPane(incoming);
		dirfield= new JTextField(31);
		filenamefield=new JTextField(31);
		
		JButton fileButton = new JButton("File");
		JButton sendButton = new JButton("Send");
		JButton receiveButton = new JButton("Receive");
		
		fileButton.addActionListener(new FileButtonListener());
		sendButton.addActionListener(new SendButtonListener());
		receiveButton.addActionListener(new ReceiveButtonListener());
		mainPanel.add(qScroller);
		mainPanel.add(dirfield);
		mainPanel.add(filenamefield);
		mainPanel.add(fileButton);
		mainPanel.add(sendButton);
		mainPanel.add(receiveButton);		

		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400,400);
		frame.setVisible(true);
	}

	private void setUpNetworking(){
			//소켓생성
	}

	public class SendButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){

				setUpNetworking();

				//보내고자 하는 메뉴와 파일명을 서버로 보낸다.

				//보내고자 하는 파일을 준비
				
				//파일 읽기 준비
				
				//서버로 보낼 준비
				
				//파일을 읽어서 서버로 전송	

				//"파일 전송 완료"되면 완료 메세지를 화면에 출력
				
				//모든 연결 요소를 닫는다.

				//디렉토리 필드, 파일필드 모두 내용을 모두 지운다.
		}
	}

	public class  ReceiveButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){

				setUpNetworking();				
				
				//읽고 싶은 메뉴와 파일명 보내기
				
				//서버로 부터 온  파일내용 읽기 준비

    			//읽은 내용을 파일에 쓰기 준비

				//서버로부터 온 내용 읽고 파일에 쓰기

				//"파일 다운로드 완료" 메세지 화면에 출력

				//모든 연결 요소를 닫는다.	

				//디렉토리 필드, 파일필드 모두 내용을 모두 지운다.		
		}
	}

	public File fileChoose(){
		
		//JFileChooser를 이용하여 선택된 파일을 리턴한다.
	
	}

	public class  FileButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
		
			//fileChoose()를 호출하여 리턴된 
			//파일의 디렉토리와 파일이름에 
			//dirfield, filenamefield에 출력한다.
		}
	}
}