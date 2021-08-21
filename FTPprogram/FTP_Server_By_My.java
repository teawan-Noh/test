import java.io.*;
import java.net.*;
import java.util.*;

class FTP_Server
{
	
	final static int BUFFER_SIZE=256;
	byte[] buffer = new byte[BUFFER_SIZE];
	
	ServerSocket serverSock;
	Socket clientSocket;

	public static void main(String[] args){
		new FTP_Server().init();
	}

	public void init(){
			
		//서버 생성
		//소켓 승낙
		//메뉴 및 파일명 읽기

		//메뉴가 send인 경우 : 파일 받기

			//읽을 준비
			//파일준비
			//클라이언트로 온 내용을 읽고 파일에 쓰기
			//모든 연결 요소 닫기

		//메뉴가 receive 경우 : 파일 전송				

			//파일 준비
			//파일 읽기 준비
			//파일 쓰기 준비
			//파일 읽어서 클라이언트로 보내기

			//모든 연결 요소 닫기

		 //클라이언트 소켓 연결 끊기

	}
}
