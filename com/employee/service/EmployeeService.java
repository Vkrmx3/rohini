package com.employee.service;

import java.util.List;

import com.certificate.model.Certificate;
import com.department.model.Department;
import com.employee.model.Employee;
import com.employeeException.EmployeeException;
import com.employee.service.EmployeeServiceImpl;

/**
* It holds employee Service interface where only define the declaration of the methods,
* 
*/
public interface EmployeeService {
    public void addEmployee(int employeeId, String employeeName, String employeeDOB, 
                            long contactNumber, String mailId, int experience, 
                            double salary, String city) throws EmployeeException;
    public List<Employee> getAllEmployees() throws EmployeeException;
    public Employee getEmployeeById(int employeeId) throws EmployeeException;
    public void updateEmployee(int employeeId, String employeeName, String employeeDOB, 
                               long contactNumber, String mailId, int experience, 
                               double salary, String city) throws EmployeeException;
    public void deleteEmployee(int employeeId) throws EmployeeException;
    public void addCertificateToEmployee(int employeeId, Certificate certificate) throws EmployeeException;
    public List<Employee> getEmployeesByDepartmentId(int departmentId) throws EmployeeException;
    public List<Employee> getEmployeesByCertificateId(int certificateId) throws EmployeeException;
    public Department getDepartmentByEmployeeId(int employeeId) throws EmployeeException;
}