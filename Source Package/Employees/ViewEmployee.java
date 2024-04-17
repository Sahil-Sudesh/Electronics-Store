package Employees;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener {

    JTable table;
    Choice employeeIdChoice;
    JButton searchButton, printButton, updateButton, backButton;

    public ViewEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchLabel = new JLabel("Search by Employee ID");
        searchLabel.setBounds(20, 20, 150, 20);
        add(searchLabel);

        employeeIdChoice = new Choice();
        employeeIdChoice.setBounds(180, 20, 150, 20);
        add(employeeIdChoice);

        try {
            Connection connection = new Connection();
            ResultSet resultSet = connection.s.executeQuery("SELECT * FROM employee");
            while (resultSet.next()) {
                employeeIdChoice.add(resultSet.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            Conn connection = new Conn();
            ResultSet resultSet = connection.s.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 100, 900, 600);
        add(jScrollPane);

        searchButton = new JButton("Search");
        searchButton.setBounds(20, 70, 80, 20);
        searchButton.addActionListener(this);
        add(searchButton);

        printButton = new JButton("Print");
        printButton.setBounds(120, 70, 80, 20);
        printButton.addActionListener(this);
        add(printButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(220, 70, 80, 20);
        updateButton.addActionListener(this);
        add(updateButton);

        backButton = new JButton("Back");
        backButton.setBounds(320, 70, 80, 20);
        backButton.addActionListener(this);
        add(backButton);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchButton) {
            String query = "SELECT * FROM employee WHERE empId = '" + employeeIdChoice.getSelectedItem() + "'";
            try {
                Conn connection = new Conn();
                ResultSet resultSet = connection.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == printButton) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == updateButton) {
            setVisible(false);
            new UpdateEmployee(employeeIdChoice.getSelectedItem());
        } else if (ae.getSource() == backButton) {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployees();
    }
}

