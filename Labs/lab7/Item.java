class Item {
	private String name;
	private double price;
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public Item(Item other) {
		this.name = other.name;
		this.price = other.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return name + ": " + price;
	}
	
	public boolean equals(Item other) {
		return this.name.equals(other.name) && this.price == other.price;
	}
}