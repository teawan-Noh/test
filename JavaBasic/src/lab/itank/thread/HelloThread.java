package lab.itank.thread;

public class HelloThread extends Thread{

	public void run() {
		System.out.println("HelloThread");
	}
	
	public static void main(String[] args) {
		System.out.println("main");
		
		Thread thread = new HelloThread();
		thread.start(); // 실행 가능(대기) 상태
		
		System.out.println("end");
	}
}
