
package EMS;
public class WashingMachine extends ElectronicProduct implements help{
    public WashingMachine(String productId,String name, double mrp_price,String type)
    {
        super(productId,name,mrp_price,type);
    }
    public WashingMachine(String productId,String name, double mrp_price, int quantity, String type) {
		super(productId,name,mrp_price,quantity,type);
	}
    public boolean isDiscountAvailable()
    {
        return(super.discount>0);
    }
	public double getFinalPrice()
    {
        return(mrp_price-(super.discount*super.mrp_price/100));
    }
    public String helpbot()
    {
        return text;
    }
    
}