package quiz.model;

public class Book2 {

	private String isbn;
	private String name;
	private double price;
	
	public Book2(String isbn, String name, double price) {
		this.isbn = isbn;
		this.name = name;
		this.price = price;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}