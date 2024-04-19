package Employees;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {
    
    JTextField tffname, tfemail, tfgrade;
    JLabel lbldob, lblempId;
    JButton add, back;
    String empId;
    
    UpdateEmployee(String empId) {
        this.empId = empId;
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tffname = new JTextField();
        tffname.setBounds(200, 100, 150, 30);
        add(tffname);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(400, 100, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(550, 100, 150, 30);
        add(tfemail);
        
        JLabel labelgrade = new JLabel("Grade");
        labelgrade.setBounds(50, 150, 150, 30);
        labelgrade.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelgrade);
        
        tfgrade = new JTextField();
        tfgrade.setBounds(200, 150, 150, 30);
        add(tfgrade);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(400, 150, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        lbldob = new JLabel();
        lbldob.setBounds(550, 150, 150, 30);
        add(lbldob);
        
        JLabel labelempId = new JLabel("Employee id");
        labelempId.setBounds(50, 200, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(200, 200, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        
        
        try {
            Connec c = new Connec();
            String query = "select * from employees where employee_id = ?";
            PreparedStatement pstmt = c.getConnection().prepareStatement(query);
            pstmt.setString(1, empId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                tffname.setText(rs.getString("name"));
                tfemail.setText(rs.getString("email"));
                tfgrade.setText(rs.getString("grade"));
                lbldob.setText(rs.getString("date_of_birth"));
                lblempId.setText(empId);
            } else {
                JOptionPane.showMessageDialog(null, "Employee ID not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(250, 250, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.WHITE);
        add.setForeground(Color.BLACK);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 250, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        add(back);
        
        setSize(900, 350);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tffname.getText();
            String email = tfemail.getText();
            String grade = tfgrade.getText();
            
            try {
                Connec conn = new Connec();
                String query = "update employees set name = ?, email = ?, grade = ? where employee_id = ?";
                PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, grade);
                pstmt.setString(4, empId);
                
                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Details updated successfully");
                    setVisible(false);
                    new Home();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update employee details");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

}
