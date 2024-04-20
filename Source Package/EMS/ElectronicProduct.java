package EMS;
import java.io.*;
import java.util.*;

public abstract class ElectronicProduct{
	public String productId;
	public String name;
	public double mrp_price;
	public double costprice;
	public double discount;
	public int quantity=0;
	public String type;
	
	
	public ElectronicProduct(String productId,String name, double mrp_price,double costprice,String type) {
		this.productId = productId;
		this.name = name;
		this.mrp_price=mrp_price;
		this.type=type;
		this.quantity=0;
		this.costprice=costprice;
		
	}
	public ElectronicProduct(String productId,String name, double mrp_price, int quantity,double costprice, String type) {
		this.productId = productId;
		this.name = name;
		this.mrp_price=mrp_price;
		this.quantity=quantity;
		this.type=type;
		this.costprice=costprice;
	}
	public void updateQauntity(int quantitychange) {
		this.quantity +=quantitychange;
	}
	public void displayDetails() {
		System.out.println("Product ID: "+this.productId);
		System.out.println("Name: "+this.name);
		System.out.println("Maximum Retail Price: "+this.mrp_price);
		System.out.println("Quantity: "+this.quantity);
		System.out.println("Type: "+this.type);
	}
	public boolean isAvailable() {
		if(this.quantity==0) {
			return false;
		}
		return true;
	}
	public double getCostPrice() {
		return this.costprice;
	}
	
	public abstract boolean isDiscountAvailable();
	public abstract double getFinalPrice();
	
	
	
	
	
}