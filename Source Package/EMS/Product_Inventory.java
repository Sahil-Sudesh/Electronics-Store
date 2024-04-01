package EMS;
import java.io.*;
import java.util.*;

abstract class ElectronicProduct{
	protected String productId;
	protected String name;
	protected double mrp_price;
	protected double retail_price;
	protected double discount;
	protected int quantity=0;
	protected String type;
	
	
	public ElectronicProduct(String productId,String name, double mrp_price,String type) {
		this.productId = productId;
		this.name = name;
		this.mrp_price=mrp_price;
		this.type=type;
	}
	public ElectronicProduct(String productId,String name, double mrp_price, int quantity, String type) {
		this.productId = productId;
		this.name = name;
		this.mrp_price=mrp_price;
		this.quantity=quantity;
		this.type=type;
	}
	public void updateQauntity(int quantity) {
		this.quantity +=quantity;
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
	public double getMrpPrice() {
		return this.mrp_price;
	}
	abstract boolean isDiscountAvailable();
	abstract double getFinalPrice();
	
	
	
	
	
}

public class Product_Inventory {
	
}
