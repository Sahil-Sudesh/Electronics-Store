package Store;
import EMS.ElectronicProduct;
import EMS.AirConditioner;
import EMS.TV;
import EMS.DishWasher;
import EMS.Refrigerator;
import EMS.WashingMachine;
import java.util.Scanner;
public class boss extends log 
{   public static String productId;
	public static String name;
	public static double mrp_price;
	public static double costprice;
	public static double discount;
	public static int quantity=0;
	public static String type="";
    public static void main()
    {   Scanner sc=new Scanner(System.in);
        System.out.println("Enter Details Of The Product:");
        System.out.println("Enter Product Name:");
        name=sc.nextLine();
        String bin=sc.nextLine();
        System.out.println("Enter Product ID");
        productId=sc.nextLine();
        bin=sc.nextLine();
        System.out.println("Enter mrp_price");
        mrp_price=sc.nextDouble();
        System.out.println("Enter Cost Price");
        costprice=sc.nextDouble();
        System.out.println("Enter Discount");
        discount=sc.nextDouble();
        System.out.println("Enter Quantity");
        quantity=sc.nextInt();
        while(type!="AC"||type!="DW"||type!="RF"||type!="TV"||type!="WM")
        {
            System.out.println("Enter the Type");
            type=sc.nextLine();
            bin=sc.nextLine();
        }
        if(quantity==0)
        {
           switch(type)
            {
                case "AC":
                AirConditioner a=new AirConditioner(productId,name,mrp_price,type); 
                InventoryManagement.addProduct(a);
                break;
            
                case "TV":
                TV b=new TV(productId,name,mrp_price,type);
                InventoryManagement.addProduct(b); 
                break;
                case "DW":
                Dishwasher c=new Dishwasher(productId,name,mrp_price,type);
                InventoryManagement.addProduct(c); 

                break;
                case "WM":
                WashingMachine d=new WashingMachine(productId,name,mrp_price,type);
                InventoryManagement.addProduct(d); 

                break;
                case "RF":
                Refrigerator e=new Refrigerator(productId,name,mrp_price,type);
                InventoryManagement.addProduct(e); 

                break;
            
            
                default:
                break;
            }
        }
        else
        {
            switch(type)
            {
                case "AC":
                AirConditioner a=new AirConditioner(productId,name,mrp_price,quantity,type); 
                InventoryManagement.addProduct(a);
                break;
            
                case "TV":
                TV b=new TV(productId,name,mrp_price,quantity,type);
                InventoryManagement.addProduct(b); 
                break;
                case "DW":
                Dishwasher c=new Dishwasher(productId,name,mrp_price,quantity,type);
                InventoryManagement.addProduct(c); 

                break;
                case "WM":
                WashingMachine d=new WashingMachine(productId,name,mrp_price,quantity,type);
                InventoryManagement.addProduct(d); 

                break;
                case "RF":
                Refrigerator e=new Refrigerator(productId,name,mrp_price,quantity,type);
                InventoryManagement.addProduct(e); 

                break;
            
            
                default:
                break;
            }
        }


    }



















}
