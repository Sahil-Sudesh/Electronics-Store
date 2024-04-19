package Store;
import java.util.*;
import EMS.InventoryManagement;
import EMS.ElectronicProduct;

public class Customer extends InventoryManagement {
    //ArrayList<String> items;
    ArrayList<ElectronicProduct> items=new ArrayList<ElectronicProduct>();
    ArrayList<Integer> count;

    public Customer() {
        //this.items = new ArrayList<>();
        this.count = new ArrayList<>();
    }

    public void buy() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Product ID Of All Products You Are Buying As Well As The Quantity");
        System.out.println("Enter 0 When Done Shopping");
        while (true) {
            String s = sc.nextLine();
            Strinf bin=sc.nextLine();
            
            if (s.equals("0")) break;
            else {  int n=InventoryManagement.findProduct(s);
                    String type=InventoryManagement.types(s);
                    ElectronicProduct ob;
                    switch(type)
                            {
                                case "AC":
                                ob=(ElectronicProduct)InventoryManagement.acs.get(n);

                                break;
                                
                                case "TV":
                                ob=(ElectronicProduct)InventoryManagement.TVS.get(n);

                                break;
                                case "DW":
                                ob=(ElectronicProduct)InventoryManagement.Dishwashers.get(n);

                                break;
                                case "WM":
                                ob=(ElectronicProduct)InventoryManagement.WashingMachines.get(n);

                                break;
                                case "RF":
                                ob=(ElectronicProduct)InventoryManagement.Refrigerators.get(n);

                                break;
                                
                                
                                default:
                                break;
                    
                            }

                    
                    if (InventoryManagement.findProduct(s)==-1) 
                    {
                        System.out.println("Product Incorrect/OutOfStock.");
                    } 
                    else 
                    {
                        System.out.println("Enter Quantity");
                        int c = sc.nextInt();
                        if (c <= InventoryManagement.getQuantity(ob)) 
                        {
                            items.add(s);
                            count.add(c);
                            switch(type)
                            {
                                case "AC":
                                InventoryManagement.decQuantity(InventoryManagement.acs(n), c);

                                break;
                                
                                case "TV":
                                InventoryManagement.decQuantity(InventoryManagement.TVS(n), c);

                                break;
                                case "DW":
                                InventoryManagement.decQuantity(InventoryManagement.Dishwashers(n), c);

                                break;
                                case "WM":
                                InventoryManagement.decQuantity(InventoryManagement.WashingMachines(n), c);

                                break;
                                case "RF":
                                InventoryManagement.decQuantity(InventoryManagement.Refrigerators(n), c);

                                break;
                                
                                
                                default:
                                break;
                    
                            }






                            
                        } 
                        else 
                        {
                            
                            
                                System.out.println("Not Enough Stock Is Available");
                                System.out.println("Only " + InventoryManagement.getQuantity(ob) + " Units Are Available");
                            
                        }
                    }
                }
            }
            System.out.println("Thank You For Shopping!");
            bill.generateBill();
        }
}
