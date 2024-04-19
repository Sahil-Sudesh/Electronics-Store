package Employees;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice cEmpId;
    JButton delete, back;
    JLabel lblName, lblPhone, lblEmail;

    RemoveEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblEmpId = new JLabel("Employee ID");
        lblEmpId.setBounds(50, 50, 100, 30);
        add(lblEmpId);

        cEmpId = new Choice();
        cEmpId.setBounds(200, 50, 150, 30);
        add(cEmpId);

        lblName = new JLabel("");
        lblName.setBounds(50, 100, 300, 30);
        add(lblName);

        lblPhone = new JLabel("");
        lblPhone.setBounds(50, 150, 300, 30);
        add(lblPhone);

        lblEmail = new JLabel("");
        lblEmail.setBounds(50, 200, 300, 30);
        add(lblEmail);

        try {
            Connec c = new Connec();
            String query = "SELECT * FROM employees";
            ResultSet rs = c.getStatement().executeQuery(query);
            while (rs.next()) {
                cEmpId.add(rs.getString("employee_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Connec c = new Connec();
                    String query = "SELECT * FROM employees WHERE employee_id = '" + cEmpId.getSelectedItem() + "'";
                    ResultSet rs = c.getStatement().executeQuery(query);
                    if (rs.next()) {
                        lblName.setText("Name: " + rs.getString("name"));
                        lblPhone.setText("Phone: " + rs.getString("phone"));
                        lblEmail.setText("Email: " + rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80, 250, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220, 250, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(400, 350);
        setLocation(500, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Connec c = new Connec();
                String query = "DELETE FROM employees WHERE employee_id = '" + cEmpId.getSelectedItem() + "'";
                c.getStatement().executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

}
