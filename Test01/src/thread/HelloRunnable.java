package thread;

public class HelloRunnable implements Runnable{
	
	@Override
	public void run() {
		System.out.println("스레드 일하는중");
		
	}
	

	public static void main(String[] args) {
		
		Runnable iob =  new HelloRunnable();
		
		Thread thread = new Thread(iob);
		
		
		thread.start();
	}


}
