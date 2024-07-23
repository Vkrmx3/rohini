package com.employee.dao;

import java.util.ArrayList;
import java.util.List;

import com.certificate.model.Certificate;
import com.department.model.Department;
import com.employee.model.Employee;
import com.employeeException.EmployeeException;

/**
 * This class manages employee data.
 * It can perform operations like adding , displaying , updating and deleting by id
 * and stored in here.
 */
public class EmployeeDao {
    private static List<Employee> employees = new ArrayList<Employee>();

    /** 
     * Add the employee records and store them in the employee list.
     * 
     * @param employee The Employee object to be added.
     * @throws EmployeeException If an error occurs while adding the employee.
     */
    public void addEmployee(Employee employee) throws EmployeeException {
        try {
            employees.add(employee);
        } catch (Exception e) {
            System.out.println("Can't add employee details");
            throw new EmployeeException("Unable to add employee with ID: ", e);
        }
    }

    /** 
     * Get all employee records.
     * 
     * @return List of all employees.
     */
    public List<Employee> getAllEmployees() {
        return employees; 
    }

    /** 
     * Get employee by ID.
     * 
     * @param employeeId The ID of the employee to retrieve.
     * @return The Employee object, or null if not found.
     * @throws EmployeeException If an error occurs while retrieving the employee.
     */
    public Employee getEmployeeById(int employeeId) throws EmployeeException {
        try {
            for (Employee employee : employees) {
                if (employee.getEmployeeId() == employeeId) {
                    return employee;
                }
            }
        return null;
        } catch (Exception e) {
            System.out.println("Can't get employee details by employee id");
            throw new EmployeeException("Error retrieving employee with ID: ", e);
        }
    }

    /** 
     * Update employee details.
     * 
     * @param employee The Employee object with updated details.
     * @throws EmployeeException If the employee to be updated does not exist.
     */
     public void updateEmployee(Employee updatedEmployee) throws EmployeeException {
         try {
             for (Employee employee : employees) {
                 if (employee.getEmployeeId() == updatedEmployee.getEmployeeId()) {
                     employee.setEmployeeName(updatedEmployee.getEmployeeName());
                     employee.setEmployeeDOB(updatedEmployee.getEmployeeDOB());
                     employee.setContactNumber(updatedEmployee.getContactNumber());
                     employee.setMailId(updatedEmployee.getMailId());
                     employee.setExperience(updatedEmployee.getExperience());
                     employee.setSalary(updatedEmployee.getSalary());
                     employee.setCity(updatedEmployee.getCity());
                     return;
                }
            }
        } catch (Exception e) {
            System.out.println("Update employee details ");
            throw new EmployeeException("Error retrieving employee with ID: ", e);
        }
    }

    /** 
     * Delete an employee by ID.
     * 
     * @param employeeId The ID of the employee to delete.
     * @throws EmployeeException If the employee to be deleted does not exist.
     */
    public void deleteEmployee(int employeeId) throws EmployeeException {
        try {
            for (Employee employee : employees) {
                if (employee.getEmployeeId() == employeeId) {
                    employees.remove(employee);
                    return;
                } 
            }
        } catch (Exception e) {
            System.out.println("Can't delete employee details");
            throw new EmployeeException("Employee with ID: ", e);
        }
    }

    
    /**
     * Get employees by department ID.
     * 
     * @param departmentId the department ID
     * @return a list of employees in the specified department
     */
    /*public List<Employee> getEmployeesByDepartmentId(int departmentId) {
        try {
            List<Employee> departmentEmployees = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getDepartment().getDepartmentId() == departmentId) {
                   return de
                }
            }
            return departmentEmployees;
        } catch (Exception e) {
            System.out.println(" Can't get employees by department ID ");
            throw new EmployeeException("Department with ID: ", e);
        }
    }   */

    /**
     * Get employees by certificate ID.
     * 
     * @param certificateId the certificate ID
     * @return a list of employees with the specified certificate
     */
    public List<Employee> getEmployeesByCertificateId(int certificateId) throws EmployeeException {
        try {
            List<Employee> certificateEmployees = new ArrayList<>();
            for (Employee employee : employees) {
                for (Certificate certificate : employee.getCertificates()) {
                    if (certificate.getCertificateId() == certificateId) {
                        certificateEmployees.add(employee);
                        break;
                    }
                }
            }
            return certificateEmployees;
        } catch (Exception e) {
            System.out.println("Can't get employee details by certificate Id");
            throw new EmployeeException("certificate with ID: ", e);
        }
    }

    public Department getDepartmentByEmployeeId(int employeeId)throws EmployeeException {
        try {
            for(Employee employee : employees) {
                if (employee.getEmployeeId() == employeeId) {
                    return employee.getDepartment();
                } 
            }
            return null;
        } catch (Exception e) {
            System.out.println("Can't get department details by employee Id");
            throw new EmployeeException("employee with ID: ", e);
        }   
    }
}
