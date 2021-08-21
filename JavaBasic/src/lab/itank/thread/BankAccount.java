package lab.itank.thread;

public class BankAccount {
	private int balance = 100;
	
	//잔액조회
	public int getBalance() {
		return balance;
	}
	
	//인출
	public void withdraw(int amount) {
		balance -= amount;
	}
}
