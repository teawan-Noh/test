package thread;

public class ThreadTest {

	public static void main(String[] args) {

		Runnable job = new MyRunnable();
		
		Thread myThread = new Thread(job, "1번 스레드");
		myThread.start();
		
		Thread myThread2 = new Thread(job, "2번 스레드");
		myThread2.start();
		
		System.out.println("main end!!");
	}

}
