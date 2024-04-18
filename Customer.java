package Store;
import java.util.*;
public class Customer extends InventoryManagement{
    ArrayList<String> items;
    ArrayList<Integer> count;
    public Customer(){
        this.items=new ArrayList<>();
        this.count=new ArrayList<>();
    }
    
    public void buy(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter The Product ID Of All Products You Are Buying As Well As The Quantity");
        System.out.println("Enter 0 When Done Shopping");
        while(1==1){
            String s=sc.next();
            if(s.equals("0"))break;
            else{
                if(InventoryManagement.getCount(s)==null){
                    System.out.println("Product Does Not Exist");
                }
                else{
                    System.out.println("Enter Quantity");
                    int c=sc.nextInt();
                    if(c<=InventoryManagement.getCount(s)){
                        item.add(s);
                        count.add(c);
                        InventoryManagement.decreaseCount(s,c);
                    }
                    else{
                        if(InventoryManagement.getCount(s)==0)System.out.println("Product Is Out Of Stock");
                        else{
                            System.out.println("Not Enough Stock Is Available");
                            System.out.println("Only"+InventoryManagement.getCount(s)+"Units Are Available");
                        }
                    }
            }
        }
        System.out.println("Thank You For Shopping!");
    }
}
}