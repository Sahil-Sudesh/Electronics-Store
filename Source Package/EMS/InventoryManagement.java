package EMS;
import java.util.*;

public class InventoryManagement 
{   public static ArrayList<AirConditioner> acs=new ArrayList<AirConditioner>();
public static ArrayList<TV> TVS=new ArrayList<TV>();
public static ArrayList<Refrigerator> Refrigerators=new ArrayList<Refrigerator>();
public static ArrayList<Dishwasher> Dishwashers=new ArrayList<Dishwasher>();
public static ArrayList<WashingMachine> WashingMachines=new ArrayList<WashingMachine>();
	//AirConditioner al=new AirConditioner("123","LG",3000,2000,"AC");
	
	Scanner sc=new Scanner(System.in);
    public InventoryManagement()
    {	acs=new ArrayList<AirConditioner>();
    	TVS=new ArrayList<TV>();
    	Refrigerators=new ArrayList<Refrigerator>();
    	Dishwashers=new ArrayList<Dishwasher>();
    	WashingMachines=new ArrayList<WashingMachine>();
    	//AirConditioner al=new AirConditioner("123","LG",3000,2000,"AC");
    	//acs.add(al);
    }
    public static void init()
    {	AirConditioner al=new AirConditioner("123","LG",3000,10,2000,"AC");
    	acs.add(al);
    }
    
    
    /*public boolean findProduct(String productId)
    {   
        
            for(int i=0;i<acs.size();i++)
            {
                if(productId.equals(acs.get(i).productId))
                {
                    if(acs.get(i).quantity>0)
                    {
                        return true;
                    }
                }
            }   
            
        
        
        
            for(int i=0;i<Refrigerators.size();i++)
            {
                if(productId.equals(Refrigerators.get(i).productId))
                {
                    if(Refrigerators.get(i).quantity>0)
                    {
                        return true;
                    }
                }
            }
                
        
            for(int i=0;i<TVS.size();i++)
            {
                if(productId.equals(TVS.get(i).productId))
                {
                    if(TVS.get(i).quantity>0)
                    {
                        return true;
                    }
                }
            }
        
        
            for(int i=0;i<Dishwashers.size();i++)
            {
                if(productId.equals(Dishwashers.get(i).productId))
                {
                    if(Dishwashers.get(i).quantity>0)
                    {
                        return true;
                    }
                }
            }
    }
          
            for(int i=0;i<WashingMachines.size();i++)
            {
                if(productId.equals(WashingMachines.get(i).productId))
                {
                    if(WashingMachines.get(i).quantity>0)
                    {
                        return true;
                    }
                }
            }
        
        return false;
    }*/
    public static int findProduct(String productId)
    {
        for(int i=0;i<acs.size();i++)
            {
                if(productId.equals(acs.get(i).productId))
                {
                    if(acs.get(i).quantity>0)
                    {
                        return i;
                    }
                }
            }   
            
        
        
        
            for(int i=0;i<Refrigerators.size();i++)
            {
                if(productId.equals(Refrigerators.get(i).productId))
                {
                    if(Refrigerators.get(i).quantity>0)
                    {
                        return i;
                    }
                }
            }
                
        
            for(int i=0;i<TVS.size();i++)
            {
                if(productId.equals(TVS.get(i).productId))
                {
                    if(TVS.get(i).quantity>0)
                    {
                        return i;
                    }
                }
            }
        
        
            for(int i=0;i<Dishwashers.size();i++)
            {
                if(productId.equals(Dishwashers.get(i).productId))
                {
                    if(Dishwashers.get(i).quantity>0)
                    {
                        return i;
                    }
                }
            }
    
          
            for(int i=0;i<WashingMachines.size();i++)
            {
                if(productId.equals(WashingMachines.get(i).productId))
                {
                    if(WashingMachines.get(i).quantity>0)
                    {
                        return i;
                    }
                }
            }
        
        return 0;
    }
    public static String types(String productId)
    {
        for(int i=0;i<acs.size();i++)
            {
                if(productId.equals(acs.get(i).productId))
                {
                    return acs.get(i).type;
                }
            }   
            
        
        
        
            for(int i=0;i<Refrigerators.size();i++)
            {
                if(productId.equals(Refrigerators.get(i).productId))
                {
                    return Refrigerators.get(i).type;
                }
            }
                
        
            for(int i=0;i<TVS.size();i++)
            {
                if(productId.equals(TVS.get(i).productId))
                {
                    return TVS.get(i).type;
                }
            }
        
        
            for(int i=0;i<Dishwashers.size();i++)
            {
                if(productId.equals(Dishwashers.get(i).productId))
                {
                    return Dishwashers.get(i).type;
                }
            }
    
          
            for(int i=0;i<WashingMachines.size();i++)
            {
                if(productId.equals(WashingMachines.get(i).productId))
                {
                    return WashingMachines.get(i).type;
                }
            }
            return "AC";
            //return null;
    }
    
    

    
    public static void addProduct(ElectronicProduct ob)
    {
        if(ob instanceof AirConditioner)
        acs.add((AirConditioner)ob);
        if(ob instanceof Refrigerator)
        Refrigerators.add((Refrigerator)ob);
        if(ob instanceof TV)
        TVS.add((TV)ob);
        if(ob instanceof Dishwasher)
        Dishwashers.add((Dishwasher)ob);
        if(ob instanceof WashingMachine)
        WashingMachines.add((WashingMachine)ob);
        

    }
    public static void remProduct(ElectronicProduct ob)
    {
        if(ob instanceof AirConditioner)
        acs.remove((AirConditioner)ob);
        if(ob instanceof Refrigerator)
        Refrigerators.remove((Refrigerator)ob);
        if(ob instanceof TV)
        TVS.remove((TV)ob);
        if(ob instanceof Dishwasher)
        Dishwashers.remove((Dishwasher)ob);
        if(ob instanceof WashingMachine)
        WashingMachines.remove((WashingMachine)ob);
    }

    public static void addProduct(ElectronicProduct... o)
    {   for(ElectronicProduct ob:o)
        {
            if(ob instanceof AirConditioner)
            acs.add((AirConditioner)ob);
            if(ob instanceof Refrigerator)
            Refrigerators.add((Refrigerator)ob);
            if(ob instanceof TV)
            TVS.add((TV)ob);
            if(ob instanceof Dishwasher)
            Dishwashers.add((Dishwasher)ob);
            if(ob instanceof WashingMachine)
            WashingMachines.add((WashingMachine)ob);
        }

    }
    public static void remProduct(ElectronicProduct... o)
    {   for(ElectronicProduct ob:o)
        {
            if(ob instanceof AirConditioner)
            acs.remove((AirConditioner)ob);
            if(ob instanceof Refrigerator)
            Refrigerators.remove((Refrigerator)ob);
            if(ob instanceof TV)
            TVS.remove((TV)ob);
            if(ob instanceof Dishwasher)
            Dishwashers.remove((Dishwasher)ob);
            if(ob instanceof WashingMachine)
            WashingMachines.remove((WashingMachine)ob);
        }
    }
    public static int getProductQuantity(ElectronicProduct ob)
    {
        return ob.quantity;
    }
    public static void incQuantity(ElectronicProduct ob,int quantitychange)
    {
        ob.updateQauntity(quantitychange);
    }
    public static void decQuantity(ElectronicProduct ob,int quantitychange)
    {
        ob.updateQauntity(-quantitychange);
    }
    

}