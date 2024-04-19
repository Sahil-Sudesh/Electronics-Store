package Store;

import java.io.*;
import java.util.Scanner;
import java.util.Date;

public class log extends InventoryManagement {
    Double pc;

    public Log() {
        this.pc = 0.0;
    }

    public void generateLog() {
        Date date=new Date();
        SimpleDateFormat d=new SimpleDateFormat("yyyyMMdd_HHmmss");
        String name="bill_"+dateFormat.format(date)+".txt";
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
            if (InventoryManagement.getCount(s) == null) {
                System.out.println("Product Does Not Exist");
            } else 
            {
                    int n=InventoryManagement.findProduct(s);
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
                            switch (type) {
                                case "AC":
                                    writer.write("Air Conditioner " + productType + " x" + c + ": $" +((AirConditioner) (ob)).getCostPrice + " x" + c + " = $" + ((AirConditioner) (ob)).getCostPrice * c + "\n");
                                    break;
                                case "RF":
                                    writer.write("Refrigerator " + productType + " x" + c + ": $" + ((Refrigerator) (ob)).getCostPrice + " x" + c + " = $" + ((Refrigerator) (ob)).getCostPrice * c + "\n");
                                    break;
                                case "TV":
                                    writer.write("Television " + productType + " x" + c + ": $" + ((TV) (ob)).getCostPrice + " x" + c + " = $" + ((TV) (ob)).getCostPrice * c + "\n");
                                    break;
                                case "WM":
                                    writer.write("Washing Machine " + productType + " x" + c + ": $" + ((WashingMachine) (ob)).getCostPrice + " x" + c + " = $" + ((WashingMachine) (ob)).getCostPrice * c + "\n");
                                    break;
                                case "DW":
                                    writer.write("Dishwasher " + productType + " x" + c + ": $" + ((Dishwasher) (ob)).getCostPrice + " x" + c + " = $" + ((Dishwasher) (ob)).getCostPrice * c + "\n");
                                    break;
                                default:
                                break;
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
                InventoryManagement.increaseQuantity(ob, c);
                pc += InventoryManagement.getCostPrice(ob) * c;
            }
        }
    }
}
}
