package Employees;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public abstract class Employee {
 private String name;
 private String email;
 private Date dateOfBirth;
 private int employeeId;
 private int grade;
 private String workPriority;

 public Employee(String name, String email, Date dateOfBirth, int employeeId,int grade) {
     this.name = name;
     this.email = email;
     this.dateOfBirth = dateOfBirth;
     this.employeeId = employeeId;
     this.grade=grade;
 }

 public String getName() {
     return name;
 }
 public int getGrade() {
	 return grade;
 }
public void setPriority(String priority) {
	this.workPriority=priority;
}
 public void setName(String name) {
     this.name = name;
 }

 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 public Date getDateOfBirth() {
     return dateOfBirth;
 }

 public void setDateOfBirth(Date dateOfBirth) {
     this.dateOfBirth = dateOfBirth;
 }

 public int getEmployeeId() {
     return employeeId;
 }

 public void setEmployeeId(int employeeId) {
     this.employeeId = employeeId;
 }

 // Abstract method for additional behavior
 public abstract void work();

 // toString() method to display employee information
 @Override
 public String toString() {
     return "Employee ID: " + employeeId + "\n" +
             "Name: " + name + "\n" +
             "Email: " + email + "\n" +
             "Date of Birth: " + dateOfBirth;
 }
 public void addToDatabase() {
     try {
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "mysqlsahil123");
         PreparedStatement statement = connection.prepareStatement("INSERT INTO employees (name, email, date_of_birth, employee_id, grade) VALUES (?, ?, ?, ?, ?)");
         statement.setString(1, name);
         statement.setString(2, email);
         statement.setDate(3, new java.sql.Date(dateOfBirth.getTime()));
         statement.setInt(4, employeeId);
         statement.setInt(5, grade);
         statement.executeUpdate();
         System.out.println("Employee details added to the database successfully.");
         connection.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
}
