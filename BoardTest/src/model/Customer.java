package model;

public class Customer {
	
	private long customerseq;
	private String id;
	private String name;
	private String password;
	private String postcode;
	private String address;
	private String address2;
	private String phone;
	private String email;
	
	public Customer() {}
	
	public Customer(String id, String name, String password, String postcode, String address, String address2,
			String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.postcode = postcode;
		this.address = address;
		this.address2 = address2;
		this.phone = phone;
		this.email = email;
	}
	
	public long getCustomerseq() {
		return customerseq;
	}
	public void setCustomerseq(long customerseq) {
		this.customerseq = customerseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
