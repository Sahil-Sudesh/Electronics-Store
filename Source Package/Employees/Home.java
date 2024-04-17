package Employees;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JButton addEmployeeButton, viewEmployeeButton, updateEmployeeButton, removeEmployeeButton;
    
    Home() {
        setTitle("Employee Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        // Add Employee button
        addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.setBounds(50, 50, 200, 30);
        addEmployeeButton.addActionListener(this);
        add(addEmployeeButton);

        // View Employee button
        viewEmployeeButton = new JButton("View Employees");
        viewEmployeeButton.setBounds(50, 100, 200, 30);
        viewEmployeeButton.addActionListener(this);
        add(viewEmployeeButton);

        // Update Employee button
        updateEmployeeButton = new JButton("Update Employee");
        updateEmployeeButton.setBounds(50, 150, 200, 30);
        updateEmployeeButton.addActionListener(this);
        add(updateEmployeeButton);

        // Remove Employee button
        removeEmployeeButton = new JButton("Remove Employee");
        removeEmployeeButton.setBounds(50, 200, 200, 30);
        removeEmployeeButton.addActionListener(this);
        add(removeEmployeeButton);

        // Set background image
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("home.jpg"));
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        add(backgroundLabel);

        setSize(backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addEmployeeButton) {
            new AddEmployee();
            
        } else if (ae.getSource() == viewEmployeeButton) {
            new ViewEmployee();
        } else if (ae.getSource() == updateEmployeeButton) {
            new UpdateEmployee();
        } else if (ae.getSource() == removeEmployeeButton) {
            new RemoveEmployee();
        }
    }
}
