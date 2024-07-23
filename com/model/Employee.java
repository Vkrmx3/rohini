package com.model;

import java.util.ArrayList;
import java.util.List;

import com.certificate.model.Certificate;
import com.department.model.Department;
import com.util.Validator;

/**
* This class consists of employee records entity
*
* Represents the employee object that contains details like id, namen dob,
* contact number, mail id, experience , department which contains id & name,
*  salary, city, age & certificates contains id and name 
*
* Created constructor and getter ,setter method 
* toString method -> give format of output to the end user
* 
* @author DHARANI G
* @ version 1.0
*/
public class Employee {
    private int employeeId;
    private String employeeName;
    private String employeeDOB;
    private long contactNumber;
    private String mailId;
    private int experience;
    private Department department;
    private double salary;
    private String city;
    private int age;
    public boolean isRemoved = true;
    private List<Certificate> certificates;

    public Employee(int employeeId, String employeeName, String employeeDOB, 
             long contactNumber, String mailId, int experience,
             double salary, String city) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDOB = employeeDOB;
        this.contactNumber = contactNumber;
        this.mailId = mailId;
        this.experience = experience;
        this.salary = salary;
        this.city = city;
        certificates = new ArrayList<>();
    }

    public int getEmployeeId() {
        return employeeId;
    }
  
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
  
    public String getEmployeeName() {
        return employeeName;
    }
  
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDOB() {
        return employeeDOB;
     }
  
    public void setEmployeeDOB(String employeeDOB) {
        this.employeeDOB = employeeDOB;
    }

    public long getContactNumber() {
        return contactNumber;
    }
  
    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }
 
    public String getMailId() {
        return mailId;
    }

    public void setMailId(String MailId) {
        this.mailId = mailId;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience= experience;
    }
    
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return Validator.calculateAge(employeeDOB);
    }   

    public void setAge(int age) {
        this.age = age;    
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void addCertificate(Certificate certificate) {
        certificates.add(certificate);
    }

    public String toString() {
        return "\nEmployee Id = " + employeeId + 
                ",\nEmployee Name = '" + employeeName 
                + '\'' + ",\nEmployee age = '" + getAge()
                + ",\nContact Number = " + contactNumber 
                + ",\nMail Id = '" + mailId + '\'' 
                +",\nExperience = " + experience 
                +", \n Department = " + department 
                + ",\nSalary = " + salary + 
                ",\nCity = '" + city + '\'';
        
    }

    /**
    * Soft delete
    */
    public void isSetRemoved() {
        this.isRemoved = false;    
    }       
}


