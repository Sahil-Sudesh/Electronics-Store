package Employees;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    private JTextField tfusername;
    private JPasswordField tfpassword;
    private JButton loginButton;
    private Connec dbConnection;
    private boolean loggedIn; // Track login status

    public Login() {
        dbConnection = new Connec();
        loggedIn = false; // Set initial login status to false
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        
        loginButton = new JButton("LOGIN");
        loginButton.setBounds(150, 140, 150, 30);
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.BLACK);
        loginButton.addActionListener(this);
        add(loginButton);
        
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public boolean isLoggedIn() {
        return loggedIn; // Return login status
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            String password = new String(tfpassword.getPassword());
            
            String query = "SELECT * FROM login WHERE username = ? AND password = ?";
            PreparedStatement pst = dbConnection.getConnection().prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login successful!");
                loggedIn = true; // Update login status
                System.out.println("nigga");
                dispose(); // Close the login window
                new Home(); // Open the home window
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while attempting to log in.");
        }
    }
}
