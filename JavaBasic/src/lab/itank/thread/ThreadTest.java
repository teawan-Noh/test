package lab.itank.thread;

public class ThreadTest {

	public static void main(String[] args) {
		Runnable job = new MyRunnable(); 
		
		Thread myThread = new Thread(job, "1�� ������");
		myThread.start(); 
		
		Thread myThread2 = new Thread(job, "2�� ������");
		myThread2.start();   //� �����尡 ���� ���� �������� �� �� ���� 
							//������� ������� ������� �ʴ´� 
		
		System.out.println("main end!!!");  
		//�����尡 ���� �������췯�� ���� ���� �Ӹ��ƴ϶� ���� �ð��� �����ش�

	}

}
