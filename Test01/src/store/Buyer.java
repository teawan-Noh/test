package store;

public class Buyer {

	int amount;
	
	Buyer(){}
	Buyer(int amount){
		this.amount = amount;
	}
	
	public void order(Seller seller, int appleCount, int bananaCount) {
		int total = seller.sell(appleCount, bananaCount);
		giveMoney(seller, total);
	}
	public void giveMoney(Seller seller, int total) {
		this.amount -= total;
		seller.takeMoney(total);
	}
}
