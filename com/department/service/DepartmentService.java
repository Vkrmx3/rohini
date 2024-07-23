package com.department.service;

import java.util.List;

import com.department.dao.DepartmentDao;
import com.department.model.Department;
import com.employeeException.EmployeeException;

/**
 * Service interface for managing department-related operations.
 * Define only method declaration only, the implementation in service class
 */
public interface DepartmentService {
    public void addDepartment(int departmentId, String departmentName) throws EmployeeException;
    public List<Department> getAllDepartments()throws EmployeeException;
    public Department getDepartmentById(int departmentId)throws EmployeeException;
    public void updateDepartment(int departmentId, String departmentNewName)throws EmployeeException;
    public void deleteDepartment(int departmentId)throws EmployeeException;
}