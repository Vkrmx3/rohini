package com.employee.service;

import java.util.List;
 
import com.certificate.dao.CertificateDao;
import com.certificate.model.Certificate;
import com.department.dao.DepartmentDao;
import com.department.model.Department;
import com.employee.dao.EmployeeDao;
import com.employee.model.Employee;
import com.employeeException.EmployeeException;
import com.employee.service.EmployeeService;

/**
 * Service class for managing employee-related operations.
 * Implements the interface methods here, the definition for the interface holds
 * And perform adding, displaying, updating, deleting operations by employee id
 */
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDao();
    private DepartmentDao departmentDao = new DepartmentDao();
    private CertificateDao certificateDao = new CertificateDao(); 

    /**
     * Adds a new employee to the system.
     *
     * @param employeeId      the ID of the employee
     * @param employeeName    the name of the employee
     * @param employeeDOB     the date of birth of the employee
     * @param contactNumber   the contact number of the employee
     * @param mailId          the email ID of the employee
     * @param experience      the experience of the employee in years
     * @param salary          the salary of the employee
     * @param city            the city of the employee
     * @throws EmployeeException if there is an error adding the employee
     */
    public void addEmployee(int employeeId, String employeeName, String employeeDOB, 
                            long contactNumber, String mailId, int experience, 
                            double salary, String city) throws EmployeeException {
        Employee employee = new Employee(employeeId, employeeName, employeeDOB, 
                                         contactNumber, mailId, experience, salary, city);
        employeeDao.addEmployee(employee);
    }

    /**
     * Retrieves all employees.
     *
     * @return a list of all employees
     */
    public List<Employee> getAllEmployees() throws EmployeeException {
        return employeeDao.getAllEmployees();
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param employeeId the ID of the employee
     * @return the employee object
     * @throws EmployeeException if the employee is not found
     */
    public Employee getEmployeeById(int employeeId) throws EmployeeException {
        return employeeDao.getEmployeeById(employeeId);
    }

    /**
     * Updates an employee's name.
     *
     * @param employeeId   the ID of the employee to update
     * @param employeeName the new name of the employee
     * @throws EmployeeException if the employee is not found
     */
    public void updateEmployee(int employeeId, String employeeName, String employeeDOB, 
                               long contactNumber, String mailId, int experience, 
                               double salary, String city) throws EmployeeException {
        Employee employee = new Employee(employeeId, employeeName, employeeDOB, 
                                         contactNumber, mailId, experience, salary, city);
        employeeDao.updateEmployee(employee);
    }

     /**
     * Deletes an employee by their ID.
     *
     * @param employeeId the ID of the employee to delete
     * @throws EmployeeException if the employee is not found
     */
    public void deleteEmployee(int employeeId) throws EmployeeException {
        employeeDao.deleteEmployee(employeeId);
    }

    // Add certificate to an employee
     /**
     * Adds a certificate to an employee and vice versa.
     *
     * @param employeeId     the ID of the employee
     * @param certificateId  the ID of the certificate
     * @throws EmployeeException if the employee or certificate is not found
     */
    public void addCertificateToEmployee(int employeeId, Certificate certificate) throws EmployeeException {
        Employee employee = employeeDao.getEmployeeById(employeeId);
        if (employee == null) {
            throw new EmployeeException("Employee not found.", null);
        }
        //certificateDao.addCertificateToEmployee(employeeId, certificate);
    }


    // Get employees by department
    public List<Employee> getEmployeesByDepartmentId(int departmentId) throws EmployeeException {
        return departmentDao.getEmployeesByDepartmentId(departmentId);
    }

    // Get employees by certificate
    public List<Employee> getEmployeesByCertificateId(int certificateId) throws EmployeeException {
        return certificateDao.getEmployeesByCertificate(certificateId);
    }

    public Department getDepartmentByEmployeeId(int employeeId) throws EmployeeException {
        return employeeDao.getDepartmentByEmployeeId(employeeId);
    }
}
