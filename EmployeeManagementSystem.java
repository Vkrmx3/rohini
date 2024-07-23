import java.util.Scanner;

import com.employee.controller.EmployeeController;
import com.department.controller.DepartmentController;
import com.certificate.controller.CertificateController;

/**
* This class is the main application that run Employee Management System 
* contains employee details, certificate and department updation 
*/
public class EmployeeManagementSystem {
    Scanner scanner = new Scanner(System.in);
    EmployeeController employeeController = new EmployeeController();
    DepartmentController departmentController = new DepartmentController();
    CertificateController certificateController = new CertificateController();
    
    public void start() {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Manage Employees");
            System.out.println("2. Manage Departments");
            System.out.println("3. Manage Certificates");
            System.out.println("4. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    employeeController.getEmployeeDetails();
                    break;
                case 2:
                    departmentController.getDepartmentDetails();
                    break;
                case 3:
                    certificateController.getCertificateDetails();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static void main(String[] args) {
        new EmployeeManagementSystem().start();
    }
}
