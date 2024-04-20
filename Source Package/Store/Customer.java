package Store;
import java.util.*;
import EMS.InventoryManagement;
import EMS.ElectronicProduct;
import java.io.FileWriter;
import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.Date;
import EMS.InventoryManagement;
import EMS.ElectronicProduct;
import java.text.SimpleDateFormat;
import EMS.TV;
import EMS.AirConditioner;
import EMS.Refrigerator;
import EMS.Dishwasher;
import EMS.WashingMachine;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    	InventoryManagement.init();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Product ID Of All Products You Are Buying As Well As The Quantity");
        System.out.println("Enter 0 When Done Shopping");
        while (true) {
            String s = sc.nextLine();
            //String bin=sc.nextLine();
            
            if (s.equals("0")) break;
            else {  int n=InventoryManagement.findProduct(s);
                    String type=InventoryManagement.types(s);
                    ElectronicProduct ob=null;
                    

                    
                    if (InventoryManagement.findProduct(s)==-1) 
                    {
                        System.out.println("Product Incorrect/OutOfStock.");
                    } 
                    else 
                    {	
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
                    	
                    	
                    	
                    	
                        System.out.println("Enter Quantity");
                        int c = sc.nextInt();
                        if (c <= InventoryManagement.getProductQuantity(ob)) 
                        {
                            items.add(ob);
                            count.add(c);
                            switch(type)
                            {
                                case "AC":
                                InventoryManagement.decQuantity(InventoryManagement.acs.get(n), c);

                                break;
                                
                                case "TV":
                                InventoryManagement.decQuantity(InventoryManagement.TVS.get(n), c);

                                break;
                                case "DW":
                                InventoryManagement.decQuantity(InventoryManagement.Dishwashers.get(n), c);

                                break;
                                case "WM":
                                InventoryManagement.decQuantity(InventoryManagement.WashingMachines.get(n), c);

                                break;
                                case "RF":
                                InventoryManagement.decQuantity(InventoryManagement.Refrigerators.get(n), c);

                                break;
                                
                                
                                default:
                                break;
                    
                            }
                            break;






                            
                        } 
                        else 
                        {
                            
                            
                                System.out.println("Not Enough Stock Is Available");
                                System.out.println("Only " + InventoryManagement.getProductQuantity(ob) + " Units Are Available");
                            
                        }
                    }
                }
            }
            System.out.println("Thank You For Shopping!");
            bill bol=new bill(this);
            bol.generateBill();
        }
}