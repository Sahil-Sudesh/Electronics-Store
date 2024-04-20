package Employees;
import EMS.*;
import Store.*;
import java.sql.*;

public class OrderProcess {
    private Connec connec;

    public OrderProcess(Connec connec) {
        this.connec = connec;
    }

    public void processOrders() {
        try {
        	
            Statement statement = connec.getStatement();
            
            String query = "SELECT COUNT(*) AS totalEmployees FROM employees";
            ResultSet resultSet = statement.executeQuery(query);
            
            int numberOfEmployees = 0;
            if (resultSet.next()) {
                numberOfEmployees = resultSet.getInt("totalEmployees");
            }
            

            Thread[] threads = new Thread[1];
            for (int i = 0; i < 1; i++) {
                final int index = i;
                threads[i] = new Thread(() -> {
                    boss bo = new boss();
                    bo.main();
                });
                threads[i].start();
            }
           
            for (Thread thread : threads) {
                thread.join();
            }
            
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
}
