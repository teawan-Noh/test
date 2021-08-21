package lab.itank.thread;

public class BankAccountJob implements Runnable{ //implements Runnable ����ϴ°� ����

	private BankAccount account = new BankAccount();
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			makeWithdraw(10);
			
			if(account.getBalance() < 0) {
				System.out.println("���̳ʽ���!!");
			}
		}
	}
	//synchronized : � �����尡 ���� ���������� �ٸ� ������� ���� �� ����
	public synchronized void makeWithdraw(int amount) { 
		if(account.getBalance() >= amount) {

			System.out.println(Thread.currentThread().getName()+"�ܾ���ȸ�Ϸ�");
			account.withdraw(amount);
			System.out.println(Thread.currentThread().getName()+"���� �Ϸ�");
		}
		else {
			System.out.println("�ܰ����");
		}
	}

	public static void main(String[] args) {
		BankAccountJob job = new BankAccountJob();
		
		Thread a = new Thread(job, "����");
		Thread b = new Thread(job, "����");
		
		a.start();
		b.start();
		
	}
	
}
