package lab.itank.thread;

public class ThreadTest {

	public static void main(String[] args) {
		Runnable job = new MyRunnable(); 
		
		Thread myThread = new Thread(job, "1번 스레드");
		myThread.start(); 
		
		Thread myThread2 = new Thread(job, "2번 스레드");
		myThread2.start();   //어떤 스레드가 일이 먼저 끝날지는 알 수 없다 
							//스레드는 순서대로 실행되지 않는다 
		
		System.out.println("main end!!!");  
		//쓰레드가 일할 때스케쥴러가 일할 순서 뿐만아니라 일할 시간도 정해준다

	}

}
