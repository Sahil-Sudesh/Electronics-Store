package EMS;
public class AirConditioner extends ElectronicProduct implements help{
    public AirConditioner(String productId,String name, double mrp_price,double costprice,String type)
    {
        super(productId,name,mrp_price,costprice,type);
    }
    public AirConditioner(String productId,String name, double mrp_price, int quantity,double costprice, String type) {
		super(productId,name,mrp_price,quantity,costprice,type);
	}
    public boolean isDiscountAvailable()
    {
        return(super.discount>0);
    }
	public double getFinalPrice()
    {
        return(mrp_price);
    }
    
    public double getFinalPrice(boolean discount)
    {   if(discount)
        return(mrp_price-(super.discount*super.mrp_price/100));
        else return getFinalPrice();
    }
    public String helpbot()
    {
        return text;
    }
    
}