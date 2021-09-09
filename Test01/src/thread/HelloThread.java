package thread;

public class HelloThread extends Thread{
	
	public void run() {
		System.out.println("HelloThread");
	}
	
	public static void main(String[] args) {
		System.out.println("main");
		
		Thread thread = new HelloThread();
		thread.start();
		
		System.out.println("end");
	}
}
