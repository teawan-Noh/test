package lab.itank.thread;

public class HelloRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("������ ���ϴ���");
		
	}
	
	public static void main(String[] args) {
		
		Runnable job = new HelloRunnable();
		
		Thread thread = new Thread(job);
		thread.setPriority(Thread.MAX_PRIORITY); //�켱������ �÷��޶�� ��û ��
												 //��û�Ѵٰ� �� ����ִ°� �ƴ����� Ȯ���� �ö�
		
		thread.start();
	}

}
