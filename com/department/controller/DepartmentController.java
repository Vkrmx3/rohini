package com.department.controller;

import java.util.List;
import java.util.Scanner;

import com.department.model.Department;
import com.department.service.DepartmentService;
import com.department.service.DepartmentServiceImpl;
import com.employeeException.EmployeeException;

/**
* The class used for user input for department details.
* Adding the departments, displaying, updating and deleting the details by department id
*/
public class DepartmentController {
    Scanner scanner = new Scanner(System.in);
    DepartmentService departmentService = new DepartmentServiceImpl();
    
    /**
    * Getting department details like deparmtent id, department name 
    * It can do the functionalities like add, display, update and deleting by departments
    */
    public void getDepartmentDetails() {
        while (true) {
            System.out.println("\nDepartment Menu:");
            System.out.println("1. Add Department");
            System.out.println("2. Display Departments");
            System.out.println("3. Update Department");
            System.out.println("4. Delete Department");
            System.out.println("5. Back to Main Menu");

            int deptChoice = scanner.nextInt();
            scanner.nextLine();

            switch (deptChoice) {
                case 1:
                    addDepartment();
                    break;
                case 2:
                    displayDepartments();
                    break;
                case 3:
                    updateDepartment();
                    break;
                case 4:
                    deleteDepartment();
                    break;
                case 5:
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
    * Add department
    */
    public void addDepartment() {
        System.out.print("Enter Department ID: ");
        int departmentId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Department Name: ");
        String departmentName = scanner.nextLine();
        try {
            departmentService.addDepartment(departmentId, departmentName);
            System.out.println("Department added successfully.");
        } catch (EmployeeException e) {
            System.out.println("Unable to add department");
        }
    }

    /**
    * Display all departments
    */
    public void displayDepartments() {
        try {
            List<Department> departments = departmentService.getAllDepartments();
            if (departments.isEmpty()) {
                System.out.println("No departments found.");
            } else {
                for(Department department :departments) {
                    System.out.println(department);
                }
            }
        } catch (EmployeeException e) {
            System.out.println("Unable to display department");
        }
    }

    /**
    * Update department
    */
    public void updateDepartment() {
      
            System.out.print("Enter Department ID to Update: ");
            int departmentId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter New Department Name: ");
            String departmentNewName = scanner.nextLine();
        try {
            departmentService.updateDepartment(departmentId, departmentNewName);
            System.out.println("Department updated successfully.");
        } catch (EmployeeException e) {
            System.out.println("Unable to update departmentId");
        }
    }

    /**
    * Delete department
    */
    public void deleteDepartment() {
        System.out.print("Enter Department ID to Delete: ");
        int departmentId = scanner.nextInt();
        try {
            departmentService.deleteDepartment(departmentId);
            System.out.println("Department deleted successfully.");
        } catch (EmployeeException e) {
            System.out.println("Unable to delete the department");
        }
    }

    
}
