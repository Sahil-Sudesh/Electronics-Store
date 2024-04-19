package Employees;

import javax.swing.*;

public class Driver {
    public static void main(String[] args) {
        Splash splash=new Splash(); 
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
       
        splash.dispose();
        
       
        Login login = new Login();
        
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                login.setVisible(true);
            }
        });
        
        
        while (!login.isLoggedIn()) {
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Once the user is logged in, close the login window and open the home window
        login.dispose();
        new Home();
    }
}


