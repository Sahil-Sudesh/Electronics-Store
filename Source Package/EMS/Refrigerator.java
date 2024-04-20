package EMS;
public class Refrigerator extends ElectronicProduct implements help{
    public Refrigerator(String productId,String name, double mrp_price,double costprice,String type)
    {
        super(productId,name,mrp_price,costprice,type);
    }
    public Refrigerator(String productId,String name, double mrp_price, int quantity,double costprice, String type) {
		super(productId,name,mrp_price,quantity,costprice,type);
	}
    public boolean isDiscountAvailable()
    {
        return(super.discount>0);
    }
	
    
    public double getFinalPrice(boolean discount)
    {   if(discount)
        return(mrp_price-(super.discount*super.mrp_price/100));
        else return getFinalPrice();
    }public double getFinalPrice()
    {
        return(mrp_price-(super.discount*super.mrp_price/100));
    }
    public String helpbot()
    {
        return text;
    }
    
}