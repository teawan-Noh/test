package lab.itank.collection;

import java.util.Comparator;

public class PriceComparator implements Comparator<Book>{

	@Override //�߻�޼ҵ� ����
	public int compare(Book book1, Book book2) {
		
		//return ((Integer)book1.getPrice()).compareTo(book2.getPrice()); //���迭
		return ((Integer)book2.getPrice()).compareTo(book1.getPrice()); //���迭
	}


	
}
