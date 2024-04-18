package Store;
public class bill extends InventoryManagement{
    Customer customer;
    Double total;
    public bill(Customer customer){
        this.customer=customer;
        this.total=0;
    }

    public void generatebill(){
        try(FileWriter writer=new FileWriter("bill.txt")){
            writer.write("--------------------------------------------------------- Bill ---------------------------------------------------------\n");
            while(customer.items.size()>0){
                String s=customer.items.get(0);
                int c=customer.count.get(0);
                if(s.charAt(0)=='1'){
                    writer.write("Air Conditioner "+InventoryManagement.getType(s)+"x"+c+":$"+InventoryManagement.getCost(s)+"x"+c+"=$"+InventoryManagement.getCost(s)*c+"\n");
                }
                else if(s.charAt(0)=='2'){
                    writer.write("Refrigerator "+InventoryManagement.getType(s)+"x"+c+":$"+InventoryManagement.getCost(s)+"x"+c+"=$"+InventoryManagement.getCost(s)*c+"\n");
                }
                else if(s.charAt(0)=='3'){
                    writer.write("Television "+InventoryManagement.getType(s)+"x"+c+":$"+InventoryManagement.getCost(s)+"x"+c+"=$"+InventoryManagement.getCost(s)*c+"\n");
                }
                else if(s.charAt(0)=='4'){
                    writer.write("Washing Machine "+InventoryManagement.getType(s)+"x"+c+":$"+InventoryManagement.getCost(s)+"x"+c+"=$"+InventoryManagement.getCost(s)*c+"\n");
                }
                else{
                    writer.write("Dishwasher "+InventoryManagement.getType(s)+"x"+c+":$"+InventoryManagement.getCost(s)+"x"+c+"=$"+InventoryManagement.getCost(s)*c+"\n");
                }
                total+=InventoryManagement.getCost(s)*c;
            }
            writer.write("------------------------------------------------------------------------------------------------------------------------\n");
            writer.write("Total :$"+total);
        } catch(IOException e){
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

}