package store;

public class Seller {
	
	int appleCount;
	int bananaCount;
	int income = 0;
	
	Seller(){}
	Seller(int appleCount, int bananaCount){
		this.appleCount = appleCount;
		this.bananaCount = bananaCount;
	}
	
	public int sell(int appleCount, int bananaCount) {
		this.appleCount -= appleCount;
		this.bananaCount -= bananaCount;
		int total = 
				(Apple.price * appleCount) + (Banana.price * bananaCount);
		
		return total;
	}
	
	public void takeMoney(int total) {
		income += total;
	}

}
