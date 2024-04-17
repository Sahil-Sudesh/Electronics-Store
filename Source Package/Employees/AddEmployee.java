package Employees;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener {

    Random random = new Random();
    int employeeId = random.nextInt(999999);

    JTextField nameField, emailField;
    JDateChooser dobChooser;
    JComboBox<Integer> gradeComboBox;
    JLabel employeeIdLabel;
    JButton addButton, backButton;

    public AddEmployee() {
        setTitle("Add Employee Detail");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobChooser = new JDateChooser();
        JLabel gradeLabel = new JLabel("Grade:");
        Integer[] grades = {1, 2, 3, 4, 5};
        gradeComboBox = new JComboBox<>(grades);

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(dobLabel);
        formPanel.add(dobChooser);
        formPanel.add(gradeLabel);
        formPanel.add(gradeComboBox);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        buttonPanel.add(addButton);
        buttonPanel.add(backButton);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            Date dob = dobChooser.getDate();
            int grade = (Integer) gradeComboBox.getSelectedItem();
            
            switch(grade) {
            	case 1:
            		Employee employee1 = new Engineer(name, email, dob, employeeId, grade);
                    employee1.addToDatabase();
            	case 2:
            		Employee employee2 = new Manager(name, email, dob, employeeId, grade);
                    employee2.addToDatabase();
            	case 3:
            		Employee employee3 = new Salesman(name, email, dob, employeeId, grade);
                    employee3.addToDatabase();
            	case 4:
            		Employee employee4 = new Maintenance(name, email, dob, employeeId, grade);
                    employee4.addToDatabase();
            	case 5:
            		Employee employee5 = new CleaningStaff(name, email, dob, employeeId, grade);
                    employee5.addToDatabase();
            	
            	default:
            }
            
            JOptionPane.showMessageDialog(this, "Employee details added successfully.");
            clearFields();
        } else if (e.getSource() == backButton) {
            setVisible(false);
        }
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        dobChooser.setDate(null);
        gradeComboBox.setSelectedIndex(0);
    }
}
