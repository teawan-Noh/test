package lab.itank.packageClass;

public class Book {
	private String name;
	private int price;
	private String write;
	
	public Book() {}
	
	
	
	public Book(String name, int price, String write) {  //¿ìÅ¬¸¯ -> source -> Generate Constructor field
		this.name = name;
		this.price = price;
		this.write = write;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWrite() {
		return write;
	}
	public void setWrite(String write) {
		this.write = write;
	}
	
	
}
