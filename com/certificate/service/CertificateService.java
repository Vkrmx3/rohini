package com.certificate.service;

import java.util.ArrayList;
import java.util.List;

import com.certificate.dao.CertificateDao;
import com.certificate.model.Certificate;
import com.certificate.service.CertificateService;
import com.employee.model.Employee;
import com.employeeException.EmployeeException;

/**
 * Service interface for managing certificate-related operations.
 * It holds all the function declaration of service class.
 */
public interface CertificateService {
    
    public void addCertificate(int certificateId, String certificateName)  throws EmployeeException;
    public List<Certificate> getAllCertificates() throws EmployeeException;
    public Certificate getCertificateById(int certificateId) throws EmployeeException;
    public void updateCertificate(int certificateId, String certificateName) throws EmployeeException;
    public void deleteCertificate(int certificateId) throws EmployeeException;
    public void addEmployeeToCertificate(int certificateId, Employee employee) throws EmployeeException;
    public List<Employee> getEmployeesByCertificate(int certificateId) throws EmployeeException;
    public List<Certificate> getCertificatesByEmployeeId(int employeeId) throws EmployeeException;
}
