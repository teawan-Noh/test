package store;

public class Main {

	public static void main(String[] args) {
		
		Seller seller01 = new Seller(5, 10);
		Seller seller02 = new Seller(20, 15);

		Buyer buyer01 = new Buyer(1000);
		Buyer buyer02 = new Buyer(2000);
		Buyer buyer03 = new Buyer(3000);

		buyer01.order(seller01, 3, 2);
		buyer02.order(seller02, 5, 5);
		buyer03.order(seller02, 2, 7);

		System.out.println(buyer01.amount);
		System.out.println(buyer02.amount);
		System.out.println(buyer03.amount);	
		
		System.out.println(seller01.appleCount);			
		System.out.println(seller01.bananaCount);
		System.out.println(seller01.income);				

		System.out.println(seller02.appleCount);			
		System.out.println(seller02.bananaCount);
		System.out.println(seller02.income);
		
	}

}
