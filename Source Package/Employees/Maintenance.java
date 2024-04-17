package Employees;

import java.util.Date;

public class Maintenance extends Employee implements Payable {
    private double baseSalary;
    private double bonus;
    private double allowance;

    public Maintenance(String name, String email, Date dateOfBirth, int employeeId, int grade) {
        super(name, email, dateOfBirth, employeeId, grade);
    }

    // Implementing the calculateSalary method from the Payable interface
    @Override
    public double calculateSalary() {
   	 switch (getGrade()) {
   	 
        case 1:
            baseSalary=100000;
            bonus=50000;
            allowance=25000;
            
        case 2:
       	 baseSalary=60000;
            bonus=30000;
            allowance=15000;
        case 3:
       	 baseSalary=50000;
            bonus=25000;
            allowance=12500;
        case 4:
       	 baseSalary=40000;
            bonus=20000;
            allowance=10000;
        case 5:
       	 baseSalary=5000;
            bonus=2500;
            allowance=1250;
        default: // Default salary if grade is not recognized
       	 baseSalary=10000;
            bonus=0;
            allowance=0;
       	 
   	 }
   	 double totalSalary = baseSalary + bonus + allowance;
        return totalSalary;
        
    }

    // Implementing the work method from the Employee class
    @Override
    public void work() {
        // Add specific work behavior for maintenance staff
        this.setPriority("High");
    }
}

