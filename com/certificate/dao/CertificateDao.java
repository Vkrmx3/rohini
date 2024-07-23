package com.certificate.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.certificate.model.Certificate;
import com.employee.model.Employee;
import com.employeeException.EmployeeException;

/**
 * This class for managing certificate data.
 */
public class CertificateDao {
    private static List<Certificate> certificates = new ArrayList<>();

    /**
     * Add the certificate details in certificate list
     *
     * @param certificate The certificate object to be added.
     * @throws EmployeeException If an error occurs while adding the certificate.
     */
    public void addCertificate(Certificate certificate)throws EmployeeException {
        try {
            certificates.add(certificate);
        } catch (Exception e) {
            System.out.println("Unable to add certificate");
            throw new EmployeeException("Unable to add certificate with ID: ", e);
        }
    }

    /**
     * Get all the certificates
     * 
     * @return List of all certificates
     */
    public List<Certificate> getAllCertificates()throws EmployeeException {
        try {
            return certificates;
        } catch (Exception e) {
            System.out.println("Unable to display certificates");
            throw new EmployeeException("Unable to display certificate", e);
        }
    }

    /**
     * Get the certificates by Id
     */
    public Certificate getCertificateById(int certificateId)throws EmployeeException {
        try {
            for (Certificate certificate : certificates) {
                if (certificate.getCertificateId() == certificateId) {
                    return certificate;
                }
            }
        } catch (Exception e) {
            System.out.println("Certificate does not exist");
            throw new EmployeeException("Certificate does not exist",e);
        }
        return null;
    }

    /**
     * Update certificate by Id
     * @param certificateId The ID of the department to update.
     * @param certificateName The new name of the department.
     * @throws EmployeeException If the department does not exist.
     */
    public void updateCertificate(Certificate certificate)throws EmployeeException {
        try {
            Iterator<Certificate> iterator = certificates.iterator();
            while (iterator.hasNext()) {
                Certificate certificateUpdate = iterator.next();
                if (certificateUpdate.getCertificateId() == certificate.getCertificateId()) {
                    certificateUpdate.setCertificateName(certificate.getCertificateName());
                    return;
                }
            }
            System.out.println("Certificate id not available");
        } catch (Exception e) {
            System.out.println("Unable to update certificate");
            throw new EmployeeException("certificate with ID: " ,e);
        }
    }

    /**
    * Delete the certificates by Id
    * 
    * @param certificatesId The ID of the certificates to delete.
    * @throws EmployeeException If the certificates does not exist.
    */
    public void deleteCertificate(int certificateId)throws EmployeeException {
        try {
            Iterator<Certificate> iterator = certificates.iterator();
            while (iterator.hasNext()) {
                Certificate certificateIterator = iterator.next();
                if (certificateIterator.getCertificateId() == certificateId) {
                    iterator.remove();
                    return;
                }
            }
            System.out.println("Certificate id does not exist");
        } catch (Exception e) {
            System.out.println("Unable to Delete the certificates by Id ");
            throw new EmployeeException("certificate with ID  does not exist ", e);
        }
    }

    /** Method to get employees by certificate
    *
    * @param certificateId The ID of the certificate to get employees by certificate
    * @return The employee object, or null if not found.
    * @throws EmployeeException If an error occurs while retrieving the department.
    */
    public List<Employee> getEmployeesByCertificate(int certificateId) throws EmployeeException {
        List<Employee> employees = new ArrayList<>();
        try {
            for (Certificate certificate : certificates) {
                if (certificate.getCertificateId() == certificateId) {
                    employees.addAll(certificate.getEmployees());
                    return employees;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("Certificate Id not found");
            throw new EmployeeException("Certificate ID not found.", e);
        }
    }
}
