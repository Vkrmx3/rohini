package com.certificate.service;

import java.util.ArrayList;
import java.util.List;

import com.certificate.dao.CertificateDao;
import com.certificate.model.Certificate;
import com.certificate.service.CertificateService;
import com.employee.model.Employee;
import com.employeeException.EmployeeException;

/**
 * Service class for managing certificate-related operations.
 * It holds all the implementation of the interface and getting details from user through controller and 
 * sent to dao for storing data
 */
public class CertificateServiceImpl implements CertificateService {
    CertificateDao certificateDao = new CertificateDao();

    /**
    * Add a certificate
    * @param certificateId  -> certificateId from user
    * @param certificateName -> certificateName from user
    * @throws EmployeeException if there is an error adding the certificate
    */
    public void addCertificate(int certificateId, String certificateName)  throws EmployeeException {
        Certificate certificate = new Certificate(certificateId, certificateName);
        certificateDao.addCertificate(certificate);
    }

    /**
    * Get all certificates
    * @return a list of all certificates
    */
    public List<Certificate> getAllCertificates() throws EmployeeException {
        return certificateDao.getAllCertificates();
    }

    /**
    * Get a certificate by ID
    *
    *  @param certificateId the ID of the certificate
    * @return the certificate object
    * @throws EmployeeException if the certificateId is not found
    */
    public Certificate getCertificateById(int certificateId) throws EmployeeException {
        return certificateDao.getCertificateById(certificateId);
    }

    /**
    * Update a certificate
    * @param certificateId   the ID of the certificate to update
    * @param certificateName the new name of the certificate
    * @throws EmployeeException if the certificate is not found
    */
    public void updateCertificate(int certificateId, String certificateName) throws EmployeeException {
        Certificate certificate = new Certificate(certificateId, certificateName);
        certificateDao.updateCertificate(certificate);
    }

    /** Delete a certificate
    *
    * @param certificateId   the ID of the certificate to update
    * @throws EmployeeException if the certificate is not found
    */
    public void deleteCertificate(int certificateId) throws EmployeeException {
        certificateDao.deleteCertificate(certificateId);
    }

    /** Add employee to certificate
    *
    * @param certificateId   the ID of the certificate
    * @param employee         add certifcate into employee object 
    * @throws EmployeeException if the certificate is not found
    */
    public void addEmployeeToCertificate(int certificateId, Employee employee) throws EmployeeException {
        Certificate certificate = certificateDao.getCertificateById(certificateId);
        if (certificate != null) {
            certificate.addEmployee(employee);
        }
    }

    /**
    * Get employees by certificate ID
    * 
    * @param certificateId ->the ID of the certificate
    */
    public List<Employee> getEmployeesByCertificate(int certificateId) throws EmployeeException {
        Certificate certificate = certificateDao.getCertificateById(certificateId);
        if (certificate != null) {
            return certificate.getEmployees();
        }
        return new ArrayList<>();
    }

    /**
    * Get certificates by employee ID
    *
    * @param employeeId -> Get certificates by employee ID
    */
    public List<Certificate> getCertificatesByEmployeeId(int employeeId) throws EmployeeException {
        List<Certificate> result = new ArrayList<>();
        for (Certificate certificate : certificateDao.getAllCertificates()) {
            for (Employee employee : certificate.getEmployees()) {
                if (employee.getEmployeeId() == employeeId) {
                    result.add(certificate);
                    break;
                }
            }
        }
        return result;
    }
}
