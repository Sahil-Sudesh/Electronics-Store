package Store;

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
public class log extends InventoryManagement {
    Double pc;

    public log() {
        this.pc = 0.0;
    }

    public void generateLog() {
        Date date=new Date();
        SimpleDateFormat d=new SimpleDateFormat("yyyyMMdd_HHmmss");
        String name="bill_"+d.format(date)+".txt";
        try (FileWriter writer = new FileWriter(name)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter The Product Numbers Of All Products To Be Added To Inventory And Then Their Quantities");
            System.out.println("Enter 0 When Done Adding To Inventory");
            writer.write("--------------------------------------------------------- Log ---------------------------------------------------------\n");
            while (true) {
                String s = sc.nextLine();
                String bin = sc.nextLine();
                if (s.equals("0")) break;
                else {
                    InventoryTransaction transaction = new InventoryTransaction();
                    transaction.processTransaction(s, writer, sc);
                }
            }
            writer.write("------------------------------------------------------------------------------------------------------------------------\n");
            writer.write("Total :$" + pc + "\n");
            writer.write("------------------------------------------------------------------------------------------------------------------------\n");
            writer.write("------------------------------------------------------------------------------------------------------------------------\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    class InventoryTransaction {













        void processTransaction(String s, FileWriter writer, Scanner sc) throws IOException {
           
            
                    int n=InventoryManagement.findProduct(s);
                    String productType=InventoryManagement.types(s);
                    ElectronicProduct ob=null;
                    System.out.println("How Many " + productType + " are Being Added To Inventory");
                    int c = sc.nextInt();
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
                                    writer.write("Air Conditioner " + productType + " x" + c + ": $" +ob.getCostPrice() + " x" + c + " = $" + ob.getCostPrice() * c + "\n");
                                    break;
                                case "RF":
                                    writer.write("Refrigerator " + productType + " x" + c + ": $" + ob.getCostPrice() + " x" + c + " = $" + ob.getCostPrice() * c + "\n");
                                    break;
                                case "TV":
                                    writer.write("Television " + productType + " x" + c + ": $" + ob.getCostPrice() + " x" + c + " = $" + ob.getCostPrice() * c + "\n");
                                    break;
                                case "WM":
                                    writer.write("Washing Machine " + productType + " x" + c + ": $" + ob.getCostPrice() + " x" + c + " = $" + ob.getCostPrice() * c + "\n");
                                    break;
                                case "DW":
                                    writer.write("Dishwasher " + productType + " x" + c + ": $" + ob.getCostPrice() + " x" + c + " = $" + ob.getCostPrice() * c + "\n");
                                    break;
                                default:
                                break;
                                }
                /*//char category = s.charAt(0);
                String productType = getType(s);
                System.out.println("How Many " + productType + " are Being Added To Inventory");
                int c = sc.nextInt();

                switch (category) {
                    case '1':
                        writer.write("Air Conditioner " + productType + " x" + c + ": $" + InventoryManagement.getCost(s) + " x" + c + " = $" + InventoryManagement.getCost(s) * c + "\n");
                        break;
                    case '2':
                        writer.write("Refrigerator " + productType + " x" + c + ": $" + InventoryManagement.getCost(s) + " x" + c + " = $" + InventoryManagement.getCost(s) * c + "\n");
                        break;
                    case '3':
                        writer.write("Television " + productType + " x" + c + ": $" + InventoryManagement.getCost(s) + " x" + c + " = $" + InventoryManagement.getCost(s) * c + "\n");
                        break;
                    case '4':
                        writer.write("Washing Machine " + productType + " x" + c + ": $" + InventoryManagement.getCost(s) + " x" + c + " = $" + InventoryManagement.getCost(s) * c + "\n");
                        break;
                    default:
                        writer.write("Dishwasher " + productType + " x" + c + ": $" + InventoryManagement.getCost(s) + " x" + c + " = $" + InventoryManagement.getCost(s) * c + "\n");
                        break;
                }*/
                InventoryManagement.incQuantity(ob, c);
                pc += ob.getCostPrice() * c;
            }
        }
    }