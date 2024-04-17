package Employees;

import javax.swing.*;

public class Driver {
    public static void main(String[] args) {
        Splash splash=new Splash(); 
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Close the splash screen
        splash.dispose();
        
        // Create the login window
        Login login = new Login();
        
        // Display the login window
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                login.setVisible(true);
            }
        });
        
        // Wait for the user to log in
        while (!login.isLoggedIn()) {
            try {
                Thread.sleep(1000); // Wait for 1 second before checking again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Once the user is logged in, close the login window and open the home window
        login.dispose();
        new Home();
    }
}


