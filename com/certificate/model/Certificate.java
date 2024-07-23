package com.certificate.model;

import java.util.ArrayList;
import java.util.List;
import com.employee.model.Employee;

/**
* This class contains certificate entity ie. certificate id, certifcate name and employees
* who are done that certificate
*
* Represents the certificates object contains id and name and list of employees
*
* Created constructor and getter ,setter method 
* toString method -> give format of output to the end user
* 
* @author DHARANI G
* @ version 1.0
*/
*/
public class Certificate {
    private int certificateId;
    private String certificateName;
    private List<Employee> employees = new ArrayList<>();

    public Certificate(int certificateId, String certificateName) {
        this.certificateId = certificateId;
        this.certificateName = certificateName;
    }

    public int getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(int certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String toString() {
        return "Certificates :" + 
               " Certificate Id= " + certificateId +
               " certificate Name= " + certificateName +
               "employees =" + employees ;
    } 
}
