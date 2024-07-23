package com.department.service;

import java.util.List;

import com.department.dao.DepartmentDao;
import com.department.model.Department;
import com.department.service.DepartmentService;
import com.employeeException.EmployeeException;

/**
 * Service class for managing department-related operations.
 * It implements the interface functions by department object
 */
public class DepartmentServiceImpl implements DepartmentService {
    DepartmentDao departmentDao = new DepartmentDao();

    /** Add a department
    *
    * @ param departmentId -> department id from user
    * @ param departmentName -> department name from user
    *
    */
    public void addDepartment(int departmentId, String departmentName) throws EmployeeException {
        Department department = new Department(departmentId, departmentName);
        departmentDao.addDepartment(department);
    }

    /**
    * Get all departments
    */
    public List<Department> getAllDepartments()throws EmployeeException {
        return departmentDao.getAllDepartments();
    }

    /**
    * Get a department by ID
    */
    public Department getDepartmentById(int departmentId)throws EmployeeException {
        return departmentDao.getDepartmentById(departmentId);
    }

    /**
    * Update a department
    */
    public void updateDepartment(int departmentId, String departmentNewName)throws EmployeeException {
        departmentDao.updateDepartment(departmentId, departmentNewName);
    }

    /**
    *Delete a department
    */
    public void deleteDepartment(int departmentId)throws EmployeeException {
        departmentDao.deleteDepartment(departmentId);
    }
}
