package model.product;

public class Product {
	
	private int productid;
	private String name;
	private String description;
	private int price;
	
	public Product() {
	}

	public Product(String name, String description, int price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Product(int productid, String name, String description, int price) {
		this.productid = productid;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
