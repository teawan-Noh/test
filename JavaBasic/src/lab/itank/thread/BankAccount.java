package lab.itank.thread;

public class BankAccount {
	private int balance = 100;
	
	//�ܾ���ȸ
	public int getBalance() {
		return balance;
	}
	
	//����
	public void withdraw(int amount) {
		balance -= amount;
	}
}
