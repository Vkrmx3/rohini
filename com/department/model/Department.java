package com.department.model;

import java.util.ArrayList;
import java.util.List;

import com.employee.model.Employee;

/** 
* This class consists of department entity as Object
* Entitites which contains in Department object
* are defined as private specifier for secure 
*
* Represents the department which contains id & name, 
*
* Created constructor and getter ,setter method 
* toString method -> give format of output to the end user
* 
* @author DHARANI G
* @ version 1.0
*/

public class Department {
    private int departmentId;
    private String departmentName;
    private List<Employee> employees;

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        employees = new ArrayList<>();
    }
                       	
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
  
    public String getDepartmentName() {
        return departmentName;   
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String toString() {
        return "department Id = " + departmentId +
               "department Name = " + departmentName;
                
        
    }
}