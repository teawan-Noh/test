package lab.itank.thread;

public class MyRunnable implements Runnable{ //�ϰŸ��� ������ �ȴ�

	@Override
	public void run() {
		go();
		
	}
	
	public void go() {
		//������ �������� ���̴� ���
		try {
			Thread.sleep(2000); //2�ʵ��� ��� �����
		} catch (Exception e) {
			e.printStackTrace();
		}
		doMore();
	}
	
	public void doMore() {
		System.out.println(Thread.currentThread().getName());
	}
	


}
