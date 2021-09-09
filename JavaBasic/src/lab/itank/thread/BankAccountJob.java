package lab.itank.thread;

public class BankAccountJob implements Runnable{ //implements Runnable 사용하는걸 권장

	private BankAccount customer = new BankAccount();
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			makeWithdraw(10);
			
			if(customer.getBalance() < 0) {
				System.out.println("마이너스야!!");
			}
		}
	}
	//synchronized : 어떤 스레드가 먼저 들어와있으면 다른 스레드는 들어올 수 없다
	public synchronized void makeWithdraw(int amount) { 
		if(customer.getBalance() >= amount) {

			System.out.println(Thread.currentThread().getName()+"잔액조회완료");
			customer.withdraw(amount);
			System.out.println(Thread.currentThread().getName()+"인출 완료");
		}
		else {
			System.out.println("잔고부족");
		}
	}

	public static void main(String[] args) {
		BankAccountJob job = new BankAccountJob();
		
		Thread a = new Thread(job, "부인");
		Thread b = new Thread(job, "남편");
		
		a.start();
		b.start();
		
	}
	
}
