package model;

public class Product {
private String id;
private String name;
private String category;
private String price;
private String active;

public Product()
{
	}
public Product(String id, String name, String category, String price, String active) {
	super();
	this.id = id;
	this.name = name;
	this.category = category;
	this.price = price;
	this.active = active;
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
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getActive() {
	return active;
}
public void setActive(String active) {
	this.active = active;
}


}
