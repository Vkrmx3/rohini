package com.certificate.controller;

import java.util.List;
import java.util.Scanner;

import com.certificate.model.Certificate;
import com.certificate.service.CertificateService;
import com.certificate.service.CertificateServiceImpl;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import com.employee.service.EmployeeServiceImpl;
import com.employeeException.EmployeeException;

/** 
* This class perfomrs the action of certificate details like getting the id & name 
* from user, display all certificates, displa by id, updating and deleting operations
* and also add certificate details to employee , display employee by certificate, display certificate by employee
*
* @ author DHARANI
* @version 1.0
*/
public class CertificateController {
    Scanner scanner = new Scanner(System.in);
    CertificateService certificateService = new CertificateServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();

    public void getCertificateDetails() {
        while (true) {
            System.out.println("\nCertificate Menu:");
            System.out.println("1. Add Certificate");
            System.out.println("2. Display All Certificates");
            System.out.println("3. Display Certificate by ID");
            System.out.println("4. Update Certificate");
            System.out.println("5. Delete Certificate");
            System.out.println("6. Add Certificate to Employee");
            System.out.println("7. Display Employees by Certificate");
            System.out.println("8. Display Certificates by Employee");
            System.out.println("9. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    addCertificate();
                    break;
                case 2:
                    displayAllCertificates();
                    break;
                case 3:
                    displayCertificateById();
                    break;
                case 4:
                    updateCertificate();
                    break;
                case 5:
                    deleteCertificate();
                    break;
                case 6:
                    addCertificateToEmployee();
                    break;
                case 7:
                    displayEmployeesByCertificate();
                    break;
                case 8:
                    displayCertificatesByEmployee();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
    * Add certificate
    */
    public void addCertificate() {
        System.out.print("Enter Certificate ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Certificate Name: ");
        String name = scanner.nextLine();
        try {
            certificateService.addCertificate(id, name);
            System.out.println("Certificate added successfully.");
        } catch (EmployeeException e) {
            System.out.println("Unable to add certificates");
        }
    }

    /**
    * Display all certificates
    */
    public void displayAllCertificates() {
        try {
            List<Certificate> certificates = certificateService.getAllCertificates();
            if (certificates.isEmpty()) {
                System.out.println("No certificates found.");
            } else {
                for(Certificate certificate : certificates) {
                    System.out.println(certificate);
                }
            }
        } catch (EmployeeException e) {
            System.out.println("Can't display all certificates");
        }
    }

    /**
    * Display certificate by ID
    */
    public void displayCertificateById() {
        System.out.print("Enter Certificate ID: ");
        int id = scanner.nextInt();
        try {
            Certificate certificate = certificateService.getCertificateById(id);
            if (certificate != null) {
                System.out.println(certificate);
            } else {
                System.out.println("Certificate with ID " + id + " not found.");
            }
        } catch (EmployeeException e) {
            System.out.println("Can't display by certificate id");
        }
    }

    /**
    * Update certificate
    */
    public void updateCertificate() {
        System.out.print("Enter Certificate ID to Update: ");
        int certificateId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter New Certificate Name: ");
        String newName = scanner.nextLine();
        try {
            certificateService.updateCertificate(certificateId, newName);
            System.out.println("Certificate updated successfully.");
        } catch (EmployeeException e) {
            System.out.println("Can't update Certificate");
        }
    }

    /**
    * Delete certificate  
    */
    public void deleteCertificate() {
        System.out.print("Enter Certificate ID to Delete: ");
        int id = scanner.nextInt();
        try {
            certificateService.deleteCertificate(id);
            System.out.println("Certificate deleted successfully.");
        } catch (EmployeeException e) {
            System.out.println("Can't delete certificate");
        }
    }

    /**
    * Add certificate to employee
    */
    public void addCertificateToEmployee() {
        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();
        System.out.print("Enter Certificate ID: ");
        int certificateId = scanner.nextInt();

        try {
            certificateService.addEmployeeToCertificate(certificateId, employeeService.getEmployeeById(employeeId));
            System.out.println("Certificate added to employee successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
    * Display employees by certificate
    */
    public void displayEmployeesByCertificate() {
        System.out.print("Enter Certificate ID: ");
        int certificateId = scanner.nextInt();
        try {
            List<Employee> employees = certificateService.getEmployeesByCertificate(certificateId);
            if (employees.isEmpty()) {
                System.out.println("No employees found for Certificate ID " + certificateId);
            } else {
                employees.forEach(System.out::println);
            }
        } catch (EmployeeException e) {
            System.out.println("Can't display employees by certificate id");
        }
    }

    /** 
    * Display certificates by employee
    */
    public void displayCertificatesByEmployee() {
        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();
        try {
            List<Certificate> certificates = certificateService.getCertificatesByEmployeeId(employeeId);
            if (certificates.isEmpty()) {
                System.out.println("No certificates found for Employee ID " + employeeId);
            } else {
                certificates.forEach(System.out::println);
            }
        } catch (EmployeeException e) {
            System.out.println("Can't display certificate by employee");
        }
    }
}
