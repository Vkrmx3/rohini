package com.department.dao;

import java.util.ArrayList;
import java.util.List;

import com.department.model.Department;
import com.employeeException.EmployeeException;
import com.employee.model.Employee;

/**
* DepartmentDao class used to manage department objects.
* Stores the department data here
*/
public class DepartmentDao {
    private static List<Department> departments = new ArrayList<>();

    /** 
     * Add a department to the list.
     * 
     * @param department The Department object to be added.
     * @throws EmployeeException If an error occurs while adding the department.
     */
    public void addDepartment(Department department) throws EmployeeException {
        try {
            departments.add(department);
        } catch (Exception e) {
            System.out.println("Unable to add department");
            throw new EmployeeException("Unable to add department with ID: " , e);
        }
    }

    /** 
     * Get all departments.
     * 
     * @return List of all departments.
     */
    public List<Department> getAllDepartments() throws EmployeeException {
        try {
            return departments; 
        } catch (Exception e) {
            System.out.println("Unable to dispay department");
            throw new EmployeeException("Unable to display departments", e);
        }
    }

    /** 
    * Update department name by ID.
     * 
     * @param departmentId The ID of the department to update.
     * @param newName The new name of the department.
     * @throws EmployeeException If the department does not exist.
     */
    public void updateDepartment(int departmentId, String departmentNewName) throws EmployeeException {
        try {
            boolean found = false;
            for (Department department : departments) {
                if (department.getDepartmentId() == departmentId) {
                    department.setDepartmentName(departmentNewName);
                    found = true;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Unable to update department");
            throw new EmployeeException("Department with ID does not exist ", e);
        }
    }

    /**
    * Delete a department by ID.
    * 
    * @param departmentId The ID of the department to delete.
    * @throws EmployeeException If the department does not exist.
    */
    public void deleteDepartment(int departmentId) throws EmployeeException {
        try {
            Department departmentToRemove = null;
            for (Department department : departments) {
                if (department.getDepartmentId() == departmentId) {
                    departmentToRemove = department;
                    departments.remove(departmentToRemove);
                }
            }
        } catch (Exception e) {
            System.out.println("Unable to delete department");
            throw new EmployeeException("Department with ID doesn't exist ", e);
        }
    }

    /** 
    * Get a department by ID.
    * 
    * @param departmentId The ID of the department to retrieve.
    * @return The Department object, or null if not found.
    * @throws EmployeeException If an error occurs while retrieving the department.
    */
    public Department getDepartmentById(int departmentId) throws EmployeeException {
        try {
            for (Department department : departments) {
                if (department.getDepartmentId() == departmentId) {
                    return department;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("department with ID doesn't exists ");
            throw new EmployeeException("Department with ID doesn't exists ", e);
        }
    }

    /**
    * Get Employees By Department Id
    * 
    * @param departmentId The ID of the department to retrieve.
    * @return The employee list in Department object, or null if not found.
    * @throws EmployeeException If an error occurs while retrieving the department.
    *
    */
    public List<Employee> getEmployeesByDepartmentId (int departmentId) throws EmployeeException {
        try {
            for(Department department : departments) {
                if (department.getDepartmentId() == departmentId) {
                    return department.getEmployees();
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("department with ID doesn't exists ");
            throw new EmployeeException("Department with ID doesn't exists ", e);
        }     
    }
}
