package assignment4;

public class Item {

	private String name;
	private Double Price;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Item() {
		super();
	}
	
	
	public Item(String name, Double price, String type) {
		super();
		this.name = name;
		Price = price;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Item [name=" + name + ", Price=" + Price + ", type=" + type + "]";
	}
	
	
	

}