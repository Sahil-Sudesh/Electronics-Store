package EMS;
import java.util.*;

public class InventoryManagement 
{   Scanner sc=new Scanner(System.in);
    public InventoryManagement()
    {
        
    }
    static ArrayList<AirConditioner> acs=new ArrayList<AirConditioner>();
    static ArrayList<TV> TVS=new ArrayList<TV>();
    static ArrayList<Refrigerator> Refrigerators=new ArrayList<Refrigerator>();
    static ArrayList<Dishwasher> Dishwashers=new ArrayList<Dishwasher>();
    static ArrayList<WashingMachine> WashingMachines=new ArrayList<WashingMachine>();
    /*public boolean findProduct(String id)
    {   
        
            for(int i=0;i<acs.size();i++)
            {
                if(id.equals(acs.get(i).id))
                {
                    if(acs.get(i).quantity>0)
                    {
                        return true;
                    }
                }
            }   
            
        
        
        
            for(int i=0;i<Refrigerators.size();i++)
            {
                if(id.equals(Refrigerators.get(i).id))
                {
                    if(Refrigerators.get(i).quantity>0)
                    {
                        return true;
                    }
                }
            }
                
        
            for(int i=0;i<TVS.size();i++)
            {
                if(id.equals(TVS.get(i).id))
                {
                    if(TVS.get(i).quantity>0)
                    {
                        return true;
                    }
                }
            }
        
        
            for(int i=0;i<Dishwashers.size();i++)
            {
                if(id.equals(Dishwashers.get(i).id))
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
                if(id.equals(WashingMachines.get(i).id))
                {
                    if(WashingMachines.get(i).quantity>0)
                    {
                        return true;
                    }
                }
            }
        
        return false;
    }*/
    public static int findProduct(String s)
    {
        for(int i=0;i<acs.size();i++)
            {
                if(id.equals(acs.get(i).id))
                {
                    if(acs.get(i).quantity>0)
                    {
                        return i;
                    }
                }
            }   
            
        
        
        
            for(int i=0;i<Refrigerators.size();i++)
            {
                if(id.equals(Refrigerators.get(i).id))
                {
                    if(Refrigerators.get(i).quantity>0)
                    {
                        return i;
                    }
                }
            }
                
        
            for(int i=0;i<TVS.size();i++)
            {
                if(id.equals(TVS.get(i).id))
                {
                    if(TVS.get(i).quantity>0)
                    {
                        return i;
                    }
                }
            }
        
        
            for(int i=0;i<Dishwashers.size();i++)
            {
                if(id.equals(Dishwashers.get(i).id))
                {
                    if(Dishwashers.get(i).quantity>0)
                    {
                        return i;
                    }
                }
            }
    
          
            for(int i=0;i<WashingMachines.size();i++)
            {
                if(id.equals(WashingMachines.get(i).id))
                {
                    if(WashingMachines.get(i).quantity>0)
                    {
                        return i;
                    }
                }
            }
        
        return -1;
    }
    public static String types(String s)
    {
        for(int i=0;i<acs.size();i++)
            {
                if(id.equals(acs.get(i).id))
                {
                    return acs.get(i).type;
                }
            }   
            
        
        
        
            for(int i=0;i<Refrigerators.size();i++)
            {
                if(id.equals(Refrigerators.get(i).id))
                {
                    return Refrigerators.get(i).type;
                }
            }
                
        
            for(int i=0;i<TVS.size();i++)
            {
                if(id.equals(TVS.get(i).id))
                {
                    return TVS.get(i).type;
                }
            }
        
        
            for(int i=0;i<Dishwashers.size();i++)
            {
                if(id.equals(Dishwashers.get(i).id))
                {
                    return Dishwashers.get(i).type;
                }
            }
    
          
            for(int i=0;i<WashingMachines.size();i++)
            {
                if(id.equals(WashingMachines.get(i).id))
                {
                    return WashingMachines.get(i).type;
                }
            }
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