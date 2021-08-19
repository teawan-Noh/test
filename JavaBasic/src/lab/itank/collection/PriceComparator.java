package lab.itank.collection;

import java.util.Comparator;

public class PriceComparator implements Comparator<Book>{

	@Override //추상메소드 구현
	public int compare(Book book1, Book book2) {
		
		//return ((Integer)book1.getPrice()).compareTo(book2.getPrice()); //정배열
		return ((Integer)book2.getPrice()).compareTo(book1.getPrice()); //역배열
	}


	
}
