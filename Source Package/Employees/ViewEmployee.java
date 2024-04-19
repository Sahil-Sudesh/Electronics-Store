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
            Connec connection = new Connec();
            ResultSet resultSet = connection.getStatement().executeQuery("SELECT * FROM employees");
            while (resultSet.next()) {
                employeeIdChoice.add(resultSet.getString("employee_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            Connec connection = new Connec();
            ResultSet resultSet = connection.getStatement().executeQuery("SELECT * FROM employees");
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

        backButton = new JButton("Back");
        backButton.setBounds(220, 70, 80, 20);
        backButton.addActionListener(this);
        add(backButton);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchButton) {
            String query = "SELECT * FROM employees WHERE employee_id = '" + employeeIdChoice.getSelectedItem() + "'";
            try {
                Connec connection = new Connec();
                ResultSet resultSet = connection.getStatement().executeQuery(query);
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
        } else if (ae.getSource() == backButton) {
            setVisible(false);
            new Home();
        } 
    }

}
