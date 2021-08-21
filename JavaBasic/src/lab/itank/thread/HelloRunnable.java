package lab.itank.thread;

public class HelloRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("스레드 일하는중");
		
	}
	
	public static void main(String[] args) {
		
		Runnable job = new HelloRunnable();
		
		Thread thread = new Thread(job);
		thread.setPriority(Thread.MAX_PRIORITY); //우선순위로 올려달라고 요청 함
												 //요청한다고 다 들어주는건 아니지만 확률이 올라감
		
		thread.start();
	}

}
