package com.employee.controller;

import java.util.List;
import java.util.Scanner;

import com.certificate.model.Certificate;
import com.certificate.service.CertificateService;
import com.certificate.service.CertificateServiceImpl;
import com.department.model.Department;
import com.department.service.DepartmentService;
import com.department.service.DepartmentServiceImpl;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import com.employee.service.EmployeeServiceImpl;
import com.employeeException.EmployeeException;
import com.util.Validator;

/**
* Displays the Employee menu and handles user input for various employee-related operations.
* The menu includes options to add, display, update, delete employees, and manage certificates.
*/
public class EmployeeController {
    Scanner input = new Scanner(System.in);
    EmployeeService employeeService = new EmployeeServiceImpl();
    CertificateService certificateService = new CertificateServiceImpl();
    DepartmentService departmentService = new DepartmentServiceImpl();

    public void getEmployeeDetails() {
        while (true) {
            System.out.println("\nEmployee Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Display Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Manage Certificates");
            System.out.println("7. Manage Department");
            System.out.println("8. Back to Main Menu");
            
            int choice = input.nextInt();
            input.nextLine();
            
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayAllEmployees();
                    break;
                case 3:
                    displayEmployeeById();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    deleteEmployee();
                    break;
                case 6:
                    getCertificateDetails();
                    break;
                case 7:
                    getDepartmentDetails();
                    break;
                case 8:
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
    * Add Employee details into employee object getting from user as employee id and employee name
    */
    public void addEmployee() {
        System.out.println("Add Employee Records");
        System.out.println("Enter Employee ID:");
        int employeeId = input.nextInt();
        input.nextLine();
        boolean isFlag = true; 
        String employeeName = " ";
        while(isFlag) {
            System.out.println("Enter the Employee Name");
            employeeName = input.nextLine();
            if(Validator.isValidAlphabet(employeeName)) {
                isFlag = false;
            } else {
                System.out.println("Invalid.Enter valid Name");
            }
        } 
        isFlag = true;
        boolean isActive = true;
        int age = 0;
        String employeeDOB = " ";   
        while(isActive) {
            System.out.println("Enter DOB in DD/MM/YYYY format.");
            employeeDOB = input.nextLine(); 
            if(employeeDOB.matches("\\d{2}/\\d{2}/\\d{4}")) {
                age = Validator.calculateAge(employeeDOB);
                System.out.println("Employee's age: " + age);
                isActive = false;
            } else {
                System.out.println("Please enter DD/MM/YYYY format.");
            }
        }
        isActive = true;
        boolean isFound = true;
        long contactNumber = 0;
        while(isFound) {
            System.out.println("Enter the Employee Contact Number");
            contactNumber = input.nextLong();
            String contactNumberString = String.valueOf(contactNumber);
            if (Validator.isValidContact(contactNumberString)) {
                isFound = false;
            } else {
                System.out.println("Enter the valid Contact Number");
            }
        } 
        isFound = true;

        boolean isMail = true;
        input.nextLine();
        String mailId = " ";                
        while(isMail) {
            System.out.println("Enter the Employee Mail ID");
            mailId = input.nextLine();
            if(Validator.isValidMail(mailId)) {
                isMail = false;
            } else {
                System.out.println("Enter the valid Employee mail ID");
                input.nextLine();  
            }
        }
        isMail = true;
        boolean isExperienceCheck = true;
        int experience = 0;
        while (isExperienceCheck) {
            try{
                System.out.println("Enter the Employee Experience");
                experience = input.nextInt();
                isExperienceCheck = false;
            } catch (Exception e) {
                System.out.println("Invalid.Enter valid Experience");
                input.next();  
            }
        }
        isExperienceCheck = true;
        String department = " ";
        double salary = 0.00;
        boolean isSalaryCheck = true;
        while(isSalaryCheck) {
            try{
                System.out.println("Enter the Employee Salary");
                salary = input.nextDouble();
                isSalaryCheck = false;
            } catch (Exception e) {
                System.out.println("Invalid.Enter valid salary");
                input.next();  
            }
        }
        isSalaryCheck = true;
        boolean isCityCheck = true;
        String city = " ";
        while(isCityCheck) {
            System.out.println("Enter the Employee City");
            input.nextLine();
            city = input.nextLine();
            if(Validator.isValidAlphabet(city)) {
                isCityCheck = false;
            } else {
                System.out.println("Enter the valid Employee city");
                input.next();  
            }
        } 
        isCityCheck = true;
        try {
            employeeService.addEmployee(employeeId, employeeName, employeeDOB, contactNumber, 
                                        mailId, experience, salary, city); 
            System.out.println("Employee added successfully.");
            System.out.println("-----------------------------");
        } catch (EmployeeException e) {
            System.out.println( " unable to add ");
        }
    }

   
    /**
    * Display all employees present in employee list
    */
    public void displayAllEmployees() {
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            if (employees.isEmpty()) {
                System.out.println("No employees found.");
            } else {
                for(Employee employee : employees) {
                     System.out.println(employee);
                }
            }
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
    * Get employee id from user and display the particular employee records
    */
    public void displayEmployeeById() {
        System.out.print("Enter Employee ID: ");
        int id = input.nextInt();

        try {
            Employee employee = employeeService.getEmployeeById(id);
            if (employee != null) {
                System.out.println(employee);
            } else {
                System.out.println("Employee with ID " + id + " not found.");
            }
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }
    }

    
    /**
    * Update employee records by checking the employee id present in list
    */
    public void updateEmployee() {
        System.out.print("Enter Employee ID: ");
        int employeeId = input.nextInt();
        input.nextLine(); 
        System.out.print("Enter Employee Name: ");
        String employeeName = input.nextLine();
        System.out.print("Enter Employee DOB (yyyy-MM-dd): ");
        String employeeDOB = input.nextLine();
        System.out.print("Enter Employee Contact Number: ");
        long contactNumber = input.nextLong();
        input.nextLine(); 
        System.out.print("Enter Employee Mail ID: ");
        String mailId = input.nextLine();
        System.out.print("Enter Employee Experience: ");
        int experience = input.nextInt();
        System.out.print("Enter Employee Salary: ");
        double salary = input.nextDouble();
        input.nextLine(); 
        System.out.print("Enter Employee City: ");
        String city = input.nextLine();

        try {
            employeeService.updateEmployee(employeeId, employeeName, employeeDOB, 
                            contactNumber,  mailId, experience, 
                            salary,city);
            System.out.println("Employee updated successfully.");
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
    * Delete employee record by checking the employee id contains in employee list
    */
    public void deleteEmployee() {
        System.out.print("Enter Employee ID: ");
        int employeeId = input.nextInt();
        try {
            employeeService.deleteEmployee(employeeId);
            System.out.println("Employee deleted successfully.");
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }
    }

    /** 
    * Manage certificates:
    * 1. Add Certificate to Employee
    * 2. Get Employees by Certificate ID
    * 3. Back to Employee Menu
    */
    public void getCertificateDetails() {
        while (true) {
            System.out.println("\nCertificate Menu:");
            System.out.println("1. Add Certificate to Employee");
            System.out.println("2. Get Employees by Certificate ID");
            System.out.println("3. Back to Employee Menu");
            
            int choice = input.nextInt();
            input.nextLine();
            
            switch (choice) {
                case 1:
                    addCertificateToEmployee();
                    break;
                case 2:
                    getEmployeesByCertificateId();
                    break;
                case 3:
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /** 
    * Add certificate to employee
    */
    public void addCertificateToEmployee() {
        System.out.print("Enter Employee ID: ");
        int employeeId = input.nextInt();
        System.out.print("Enter Certificate ID: ");
        int certificateId = input.nextInt();
        try {
            Certificate certificate = certificateService.getCertificateById(certificateId);
            employeeService.addCertificateToEmployee(employeeId, certificate);
            System.out.println("Certificate added to employee successfully.");
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
    * Get employees by certificate ID
    */
    public void getEmployeesByCertificateId() {
        System.out.print("Enter Certificate ID: ");
        int certificateId = input.nextInt();
        try {
            List<Employee> employees = employeeService.getEmployeesByCertificateId(certificateId);
            if (employees.isEmpty()) {
                System.out.println("No employees found for Certificate ID " + certificateId);
            } else {
                for(Employee employee : employees) {
                    System.out.println(employee);
                }
            }
        } catch (EmployeeException e) {
             System.out.println(e.getMessage());
        }
    }

    public void getDepartmentDetails() {
        while (true) {
            System.out.println("\nDepartment Menu:");
            System.out.println("1. Get department by employee id");
            System.out.println("2. Get Employees by department ID");
            System.out.println("3. Back to Employee Menu");
            
            int choice = input.nextInt();
            input.nextLine();
            
            switch (choice) {
                case 1:
                    getDepartmentByEmployeeId();
                    break;
                case 2:
                    getEmployeesByDepartmentId();
                    break;
                case 3:
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
    }

    public void getDepartmentByEmployeeId() {
            int employeeId = input.nextInt();
            try {
                Department departmentByEmployeeId = employeeService.getDepartmentByEmployeeId(employeeId);
                System.out.println(departmentByEmployeeId);
            } catch (EmployeeException e) {
                 System.out.println("Can't get departments details by employee id");
            }
        }

        public void getEmployeesByDepartmentId() {
            int departmentId = input.nextInt();
            try {
                List<Employee> employeesByDepartmentId = employeeService.getEmployeesByDepartmentId(departmentId);
                if (employeesByDepartmentId.isEmpty()) {
                    System.out.println("No employees found for department ID " + departmentId);
                } else {
                    for(Employee employee : employeesByDepartmentId) {
                        System.out.println(employee);
                    }
                }
            } catch (EmployeeException e) {
                System.out.println("Can't get employee details by department id");
            }
        }
}
