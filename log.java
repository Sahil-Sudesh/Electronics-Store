package Store;
import java.util.*;
public class log extends InventoryManagement{
    Double pc;
    public log(){
        this.pc=0;
    }

    public void generatelog(){
        try(FileWriter writer=new FileWriter("log.txt")){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter The Product Numbers Of All Products To Be Added To Inventory And Then Their Quantities");
            System.out.println("Enter 0 When Done Adding To Inventory");
            writer.write("--------------------------------------------------------- Log ---------------------------------------------------------\n");
            while(1==1){
                String s=sc.next();
                if(s.equals("0"))break;
                else{
                    if(InventoryManagement.getCount(s)==null){
                        System.out.println("Product Does Not Exist");
                    }
                    else{
                        if(s.charAt(0)=='1'){
                            System.out.println("How Many Air Conditioner "+getType(s)+"Are Being Added To Inventory");
                            int c=sc.nextInt();
                            writer.write("Air Conditioner "+InventoryManagement.getType(s)+"x"+c+":$"+InventoryManagement.getCost(s)+"x"+c+"=$"+InventoryManagement.getCost(s)*c+"\n");
                        }
                        else if(s.charAt(0)=='2'){
                            System.out.println("How Many Refrigerator "+getType(s)+"Are Being Added To Inventory");
                            int c=sc.nextInt();
                            writer.write("Refrigerator "+InventoryManagement.getType(s)+"x"+c+":$"+InventoryManagement.getCost(s)+"x"+c+"=$"+InventoryManagement.getCost(s)*c+"\n");
                        }
                        else if(s.charAt(0)=='3'){
                            System.out.println("How Many Television "+getType(s)+"Are Being Added To Inventory");
                            int c=sc.nextInt();
                            writer.write("Television "+InventoryManagement.getType(s)+"x"+c+":$"+InventoryManagement.getCost(s)+"x"+c+"=$"+InventoryManagement.getCost(s)*c+"\n");
                        }
                        else if(s.charAt(0)=='4'){
                            System.out.println("How Many Washing Machine "+getType(s)+"Are Being Added To Inventory");
                            int c=sc.nextInt();
                            writer.write("Washing Machine "+InventoryManagement.getType(s)+"x"+c+":$"+InventoryManagement.getCost(s)+"x"+c+"=$"+InventoryManagement.getCost(s)*c+"\n");
                        }
                        else{
                            System.out.println("How Many Dishwasher "+getType(s)+"Are Being Added To Inventory");
                            int c=sc.nextInt();
                            writer.write("Dishwasher "+InventoryManagement.getType(s)+"x"+c+":$"+InventoryManagement.getCost(s)+"x"+c+"=$"+InventoryManagement.getCost(s)*c+"\n");
                        }
                        InventoryManagement.increaseCount(s,c);
                        pc+=InventoryManagement.getCost(s)*c;
                    }
                }
            }
            writer.write("------------------------------------------------------------------------------------------------------------------------\n");
            writer.write("Total :$"+pc+"\n");
            writer.write("------------------------------------------------------------------------------------------------------------------------\n");
            writer.write("------------------------------------------------------------------------------------------------------------------------\n");
        } catch(IOException e){
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}