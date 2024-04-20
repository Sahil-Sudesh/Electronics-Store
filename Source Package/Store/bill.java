package Store;

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
public class bill extends InventoryManagement {
    Customer customer;
    Double total;

    public bill(Customer customer) {
        this.customer = customer;
        this.total = 0.0;
    }

    public void generateBill() {
        Date date=new Date();
        SimpleDateFormat d=new SimpleDateFormat("yyyyMMdd_HHmmss");
        String name="bill_"+d.format(date)+".txt";
        try (FileWriter writer = new FileWriter(name)) {
            writer.write("--------------------------------------------------------- Bill ---------------------------------------------------------\n");
            while (customer.items.size() > 0) {
                String s = customer.items.get(0).productId;
                int c = customer.count.get(0);
            //    char category = s.charAt(0);
                //String productType = types(s);
                int n=InventoryManagement.findProduct(s);
                    String productType=InventoryManagement.types(s);
                    ElectronicProduct ob=null;
                    switch(productType)
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























                switch (productType) {
                    case "AC":
                        writer.write("Air Conditioner " + productType + " x" + c + ": $" +((AirConditioner) (ob)).getFinalPrice(ob.isDiscountAvailable()) + " x" + c + " = $" + ((AirConditioner) (ob)).getFinalPrice(ob.isDiscountAvailable()) * c + "\n");
                        break;
                    case "RF":
                        writer.write("Refrigerator " + productType + " x" + c + ": $" + ((Refrigerator) (ob)).getFinalPrice(ob.isDiscountAvailable()) + " x" + c + " = $" + ((Refrigerator) (ob)).getFinalPrice(ob.isDiscountAvailable()) * c + "\n");
                        break;
                    case "TV":
                        writer.write("Television " + productType + " x" + c + ": $" + ((TV) (ob)).getFinalPrice(ob.isDiscountAvailable()) + " x" + c + " = $" + ((TV) (ob)).getFinalPrice(ob.isDiscountAvailable()) * c + "\n");
                        break;
                    case "WM":
                        writer.write("Washing Machine " + productType + " x" + c + ": $" + ((WashingMachine) (ob)).getFinalPrice(ob.isDiscountAvailable()) + " x" + c + " = $" + ((WashingMachine) (ob)).getFinalPrice(ob.isDiscountAvailable()) * c + "\n");
                        break;
                    case "DW":
                        writer.write("Dishwasher " + productType + " x" + c + ": $" + ((Dishwasher) (ob)).getFinalPrice(ob.isDiscountAvailable()) + " x" + c + " = $" + ((Dishwasher) (ob)).getFinalPrice(ob.isDiscountAvailable()) * c + "\n");
                        break;
                    default:
                    break;
                }
                switch (productType) {
                    case "AC":
                        total += ((AirConditioner) (ob)).getFinalPrice(ob.isDiscountAvailable()) * c;
                        break;
                    case "RF":
                        total += ((AirConditioner) (ob)).getFinalPrice(ob.isDiscountAvailable()) * c;
                        break;
                    case "TV":
                        total += ((TV) (ob)).getFinalPrice(ob.isDiscountAvailable()) * c;
                        break;
                    case "WM":
                        total += ((WashingMachine) (ob)).getFinalPrice(ob.isDiscountAvailable()) * c;
                        break;
                    case "DW":
                        total += ((Dishwasher) (ob)).getFinalPrice(ob.isDiscountAvailable()) * c;
                        break;
                    default:
                    break;
                }
                
                customer.items.remove(0);
                customer.count.remove(0);
            }
            writer.write("------------------------------------------------------------------------------------------------------------------------\n");
            writer.write("Total :$" + total);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}